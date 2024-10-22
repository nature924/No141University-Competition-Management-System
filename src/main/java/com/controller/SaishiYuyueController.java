
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
 * 赛事报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishiYuyue")
public class SaishiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(SaishiYuyueController.class);

    private static final String TABLE_NAME = "saishiYuyue";

    @Autowired
    private SaishiYuyueService saishiYuyueService;


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
    private SaishiTijiaoService saishiTijiaoService;//赛事提交
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
        PageUtils page = saishiYuyueService.queryPage(params);

        //字典表数据转换
        List<SaishiYuyueView> list =(List<SaishiYuyueView>)page.getList();
        for(SaishiYuyueView c:list){
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
        SaishiYuyueEntity saishiYuyue = saishiYuyueService.selectById(id);
        if(saishiYuyue !=null){
            //entity转view
            SaishiYuyueView view = new SaishiYuyueView();
            BeanUtils.copyProperties( saishiYuyue , view );//把实体数据重构到view中
            //级联表 赛事
            //级联表
            SaishiEntity saishi = saishiService.selectById(saishiYuyue.getSaishiId());
            if(saishi != null){
            BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaishiId(saishi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(saishiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(saishiYuyue.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaoshiId(laoshi.getId());
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
    public R save(@RequestBody SaishiYuyueEntity saishiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishiYuyue:{}",this.getClass().getName(),saishiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            saishiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            saishiYuyue.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SaishiYuyueEntity> queryWrapper = new EntityWrapper<SaishiYuyueEntity>()
            .eq("saishi_id", saishiYuyue.getSaishiId())
            .eq("yonghu_id", saishiYuyue.getYonghuId())
            .eq("laoshi_id", saishiYuyue.getLaoshiId())
            .in("saishi_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiYuyueEntity saishiYuyueEntity = saishiYuyueService.selectOne(queryWrapper);
        if(saishiYuyueEntity==null){
            saishiYuyue.setSaishiYuyueYesnoTypes(1);
            saishiYuyue.setInsertTime(new Date());
            saishiYuyue.setCreateTime(new Date());
            saishiYuyueService.insert(saishiYuyue);
            return R.ok();
        }else {
            if(saishiYuyueEntity.getSaishiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(saishiYuyueEntity.getSaishiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishiYuyueEntity saishiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishiYuyue:{}",this.getClass().getName(),saishiYuyue.toString());
        SaishiYuyueEntity oldSaishiYuyueEntity = saishiYuyueService.selectById(saishiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            saishiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            saishiYuyue.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            saishiYuyueService.updateById(saishiYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody SaishiYuyueEntity saishiYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,saishiYuyueEntity:{}",this.getClass().getName(),saishiYuyueEntity.toString());

        SaishiYuyueEntity oldSaishiYuyue = saishiYuyueService.selectById(saishiYuyueEntity.getId());//查询原先数据

//        if(saishiYuyueEntity.getSaishiYuyueYesnoTypes() == 2){//通过
//            saishiYuyueEntity.setSaishiYuyueTypes();
//        }else if(saishiYuyueEntity.getSaishiYuyueYesnoTypes() == 3){//拒绝
//            saishiYuyueEntity.setSaishiYuyueTypes();
//        }
        saishiYuyueEntity.setSaishiYuyueShenheTime(new Date());//审核时间
        saishiYuyueService.updateById(saishiYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishiYuyueEntity> oldSaishiYuyueList =saishiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saishiYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<SaishiYuyueEntity> saishiYuyueList = new ArrayList<>();//上传的东西
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
                            SaishiYuyueEntity saishiYuyueEntity = new SaishiYuyueEntity();
//                            saishiYuyueEntity.setSaishiYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            saishiYuyueEntity.setSaishiId(Integer.valueOf(data.get(0)));   //赛事 要改的
//                            saishiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            saishiYuyueEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            saishiYuyueEntity.setSaishiYuyueText(data.get(0));                    //报名理由 要改的
//                            saishiYuyueEntity.setSaishiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            saishiYuyueEntity.setSaishiYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            saishiYuyueEntity.setSaishiYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            saishiYuyueEntity.setInsertTime(date);//时间
//                            saishiYuyueEntity.setCreateTime(date);//时间
                            saishiYuyueList.add(saishiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("saishiYuyueUuidNumber")){
                                    List<String> saishiYuyueUuidNumber = seachFields.get("saishiYuyueUuidNumber");
                                    saishiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishiYuyueUuidNumber = new ArrayList<>();
                                    saishiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishiYuyueUuidNumber",saishiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<SaishiYuyueEntity> saishiYuyueEntities_saishiYuyueUuidNumber = saishiYuyueService.selectList(new EntityWrapper<SaishiYuyueEntity>().in("saishi_yuyue_uuid_number", seachFields.get("saishiYuyueUuidNumber")));
                        if(saishiYuyueEntities_saishiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishiYuyueEntity s:saishiYuyueEntities_saishiYuyueUuidNumber){
                                repeatFields.add(s.getSaishiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishiYuyueService.insertBatch(saishiYuyueList);
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
        PageUtils page = saishiYuyueService.queryPage(params);

        //字典表数据转换
        List<SaishiYuyueView> list =(List<SaishiYuyueView>)page.getList();
        for(SaishiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishiYuyueEntity saishiYuyue = saishiYuyueService.selectById(id);
            if(saishiYuyue !=null){


                //entity转view
                SaishiYuyueView view = new SaishiYuyueView();
                BeanUtils.copyProperties( saishiYuyue , view );//把实体数据重构到view中

                //级联表
                    SaishiEntity saishi = saishiService.selectById(saishiYuyue.getSaishiId());
                if(saishi != null){
                    BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishiId(saishi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(saishiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(saishiYuyue.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
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
    public R add(@RequestBody SaishiYuyueEntity saishiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishiYuyue:{}",this.getClass().getName(),saishiYuyue.toString());
        Wrapper<SaishiYuyueEntity> queryWrapper = new EntityWrapper<SaishiYuyueEntity>()
            .eq("saishi_yuyue_uuid_number", saishiYuyue.getSaishiYuyueUuidNumber())
            .eq("saishi_id", saishiYuyue.getSaishiId())
            .eq("yonghu_id", saishiYuyue.getYonghuId())
            .eq("laoshi_id", saishiYuyue.getLaoshiId())
            .eq("saishi_yuyue_text", saishiYuyue.getSaishiYuyueText())
            .in("saishi_yuyue_yesno_types", new Integer[]{1,2})
            .eq("saishi_yuyue_yesno_text", saishiYuyue.getSaishiYuyueYesnoText())
//            .notIn("saishi_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiYuyueEntity saishiYuyueEntity = saishiYuyueService.selectOne(queryWrapper);
        if(saishiYuyueEntity==null){
            saishiYuyue.setSaishiYuyueYesnoTypes(1);
            saishiYuyue.setInsertTime(new Date());
            saishiYuyue.setCreateTime(new Date());
        saishiYuyueService.insert(saishiYuyue);

            return R.ok();
        }else {
            if(saishiYuyueEntity.getSaishiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(saishiYuyueEntity.getSaishiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

