
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
 * 评审
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pingshen")
public class PingshenController {
    private static final Logger logger = LoggerFactory.getLogger(PingshenController.class);

    private static final String TABLE_NAME = "pingshen";

    @Autowired
    private PingshenService pingshenService;


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
    private PingshenFenpeiService pingshenFenpeiService;//评审分配
    @Autowired
    private PingshenPingfenService pingshenPingfenService;//评审打分
    @Autowired
    private SaishiService saishiService;//赛事
    @Autowired
    private SaishiTijiaoService saishiTijiaoService;//赛事提交
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
        PageUtils page = pingshenService.queryPage(params);

        //字典表数据转换
        List<PingshenView> list =(List<PingshenView>)page.getList();
        for(PingshenView c:list){
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
        PingshenEntity pingshen = pingshenService.selectById(id);
        if(pingshen !=null){
            //entity转view
            PingshenView view = new PingshenView();
            BeanUtils.copyProperties( pingshen , view );//把实体数据重构到view中
            //级联表 赛事提交
            //级联表
            SaishiTijiaoEntity saishiTijiao = saishiTijiaoService.selectById(pingshen.getSaishiTijiaoId());
            if(saishiTijiao != null){
            BeanUtils.copyProperties( saishiTijiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaishiTijiaoId(saishiTijiao.getId());
            }
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(pingshen.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody PingshenEntity pingshen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pingshen:{}",this.getClass().getName(),pingshen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            pingshen.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PingshenEntity> queryWrapper = new EntityWrapper<PingshenEntity>()
            .eq("saishi_tijiao_id", pingshen.getSaishiTijiaoId())
            .eq("laoshi_id", pingshen.getLaoshiId())
            .eq("pingshen_zhidao", pingshen.getPingshenZhidao())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingshenEntity pingshenEntity = pingshenService.selectOne(queryWrapper);
        if(pingshenEntity==null){
            pingshen.setInsertTime(new Date());
            pingshen.setCreateTime(new Date());
            pingshenService.insert(pingshen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PingshenEntity pingshen, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pingshen:{}",this.getClass().getName(),pingshen.toString());
        PingshenEntity oldPingshenEntity = pingshenService.selectById(pingshen.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            pingshen.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(pingshen.getPingshenFile()) || "null".equals(pingshen.getPingshenFile())){
                pingshen.setPingshenFile(null);
        }

            pingshenService.updateById(pingshen);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PingshenEntity> oldPingshenList =pingshenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pingshenService.deleteBatchIds(Arrays.asList(ids));

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
            List<PingshenEntity> pingshenList = new ArrayList<>();//上传的东西
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
                            PingshenEntity pingshenEntity = new PingshenEntity();
//                            pingshenEntity.setPingshenUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            pingshenEntity.setSaishiTijiaoId(Integer.valueOf(data.get(0)));   //赛事提交 要改的
//                            pingshenEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            pingshenEntity.setPingshenFile(data.get(0));                    //参赛作品 要改的
//                            pingshenEntity.setPingshenZhidao(data.get(0));                    //指导老师 要改的
//                            pingshenEntity.setPingshenText(data.get(0));                    //内容 要改的
//                            pingshenEntity.setInsertTime(date);//时间
//                            pingshenEntity.setCreateTime(date);//时间
                            pingshenList.add(pingshenEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("pingshenUuidNumber")){
                                    List<String> pingshenUuidNumber = seachFields.get("pingshenUuidNumber");
                                    pingshenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pingshenUuidNumber = new ArrayList<>();
                                    pingshenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("pingshenUuidNumber",pingshenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<PingshenEntity> pingshenEntities_pingshenUuidNumber = pingshenService.selectList(new EntityWrapper<PingshenEntity>().in("pingshen_uuid_number", seachFields.get("pingshenUuidNumber")));
                        if(pingshenEntities_pingshenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingshenEntity s:pingshenEntities_pingshenUuidNumber){
                                repeatFields.add(s.getPingshenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pingshenService.insertBatch(pingshenList);
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
        PageUtils page = pingshenService.queryPage(params);

        //字典表数据转换
        List<PingshenView> list =(List<PingshenView>)page.getList();
        for(PingshenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PingshenEntity pingshen = pingshenService.selectById(id);
            if(pingshen !=null){


                //entity转view
                PingshenView view = new PingshenView();
                BeanUtils.copyProperties( pingshen , view );//把实体数据重构到view中

                //级联表
                    SaishiTijiaoEntity saishiTijiao = saishiTijiaoService.selectById(pingshen.getSaishiTijiaoId());
                if(saishiTijiao != null){
                    BeanUtils.copyProperties( saishiTijiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishiTijiaoId(saishiTijiao.getId());
                }
                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(pingshen.getLaoshiId());
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
    public R add(@RequestBody PingshenEntity pingshen, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,pingshen:{}",this.getClass().getName(),pingshen.toString());
        Wrapper<PingshenEntity> queryWrapper = new EntityWrapper<PingshenEntity>()
            .eq("pingshen_uuid_number", pingshen.getPingshenUuidNumber())
            .eq("saishi_tijiao_id", pingshen.getSaishiTijiaoId())
            .eq("laoshi_id", pingshen.getLaoshiId())
            .eq("pingshen_zhidao", pingshen.getPingshenZhidao())
            .eq("pingshen_text", pingshen.getPingshenText())
//            .notIn("pingshen_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingshenEntity pingshenEntity = pingshenService.selectOne(queryWrapper);
        if(pingshenEntity==null){
            pingshen.setInsertTime(new Date());
            pingshen.setCreateTime(new Date());
        pingshenService.insert(pingshen);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

