package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PingshenPingfenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 评审打分
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("pingshen_pingfen")
public class PingshenPingfenView extends PingshenPingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 评审分配
		/**
		* 报名唯一编号
		*/

		@ColumnInfo(comment="报名唯一编号",type="varchar(200)")
		private String pingshenFenpeiUuidNumber;
										 
		/**
		* 评审分配 的 专家
		*/
		@ColumnInfo(comment="专家",type="int(11)")
		private Integer pingshenFenpeiZhuanjiaId;
		/**
		* 内容
		*/

		@ColumnInfo(comment="内容",type="text")
		private String pingshenFenpeiText;
	//级联表 专家
		/**
		* 专家姓名
		*/

		@ColumnInfo(comment="专家姓名",type="varchar(200)")
		private String zhuanjiaName;
		/**
		* 专家手机号
		*/

		@ColumnInfo(comment="专家手机号",type="varchar(200)")
		private String zhuanjiaPhone;
		/**
		* 专家身份证号
		*/

		@ColumnInfo(comment="专家身份证号",type="varchar(200)")
		private String zhuanjiaIdNumber;
		/**
		* 专家头像
		*/

		@ColumnInfo(comment="专家头像",type="varchar(200)")
		private String zhuanjiaPhoto;
		/**
		* 专家邮箱
		*/

		@ColumnInfo(comment="专家邮箱",type="varchar(200)")
		private String zhuanjiaEmail;



	public PingshenPingfenView() {

	}

	public PingshenPingfenView(PingshenPingfenEntity pingshenPingfenEntity) {
		try {
			BeanUtils.copyProperties(this, pingshenPingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 评审分配

		/**
		* 获取： 报名唯一编号
		*/
		public String getPingshenFenpeiUuidNumber() {
			return pingshenFenpeiUuidNumber;
		}
		/**
		* 设置： 报名唯一编号
		*/
		public void setPingshenFenpeiUuidNumber(String pingshenFenpeiUuidNumber) {
			this.pingshenFenpeiUuidNumber = pingshenFenpeiUuidNumber;
		}
		/**
		* 获取：评审分配 的 专家
		*/
		public Integer getPingshenFenpeiZhuanjiaId() {
			return pingshenFenpeiZhuanjiaId;
		}
		/**
		* 设置：评审分配 的 专家
		*/
		public void setPingshenFenpeiZhuanjiaId(Integer pingshenFenpeiZhuanjiaId) {
			this.pingshenFenpeiZhuanjiaId = pingshenFenpeiZhuanjiaId;
		}

		/**
		* 获取： 内容
		*/
		public String getPingshenFenpeiText() {
			return pingshenFenpeiText;
		}
		/**
		* 设置： 内容
		*/
		public void setPingshenFenpeiText(String pingshenFenpeiText) {
			this.pingshenFenpeiText = pingshenFenpeiText;
		}
	//级联表的get和set 专家

		/**
		* 获取： 专家姓名
		*/
		public String getZhuanjiaName() {
			return zhuanjiaName;
		}
		/**
		* 设置： 专家姓名
		*/
		public void setZhuanjiaName(String zhuanjiaName) {
			this.zhuanjiaName = zhuanjiaName;
		}

		/**
		* 获取： 专家手机号
		*/
		public String getZhuanjiaPhone() {
			return zhuanjiaPhone;
		}
		/**
		* 设置： 专家手机号
		*/
		public void setZhuanjiaPhone(String zhuanjiaPhone) {
			this.zhuanjiaPhone = zhuanjiaPhone;
		}

		/**
		* 获取： 专家身份证号
		*/
		public String getZhuanjiaIdNumber() {
			return zhuanjiaIdNumber;
		}
		/**
		* 设置： 专家身份证号
		*/
		public void setZhuanjiaIdNumber(String zhuanjiaIdNumber) {
			this.zhuanjiaIdNumber = zhuanjiaIdNumber;
		}

		/**
		* 获取： 专家头像
		*/
		public String getZhuanjiaPhoto() {
			return zhuanjiaPhoto;
		}
		/**
		* 设置： 专家头像
		*/
		public void setZhuanjiaPhoto(String zhuanjiaPhoto) {
			this.zhuanjiaPhoto = zhuanjiaPhoto;
		}

		/**
		* 获取： 专家邮箱
		*/
		public String getZhuanjiaEmail() {
			return zhuanjiaEmail;
		}
		/**
		* 设置： 专家邮箱
		*/
		public void setZhuanjiaEmail(String zhuanjiaEmail) {
			this.zhuanjiaEmail = zhuanjiaEmail;
		}


	@Override
	public String toString() {
		return "PingshenPingfenView{" +
			", pingshenFenpeiUuidNumber=" + pingshenFenpeiUuidNumber +
			", pingshenFenpeiText=" + pingshenFenpeiText +
			", zhuanjiaName=" + zhuanjiaName +
			", zhuanjiaPhone=" + zhuanjiaPhone +
			", zhuanjiaIdNumber=" + zhuanjiaIdNumber +
			", zhuanjiaPhoto=" + zhuanjiaPhoto +
			", zhuanjiaEmail=" + zhuanjiaEmail +
			"} " + super.toString();
	}
}
