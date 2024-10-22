package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PingshenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 评审
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("pingshen")
public class PingshenView extends PingshenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 老师
		/**
		* 老师姓名
		*/

		@ColumnInfo(comment="老师姓名",type="varchar(200)")
		private String laoshiName;
		/**
		* 老师手机号
		*/

		@ColumnInfo(comment="老师手机号",type="varchar(200)")
		private String laoshiPhone;
		/**
		* 老师身份证号
		*/

		@ColumnInfo(comment="老师身份证号",type="varchar(200)")
		private String laoshiIdNumber;
		/**
		* 老师头像
		*/

		@ColumnInfo(comment="老师头像",type="varchar(200)")
		private String laoshiPhoto;
		/**
		* 老师邮箱
		*/

		@ColumnInfo(comment="老师邮箱",type="varchar(200)")
		private String laoshiEmail;
	//级联表 赛事提交
		/**
		* 报名唯一编号
		*/

		@ColumnInfo(comment="报名唯一编号",type="varchar(200)")
		private String saishiTijiaoUuidNumber;
										 
		/**
		* 赛事提交 的 老师
		*/
		@ColumnInfo(comment="老师",type="int(11)")
		private Integer saishiTijiaoLaoshiId;
					 
		/**
		* 赛事提交 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer saishiTijiaoYonghuId;
		/**
		* 内容
		*/

		@ColumnInfo(comment="内容",type="text")
		private String saishiTijiaoText;
		/**
		* 赛事作品
		*/

		@ColumnInfo(comment="赛事作品",type="varchar(200)")
		private String saishiShangchuanFile;
		/**
		* 提交状态
		*/
		@ColumnInfo(comment="提交状态",type="int(11)")
		private Integer saishiTijiaoYesnoTypes;
			/**
			* 提交状态的值
			*/
			@ColumnInfo(comment="提交状态的字典表值",type="varchar(200)")
			private String saishiTijiaoYesnoValue;



	public PingshenView() {

	}

	public PingshenView(PingshenEntity pingshenEntity) {
		try {
			BeanUtils.copyProperties(this, pingshenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 老师

		/**
		* 获取： 老师姓名
		*/
		public String getLaoshiName() {
			return laoshiName;
		}
		/**
		* 设置： 老师姓名
		*/
		public void setLaoshiName(String laoshiName) {
			this.laoshiName = laoshiName;
		}

		/**
		* 获取： 老师手机号
		*/
		public String getLaoshiPhone() {
			return laoshiPhone;
		}
		/**
		* 设置： 老师手机号
		*/
		public void setLaoshiPhone(String laoshiPhone) {
			this.laoshiPhone = laoshiPhone;
		}

		/**
		* 获取： 老师身份证号
		*/
		public String getLaoshiIdNumber() {
			return laoshiIdNumber;
		}
		/**
		* 设置： 老师身份证号
		*/
		public void setLaoshiIdNumber(String laoshiIdNumber) {
			this.laoshiIdNumber = laoshiIdNumber;
		}

		/**
		* 获取： 老师头像
		*/
		public String getLaoshiPhoto() {
			return laoshiPhoto;
		}
		/**
		* 设置： 老师头像
		*/
		public void setLaoshiPhoto(String laoshiPhoto) {
			this.laoshiPhoto = laoshiPhoto;
		}

		/**
		* 获取： 老师邮箱
		*/
		public String getLaoshiEmail() {
			return laoshiEmail;
		}
		/**
		* 设置： 老师邮箱
		*/
		public void setLaoshiEmail(String laoshiEmail) {
			this.laoshiEmail = laoshiEmail;
		}
	//级联表的get和set 赛事提交

		/**
		* 获取： 报名唯一编号
		*/
		public String getSaishiTijiaoUuidNumber() {
			return saishiTijiaoUuidNumber;
		}
		/**
		* 设置： 报名唯一编号
		*/
		public void setSaishiTijiaoUuidNumber(String saishiTijiaoUuidNumber) {
			this.saishiTijiaoUuidNumber = saishiTijiaoUuidNumber;
		}
		/**
		* 获取：赛事提交 的 老师
		*/
		public Integer getSaishiTijiaoLaoshiId() {
			return saishiTijiaoLaoshiId;
		}
		/**
		* 设置：赛事提交 的 老师
		*/
		public void setSaishiTijiaoLaoshiId(Integer saishiTijiaoLaoshiId) {
			this.saishiTijiaoLaoshiId = saishiTijiaoLaoshiId;
		}
		/**
		* 获取：赛事提交 的 用户
		*/
		public Integer getSaishiTijiaoYonghuId() {
			return saishiTijiaoYonghuId;
		}
		/**
		* 设置：赛事提交 的 用户
		*/
		public void setSaishiTijiaoYonghuId(Integer saishiTijiaoYonghuId) {
			this.saishiTijiaoYonghuId = saishiTijiaoYonghuId;
		}

		/**
		* 获取： 内容
		*/
		public String getSaishiTijiaoText() {
			return saishiTijiaoText;
		}
		/**
		* 设置： 内容
		*/
		public void setSaishiTijiaoText(String saishiTijiaoText) {
			this.saishiTijiaoText = saishiTijiaoText;
		}

		/**
		* 获取： 赛事作品
		*/
		public String getSaishiShangchuanFile() {
			return saishiShangchuanFile;
		}
		/**
		* 设置： 赛事作品
		*/
		public void setSaishiShangchuanFile(String saishiShangchuanFile) {
			this.saishiShangchuanFile = saishiShangchuanFile;
		}
		/**
		* 获取： 提交状态
		*/
		public Integer getSaishiTijiaoYesnoTypes() {
			return saishiTijiaoYesnoTypes;
		}
		/**
		* 设置： 提交状态
		*/
		public void setSaishiTijiaoYesnoTypes(Integer saishiTijiaoYesnoTypes) {
			this.saishiTijiaoYesnoTypes = saishiTijiaoYesnoTypes;
		}


			/**
			* 获取： 提交状态的值
			*/
			public String getSaishiTijiaoYesnoValue() {
				return saishiTijiaoYesnoValue;
			}
			/**
			* 设置： 提交状态的值
			*/
			public void setSaishiTijiaoYesnoValue(String saishiTijiaoYesnoValue) {
				this.saishiTijiaoYesnoValue = saishiTijiaoYesnoValue;
			}


	@Override
	public String toString() {
		return "PingshenView{" +
			", saishiTijiaoUuidNumber=" + saishiTijiaoUuidNumber +
			", saishiTijiaoText=" + saishiTijiaoText +
			", saishiShangchuanFile=" + saishiShangchuanFile +
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
