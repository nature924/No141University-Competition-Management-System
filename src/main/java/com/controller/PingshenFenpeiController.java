
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
 * 评审分配
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pingshenFenpei")
public class PingshenFenpeiController {
    private static final Logger logger = LoggerFactory.getLogger(PingshenFenpeiController.class);

    private static final String TABLE_NAME = "pingshenFenpei";

    @Autowired
    private PingshenFenpeiService pingshenFenpeiService;


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
        PageUtils page = pingshenFenpeiService.queryPage(params);

        //字典表数据转换
        List<PingshenFenpeiView> list =(List<PingshenFenpeiView>)page.getList();
        for(PingshenFenpeiView c:list){
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
        PingshenFenpeiEntity pingshenFenpei = pingshenFenpeiService.selectById(id);
        if(pingshenFenpei !=null){
            //entity转view
            PingshenFenpeiView view = new PingshenFenpeiView();
            BeanUtils.copyProperties( pingshenFenpei , view );//把实体数据重构到view中
            //级联表 评审
            //级联表
            PingshenEntity pingshen = pingshenService.selectById(pingshenFenpei.getPingshenId());
            if(pingshen != null){
            BeanUtils.copyProperties( pingshen , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhuanjiaId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setPingshenId(pingshen.getId());
            }
            //级联表 专家
            //级联表
            ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(pingshenFenpei.getZhuanjiaId());
            if(zhuanjia != null){
            BeanUtils.copyProperties( zhuanjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhuanjiaId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhuanjiaId(zhuanjia.getId());
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
    public R save(@RequestBody PingshenFenpeiEntity pingshenFenpei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pingshenFenpei:{}",this.getClass().getName(),pingshenFenpei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("专家".equals(role))
            pingshenFenpei.setZhuanjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PingshenFenpeiEntity> queryWrapper = new EntityWrapper<PingshenFenpeiEntity>()
            .eq("pingshen_id", pingshenFenpei.getPingshenId())
            .eq("zhuanjia_id", pingshenFenpei.getZhuanjiaId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingshenFenpeiEntity pingshenFenpeiEntity = pingshenFenpeiService.selectOne(queryWrapper);
        if(pingshenFenpeiEntity==null){
            pingshenFenpei.setInsertTime(new Date());
            pingshenFenpei.setCreateTime(new Date());
            pingshenFenpeiService.insert(pingshenFenpei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PingshenFenpeiEntity pingshenFenpei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pingshenFenpei:{}",this.getClass().getName(),pingshenFenpei.toString());
        PingshenFenpeiEntity oldPingshenFenpeiEntity = pingshenFenpeiService.selectById(pingshenFenpei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("专家".equals(role))
//            pingshenFenpei.setZhuanjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            pingshenFenpeiService.updateById(pingshenFenpei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PingshenFenpeiEntity> oldPingshenFenpeiList =pingshenFenpeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pingshenFenpeiService.deleteBatchIds(Arrays.asList(ids));

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
            List<PingshenFenpeiEntity> pingshenFenpeiList = new ArrayList<>();//上传的东西
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
                            PingshenFenpeiEntity pingshenFenpeiEntity = new PingshenFenpeiEntity();
//                            pingshenFenpeiEntity.setPingshenFenpeiUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            pingshenFenpeiEntity.setPingshenId(Integer.valueOf(data.get(0)));   //评审 要改的
//                            pingshenFenpeiEntity.setZhuanjiaId(Integer.valueOf(data.get(0)));   //专家 要改的
//                            pingshenFenpeiEntity.setPingshenFenpeiText(data.get(0));                    //内容 要改的
//                            pingshenFenpeiEntity.setInsertTime(date);//时间
//                            pingshenFenpeiEntity.setCreateTime(date);//时间
                            pingshenFenpeiList.add(pingshenFenpeiEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("pingshenFenpeiUuidNumber")){
                                    List<String> pingshenFenpeiUuidNumber = seachFields.get("pingshenFenpeiUuidNumber");
                                    pingshenFenpeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pingshenFenpeiUuidNumber = new ArrayList<>();
                                    pingshenFenpeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("pingshenFenpeiUuidNumber",pingshenFenpeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<PingshenFenpeiEntity> pingshenFenpeiEntities_pingshenFenpeiUuidNumber = pingshenFenpeiService.selectList(new EntityWrapper<PingshenFenpeiEntity>().in("pingshen_fenpei_uuid_number", seachFields.get("pingshenFenpeiUuidNumber")));
                        if(pingshenFenpeiEntities_pingshenFenpeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingshenFenpeiEntity s:pingshenFenpeiEntities_pingshenFenpeiUuidNumber){
                                repeatFields.add(s.getPingshenFenpeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pingshenFenpeiService.insertBatch(pingshenFenpeiList);
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
        PageUtils page = pingshenFenpeiService.queryPage(params);

        //字典表数据转换
        List<PingshenFenpeiView> list =(List<PingshenFenpeiView>)page.getList();
        for(PingshenFenpeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PingshenFenpeiEntity pingshenFenpei = pingshenFenpeiService.selectById(id);
            if(pingshenFenpei !=null){


                //entity转view
                PingshenFenpeiView view = new PingshenFenpeiView();
                BeanUtils.copyProperties( pingshenFenpei , view );//把实体数据重构到view中

                //级联表
                    PingshenEntity pingshen = pingshenService.selectById(pingshenFenpei.getPingshenId());
                if(pingshen != null){
                    BeanUtils.copyProperties( pingshen , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPingshenId(pingshen.getId());
                }
                //级联表
                    ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(pingshenFenpei.getZhuanjiaId());
                if(zhuanjia != null){
                    BeanUtils.copyProperties( zhuanjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhuanjiaId(zhuanjia.getId());
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
    public R add(@RequestBody PingshenFenpeiEntity pingshenFenpei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,pingshenFenpei:{}",this.getClass().getName(),pingshenFenpei.toString());
        Wrapper<PingshenFenpeiEntity> queryWrapper = new EntityWrapper<PingshenFenpeiEntity>()
            .eq("pingshen_fenpei_uuid_number", pingshenFenpei.getPingshenFenpeiUuidNumber())
            .eq("pingshen_id", pingshenFenpei.getPingshenId())
            .eq("zhuanjia_id", pingshenFenpei.getZhuanjiaId())
            .eq("pingshen_fenpei_text", pingshenFenpei.getPingshenFenpeiText())
//            .notIn("pingshen_fenpei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingshenFenpeiEntity pingshenFenpeiEntity = pingshenFenpeiService.selectOne(queryWrapper);
        if(pingshenFenpeiEntity==null){
            pingshenFenpei.setInsertTime(new Date());
            pingshenFenpei.setCreateTime(new Date());
        pingshenFenpeiService.insert(pingshenFenpei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

