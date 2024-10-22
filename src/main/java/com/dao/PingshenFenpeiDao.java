package com.dao;

import com.entity.PingshenFenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PingshenFenpeiView;

/**
 * 评审分配 Dao 接口
 *
 * @author 
 */
public interface PingshenFenpeiDao extends BaseMapper<PingshenFenpeiEntity> {

   List<PingshenFenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
