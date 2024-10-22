package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishi_yuyue")
public class SaishiYuyueView extends SaishiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String saishiYuyueYesnoValue;

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
	//级联表 赛事
		/**
		* 赛事名称
		*/

		@ColumnInfo(comment="赛事名称",type="varchar(200)")
		private String saishiName;
		/**
		* 赛事编号
		*/

		@ColumnInfo(comment="赛事编号",type="varchar(200)")
		private String saishiUuidNumber;
		/**
		* 赛事照片
		*/

		@ColumnInfo(comment="赛事照片",type="varchar(200)")
		private String saishiPhoto;
		/**
		* 赛事地点
		*/

		@ColumnInfo(comment="赛事地点",type="varchar(200)")
		private String saishiAddress;
		/**
		* 赛事类型
		*/
		@ColumnInfo(comment="赛事类型",type="int(11)")
		private Integer saishiTypes;
			/**
			* 赛事类型的值
			*/
			@ColumnInfo(comment="赛事类型的字典表值",type="varchar(200)")
			private String saishiValue;
		/**
		* 赛事介绍
		*/

		@ColumnInfo(comment="赛事介绍",type="longtext")
		private String saishiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer saishiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public SaishiYuyueView() {

	}

	public SaishiYuyueView(SaishiYuyueEntity saishiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, saishiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getSaishiYuyueYesnoValue() {
		return saishiYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setSaishiYuyueYesnoValue(String saishiYuyueYesnoValue) {
		this.saishiYuyueYesnoValue = saishiYuyueYesnoValue;
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
	//级联表的get和set 赛事

		/**
		* 获取： 赛事名称
		*/
		public String getSaishiName() {
			return saishiName;
		}
		/**
		* 设置： 赛事名称
		*/
		public void setSaishiName(String saishiName) {
			this.saishiName = saishiName;
		}

		/**
		* 获取： 赛事编号
		*/
		public String getSaishiUuidNumber() {
			return saishiUuidNumber;
		}
		/**
		* 设置： 赛事编号
		*/
		public void setSaishiUuidNumber(String saishiUuidNumber) {
			this.saishiUuidNumber = saishiUuidNumber;
		}

		/**
		* 获取： 赛事照片
		*/
		public String getSaishiPhoto() {
			return saishiPhoto;
		}
		/**
		* 设置： 赛事照片
		*/
		public void setSaishiPhoto(String saishiPhoto) {
			this.saishiPhoto = saishiPhoto;
		}

		/**
		* 获取： 赛事地点
		*/
		public String getSaishiAddress() {
			return saishiAddress;
		}
		/**
		* 设置： 赛事地点
		*/
		public void setSaishiAddress(String saishiAddress) {
			this.saishiAddress = saishiAddress;
		}
		/**
		* 获取： 赛事类型
		*/
		public Integer getSaishiTypes() {
			return saishiTypes;
		}
		/**
		* 设置： 赛事类型
		*/
		public void setSaishiTypes(Integer saishiTypes) {
			this.saishiTypes = saishiTypes;
		}


			/**
			* 获取： 赛事类型的值
			*/
			public String getSaishiValue() {
				return saishiValue;
			}
			/**
			* 设置： 赛事类型的值
			*/
			public void setSaishiValue(String saishiValue) {
				this.saishiValue = saishiValue;
			}

		/**
		* 获取： 赛事介绍
		*/
		public String getSaishiContent() {
			return saishiContent;
		}
		/**
		* 设置： 赛事介绍
		*/
		public void setSaishiContent(String saishiContent) {
			this.saishiContent = saishiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getSaishiDelete() {
			return saishiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setSaishiDelete(Integer saishiDelete) {
			this.saishiDelete = saishiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "SaishiYuyueView{" +
			", saishiYuyueYesnoValue=" + saishiYuyueYesnoValue +
			", saishiName=" + saishiName +
			", saishiUuidNumber=" + saishiUuidNumber +
			", saishiPhoto=" + saishiPhoto +
			", saishiAddress=" + saishiAddress +
			", saishiContent=" + saishiContent +
			", saishiDelete=" + saishiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
