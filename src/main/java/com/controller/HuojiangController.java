
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
 * 获奖
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huojiang")
public class HuojiangController {
    private static final Logger logger = LoggerFactory.getLogger(HuojiangController.class);

    private static final String TABLE_NAME = "huojiang";

    @Autowired
    private HuojiangService huojiangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//竞赛公告
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
        params.put("huojiangDeleteStart",1);params.put("huojiangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = huojiangService.queryPage(params);

        //字典表数据转换
        List<HuojiangView> list =(List<HuojiangView>)page.getList();
        for(HuojiangView c:list){
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
        HuojiangEntity huojiang = huojiangService.selectById(id);
        if(huojiang !=null){
            //entity转view
            HuojiangView view = new HuojiangView();
            BeanUtils.copyProperties( huojiang , view );//把实体数据重构到view中
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
    public R save(@RequestBody HuojiangEntity huojiang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huojiang:{}",this.getClass().getName(),huojiang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuojiangEntity> queryWrapper = new EntityWrapper<HuojiangEntity>()
            .eq("huojiang_name", huojiang.getHuojiangName())
            .eq("huojiang_types", huojiang.getHuojiangTypes())
            .eq("huojiang_xues", huojiang.getHuojiangXues())
            .eq("huojiang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuojiangEntity huojiangEntity = huojiangService.selectOne(queryWrapper);
        if(huojiangEntity==null){
            huojiang.setHuojiangDelete(1);
            huojiang.setInsertTime(new Date());
            huojiang.setCreateTime(new Date());
            huojiangService.insert(huojiang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuojiangEntity huojiang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huojiang:{}",this.getClass().getName(),huojiang.toString());
        HuojiangEntity oldHuojiangEntity = huojiangService.selectById(huojiang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(huojiang.getHuojiangPhoto()) || "null".equals(huojiang.getHuojiangPhoto())){
                huojiang.setHuojiangPhoto(null);
        }

            huojiangService.updateById(huojiang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuojiangEntity> oldHuojiangList =huojiangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<HuojiangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuojiangEntity huojiangEntity = new HuojiangEntity();
            huojiangEntity.setId(id);
            huojiangEntity.setHuojiangDelete(2);
            list.add(huojiangEntity);
        }
        if(list != null && list.size() >0){
            huojiangService.updateBatchById(list);
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
            List<HuojiangEntity> huojiangList = new ArrayList<>();//上传的东西
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
                            HuojiangEntity huojiangEntity = new HuojiangEntity();
//                            huojiangEntity.setHuojiangName(data.get(0));                    //获奖名称 要改的
//                            huojiangEntity.setHuojiangUuidNumber(data.get(0));                    //获奖编号 要改的
//                            huojiangEntity.setHuojiangPhoto("");//详情和图片
//                            huojiangEntity.setHuojiangTypes(Integer.valueOf(data.get(0)));   //获奖类型 要改的
//                            huojiangEntity.setHuojiangXues(Integer.valueOf(data.get(0)));   //学生排名 要改的
//                            huojiangEntity.setHuojiangContent("");//详情和图片
//                            huojiangEntity.setHuojiangDelete(1);//逻辑删除字段
//                            huojiangEntity.setInsertTime(date);//时间
//                            huojiangEntity.setCreateTime(date);//时间
                            huojiangList.add(huojiangEntity);


                            //把要查询是否重复的字段放入map中
                                //获奖编号
                                if(seachFields.containsKey("huojiangUuidNumber")){
                                    List<String> huojiangUuidNumber = seachFields.get("huojiangUuidNumber");
                                    huojiangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huojiangUuidNumber = new ArrayList<>();
                                    huojiangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huojiangUuidNumber",huojiangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //获奖编号
                        List<HuojiangEntity> huojiangEntities_huojiangUuidNumber = huojiangService.selectList(new EntityWrapper<HuojiangEntity>().in("huojiang_uuid_number", seachFields.get("huojiangUuidNumber")).eq("huojiang_delete", 1));
                        if(huojiangEntities_huojiangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuojiangEntity s:huojiangEntities_huojiangUuidNumber){
                                repeatFields.add(s.getHuojiangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [获奖编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huojiangService.insertBatch(huojiangList);
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
        PageUtils page = huojiangService.queryPage(params);

        //字典表数据转换
        List<HuojiangView> list =(List<HuojiangView>)page.getList();
        for(HuojiangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuojiangEntity huojiang = huojiangService.selectById(id);
            if(huojiang !=null){


                //entity转view
                HuojiangView view = new HuojiangView();
                BeanUtils.copyProperties( huojiang , view );//把实体数据重构到view中

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
    public R add(@RequestBody HuojiangEntity huojiang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huojiang:{}",this.getClass().getName(),huojiang.toString());
        Wrapper<HuojiangEntity> queryWrapper = new EntityWrapper<HuojiangEntity>()
            .eq("huojiang_name", huojiang.getHuojiangName())
            .eq("huojiang_uuid_number", huojiang.getHuojiangUuidNumber())
            .eq("huojiang_types", huojiang.getHuojiangTypes())
            .eq("huojiang_xues", huojiang.getHuojiangXues())
            .eq("huojiang_delete", huojiang.getHuojiangDelete())
//            .notIn("huojiang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuojiangEntity huojiangEntity = huojiangService.selectOne(queryWrapper);
        if(huojiangEntity==null){
            huojiang.setHuojiangDelete(1);
            huojiang.setInsertTime(new Date());
            huojiang.setCreateTime(new Date());
        huojiangService.insert(huojiang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

