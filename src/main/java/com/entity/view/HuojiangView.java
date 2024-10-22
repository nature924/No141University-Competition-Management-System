package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuojiangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 获奖
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huojiang")
public class HuojiangView extends HuojiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 获奖类型的值
	*/
	@ColumnInfo(comment="获奖类型的字典表值",type="varchar(200)")
	private String huojiangValue;




	public HuojiangView() {

	}

	public HuojiangView(HuojiangEntity huojiangEntity) {
		try {
			BeanUtils.copyProperties(this, huojiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 获奖类型的值
	*/
	public String getHuojiangValue() {
		return huojiangValue;
	}
	/**
	* 设置： 获奖类型的值
	*/
	public void setHuojiangValue(String huojiangValue) {
		this.huojiangValue = huojiangValue;
	}




	@Override
	public String toString() {
		return "HuojiangView{" +
			", huojiangValue=" + huojiangValue +
			"} " + super.toString();
	}
}
