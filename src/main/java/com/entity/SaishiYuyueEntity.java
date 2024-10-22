package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 赛事报名
 *
 * @author 
 * @email
 */
@TableName("saishi_yuyue")
public class SaishiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishiYuyueEntity() {

	}

	public SaishiYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "saishi_yuyue_uuid_number")

    private String saishiYuyueUuidNumber;


    /**
     * 赛事
     */
    @ColumnInfo(comment="赛事",type="int(11)")
    @TableField(value = "saishi_id")

    private Integer saishiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "saishi_yuyue_text")

    private String saishiYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "saishi_yuyue_yesno_types")

    private Integer saishiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "saishi_yuyue_yesno_text")

    private String saishiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "saishi_yuyue_shenhe_time")

    private Date saishiYuyueShenheTime;


    /**
     * 赛事报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="赛事报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名编号
	 */
    public String getSaishiYuyueUuidNumber() {
        return saishiYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setSaishiYuyueUuidNumber(String saishiYuyueUuidNumber) {
        this.saishiYuyueUuidNumber = saishiYuyueUuidNumber;
    }
    /**
	 * 获取：赛事
	 */
    public Integer getSaishiId() {
        return saishiId;
    }
    /**
	 * 设置：赛事
	 */

    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 设置：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getSaishiYuyueText() {
        return saishiYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setSaishiYuyueText(String saishiYuyueText) {
        this.saishiYuyueText = saishiYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getSaishiYuyueYesnoTypes() {
        return saishiYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setSaishiYuyueYesnoTypes(Integer saishiYuyueYesnoTypes) {
        this.saishiYuyueYesnoTypes = saishiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getSaishiYuyueYesnoText() {
        return saishiYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setSaishiYuyueYesnoText(String saishiYuyueYesnoText) {
        this.saishiYuyueYesnoText = saishiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getSaishiYuyueShenheTime() {
        return saishiYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setSaishiYuyueShenheTime(Date saishiYuyueShenheTime) {
        this.saishiYuyueShenheTime = saishiYuyueShenheTime;
    }
    /**
	 * 获取：赛事报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：赛事报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SaishiYuyue{" +
            ", id=" + id +
            ", saishiYuyueUuidNumber=" + saishiYuyueUuidNumber +
            ", saishiId=" + saishiId +
            ", yonghuId=" + yonghuId +
            ", laoshiId=" + laoshiId +
            ", saishiYuyueText=" + saishiYuyueText +
            ", saishiYuyueYesnoTypes=" + saishiYuyueYesnoTypes +
            ", saishiYuyueYesnoText=" + saishiYuyueYesnoText +
            ", saishiYuyueShenheTime=" + DateUtil.convertString(saishiYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
