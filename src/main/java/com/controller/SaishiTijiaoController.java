
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 赛事提交
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishiTijiao")
public class SaishiTijiaoController {
    private static final Logger logger = LoggerFactory.getLogger(SaishiTijiaoController.class);

    private static final String TABLE_NAME = "saishiTijiao";

    @Autowired
    private SaishiTijiaoService saishiTijiaoService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//竞赛公告
    @Autowired
    private HuojiangService huojiangService;//获奖
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private PingshenService pingshenService;//评审
    @Autowired
    private PingshenFenpeiService pingshenFenpeiService;//评审分配
    @Autowired
    private PingshenPingfenService pingshenPingfenService;//评审打分
    @Autowired
    private SaishiService saishiService;//赛事
    @Autowired
    private SaishiYuyueService saishiYuyueService;//赛事报名
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhuanjiaService zhuanjiaService;//专家
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        else if("专家".equals(role))
            params.put("zhuanjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = saishiTijiaoService.queryPage(params);

        //字典表数据转换
        List<SaishiTijiaoView> list =(List<SaishiTijiaoView>)page.getList();
        for(SaishiTijiaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishiTijiaoEntity saishiTijiao = saishiTijiaoService.selectById(id);
        if(saishiTijiao !=null){
            //entity转view
            SaishiTijiaoView view = new SaishiTijiaoView();
            BeanUtils.copyProperties( saishiTijiao , view );//把实体数据重构到view中
            //级联表 赛事
            //级联表
            SaishiEntity saishi = saishiService.selectById(saishiTijiao.getSaishiId());
            if(saishi != null){
            BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaishiId(saishi.getId());
            }
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(saishiTijiao.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaoshiId(laoshi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(saishiTijiao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SaishiTijiaoEntity saishiTijiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishiTijiao:{}",this.getClass().getName(),saishiTijiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            saishiTijiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            saishiTijiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SaishiTijiaoEntity> queryWrapper = new EntityWrapper<SaishiTijiaoEntity>()
            .eq("saishi_id", saishiTijiao.getSaishiId())
            .eq("laoshi_id", saishiTijiao.getLaoshiId())
            .eq("yonghu_id", saishiTijiao.getYonghuId())
            .in("saishi_tijiao_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiTijiaoEntity saishiTijiaoEntity = saishiTijiaoService.selectOne(queryWrapper);
        if(saishiTijiaoEntity==null){
            saishiTijiao.setSaishiTijiaoYesnoTypes(1);
            saishiTijiao.setInsertTime(new Date());
            saishiTijiao.setCreateTime(new Date());
            saishiTijiaoService.insert(saishiTijiao);
            return R.ok();
        }else {
            if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishiTijiaoEntity saishiTijiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishiTijiao:{}",this.getClass().getName(),saishiTijiao.toString());
        SaishiTijiaoEntity oldSaishiTijiaoEntity = saishiTijiaoService.selectById(saishiTijiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            saishiTijiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            saishiTijiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(saishiTijiao.getSaishiShangchuanFile()) || "null".equals(saishiTijiao.getSaishiShangchuanFile())){
                saishiTijiao.setSaishiShangchuanFile(null);
        }

            saishiTijiaoService.updateById(saishiTijiao);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody SaishiTijiaoEntity saishiTijiaoEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,saishiTijiaoEntity:{}",this.getClass().getName(),saishiTijiaoEntity.toString());

        SaishiTijiaoEntity oldSaishiTijiao = saishiTijiaoService.selectById(saishiTijiaoEntity.getId());//查询原先数据

//        if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes() == 2){//通过
//            saishiTijiaoEntity.setSaishiTijiaoTypes();
//        }else if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes() == 3){//拒绝
//            saishiTijiaoEntity.setSaishiTijiaoTypes();
//        }
        saishiTijiaoService.updateById(saishiTijiaoEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishiTijiaoEntity> oldSaishiTijiaoList =saishiTijiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saishiTijiaoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<SaishiTijiaoEntity> saishiTijiaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SaishiTijiaoEntity saishiTijiaoEntity = new SaishiTijiaoEntity();
//                            saishiTijiaoEntity.setSaishiTijiaoUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            saishiTijiaoEntity.setSaishiId(Integer.valueOf(data.get(0)));   //赛事 要改的
//                            saishiTijiaoEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            saishiTijiaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            saishiTijiaoEntity.setSaishiTijiaoText(data.get(0));                    //内容 要改的
//                            saishiTijiaoEntity.setSaishiShangchuanFile(data.get(0));                    //赛事作品 要改的
//                            saishiTijiaoEntity.setSaishiTijiaoYesnoTypes(Integer.valueOf(data.get(0)));   //提交状态 要改的
//                            saishiTijiaoEntity.setInsertTime(date);//时间
//                            saishiTijiaoEntity.setCreateTime(date);//时间
                            saishiTijiaoList.add(saishiTijiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("saishiTijiaoUuidNumber")){
                                    List<String> saishiTijiaoUuidNumber = seachFields.get("saishiTijiaoUuidNumber");
                                    saishiTijiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishiTijiaoUuidNumber = new ArrayList<>();
                                    saishiTijiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishiTijiaoUuidNumber",saishiTijiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<SaishiTijiaoEntity> saishiTijiaoEntities_saishiTijiaoUuidNumber = saishiTijiaoService.selectList(new EntityWrapper<SaishiTijiaoEntity>().in("saishi_tijiao_uuid_number", seachFields.get("saishiTijiaoUuidNumber")));
                        if(saishiTijiaoEntities_saishiTijiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishiTijiaoEntity s:saishiTijiaoEntities_saishiTijiaoUuidNumber){
                                repeatFields.add(s.getSaishiTijiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishiTijiaoService.insertBatch(saishiTijiaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = saishiTijiaoService.queryPage(params);

        //字典表数据转换
        List<SaishiTijiaoView> list =(List<SaishiTijiaoView>)page.getList();
        for(SaishiTijiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishiTijiaoEntity saishiTijiao = saishiTijiaoService.selectById(id);
            if(saishiTijiao !=null){


                //entity转view
                SaishiTijiaoView view = new SaishiTijiaoView();
                BeanUtils.copyProperties( saishiTijiao , view );//把实体数据重构到view中

                //级联表
                    SaishiEntity saishi = saishiService.selectById(saishiTijiao.getSaishiId());
                if(saishi != null){
                    BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishiId(saishi.getId());
                }
                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(saishiTijiao.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(saishiTijiao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody SaishiTijiaoEntity saishiTijiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishiTijiao:{}",this.getClass().getName(),saishiTijiao.toString());
        Wrapper<SaishiTijiaoEntity> queryWrapper = new EntityWrapper<SaishiTijiaoEntity>()
            .eq("saishi_tijiao_uuid_number", saishiTijiao.getSaishiTijiaoUuidNumber())
            .eq("saishi_id", saishiTijiao.getSaishiId())
            .eq("laoshi_id", saishiTijiao.getLaoshiId())
            .eq("yonghu_id", saishiTijiao.getYonghuId())
            .eq("saishi_tijiao_text", saishiTijiao.getSaishiTijiaoText())
            .in("saishi_tijiao_yesno_types", new Integer[]{1,2})
//            .notIn("saishi_tijiao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiTijiaoEntity saishiTijiaoEntity = saishiTijiaoService.selectOne(queryWrapper);
        if(saishiTijiaoEntity==null){
            saishiTijiao.setSaishiTijiaoYesnoTypes(1);
            saishiTijiao.setInsertTime(new Date());
            saishiTijiao.setCreateTime(new Date());
        saishiTijiaoService.insert(saishiTijiao);

            return R.ok();
        }else {
            if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(saishiTijiaoEntity.getSaishiTijiaoYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

