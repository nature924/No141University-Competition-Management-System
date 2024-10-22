package com.dao;

import com.entity.PingshenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PingshenView;

/**
 * 评审 Dao 接口
 *
 * @author 
 */
public interface PingshenDao extends BaseMapper<PingshenEntity> {

   List<PingshenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
