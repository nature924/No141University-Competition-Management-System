
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
 * 赛事
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishi")
public class SaishiController {
    private static final Logger logger = LoggerFactory.getLogger(SaishiController.class);

    private static final String TABLE_NAME = "saishi";

    @Autowired
    private SaishiService saishiService;


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
        params.put("saishiDeleteStart",1);params.put("saishiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = saishiService.queryPage(params);

        //字典表数据转换
        List<SaishiView> list =(List<SaishiView>)page.getList();
        for(SaishiView c:list){
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
        SaishiEntity saishi = saishiService.selectById(id);
        if(saishi !=null){
            //entity转view
            SaishiView view = new SaishiView();
            BeanUtils.copyProperties( saishi , view );//把实体数据重构到view中
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
    public R save(@RequestBody SaishiEntity saishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishi:{}",this.getClass().getName(),saishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SaishiEntity> queryWrapper = new EntityWrapper<SaishiEntity>()
            .eq("saishi_name", saishi.getSaishiName())
            .eq("saishi_address", saishi.getSaishiAddress())
            .eq("saishi_types", saishi.getSaishiTypes())
            .eq("saishi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiEntity saishiEntity = saishiService.selectOne(queryWrapper);
        if(saishiEntity==null){
            saishi.setSaishiDelete(1);
            saishi.setInsertTime(new Date());
            saishi.setCreateTime(new Date());
            saishiService.insert(saishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishiEntity saishi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishi:{}",this.getClass().getName(),saishi.toString());
        SaishiEntity oldSaishiEntity = saishiService.selectById(saishi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(saishi.getSaishiPhoto()) || "null".equals(saishi.getSaishiPhoto())){
                saishi.setSaishiPhoto(null);
        }

            saishiService.updateById(saishi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishiEntity> oldSaishiList =saishiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<SaishiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            SaishiEntity saishiEntity = new SaishiEntity();
            saishiEntity.setId(id);
            saishiEntity.setSaishiDelete(2);
            list.add(saishiEntity);
        }
        if(list != null && list.size() >0){
            saishiService.updateBatchById(list);
        }

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
            List<SaishiEntity> saishiList = new ArrayList<>();//上传的东西
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
                            SaishiEntity saishiEntity = new SaishiEntity();
//                            saishiEntity.setSaishiName(data.get(0));                    //赛事名称 要改的
//                            saishiEntity.setSaishiUuidNumber(data.get(0));                    //赛事编号 要改的
//                            saishiEntity.setSaishiPhoto("");//详情和图片
//                            saishiEntity.setSaishiAddress(data.get(0));                    //赛事地点 要改的
//                            saishiEntity.setSaishiTypes(Integer.valueOf(data.get(0)));   //赛事类型 要改的
//                            saishiEntity.setSaishiContent("");//详情和图片
//                            saishiEntity.setSaishiDelete(1);//逻辑删除字段
//                            saishiEntity.setInsertTime(date);//时间
//                            saishiEntity.setCreateTime(date);//时间
                            saishiList.add(saishiEntity);


                            //把要查询是否重复的字段放入map中
                                //赛事编号
                                if(seachFields.containsKey("saishiUuidNumber")){
                                    List<String> saishiUuidNumber = seachFields.get("saishiUuidNumber");
                                    saishiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishiUuidNumber = new ArrayList<>();
                                    saishiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishiUuidNumber",saishiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //赛事编号
                        List<SaishiEntity> saishiEntities_saishiUuidNumber = saishiService.selectList(new EntityWrapper<SaishiEntity>().in("saishi_uuid_number", seachFields.get("saishiUuidNumber")).eq("saishi_delete", 1));
                        if(saishiEntities_saishiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishiEntity s:saishiEntities_saishiUuidNumber){
                                repeatFields.add(s.getSaishiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [赛事编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishiService.insertBatch(saishiList);
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
        PageUtils page = saishiService.queryPage(params);

        //字典表数据转换
        List<SaishiView> list =(List<SaishiView>)page.getList();
        for(SaishiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishiEntity saishi = saishiService.selectById(id);
            if(saishi !=null){


                //entity转view
                SaishiView view = new SaishiView();
                BeanUtils.copyProperties( saishi , view );//把实体数据重构到view中

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
    public R add(@RequestBody SaishiEntity saishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishi:{}",this.getClass().getName(),saishi.toString());
        Wrapper<SaishiEntity> queryWrapper = new EntityWrapper<SaishiEntity>()
            .eq("saishi_name", saishi.getSaishiName())
            .eq("saishi_uuid_number", saishi.getSaishiUuidNumber())
            .eq("saishi_address", saishi.getSaishiAddress())
            .eq("saishi_types", saishi.getSaishiTypes())
            .eq("saishi_delete", saishi.getSaishiDelete())
//            .notIn("saishi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiEntity saishiEntity = saishiService.selectOne(queryWrapper);
        if(saishiEntity==null){
            saishi.setSaishiDelete(1);
            saishi.setInsertTime(new Date());
            saishi.setCreateTime(new Date());
        saishiService.insert(saishi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

