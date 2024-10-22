package com.dao;

import com.entity.SaishiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaishiYuyueView;

/**
 * 赛事报名 Dao 接口
 *
 * @author 
 */
public interface SaishiYuyueDao extends BaseMapper<SaishiYuyueEntity> {

   List<SaishiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
