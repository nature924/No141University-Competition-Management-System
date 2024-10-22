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
 * 获奖
 *
 * @author 
 * @email
 */
@TableName("huojiang")
public class HuojiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuojiangEntity() {

	}

	public HuojiangEntity(T t) {
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
     * 获奖名称
     */
    @ColumnInfo(comment="获奖名称",type="varchar(200)")
    @TableField(value = "huojiang_name")

    private String huojiangName;


    /**
     * 获奖编号
     */
    @ColumnInfo(comment="获奖编号",type="varchar(200)")
    @TableField(value = "huojiang_uuid_number")

    private String huojiangUuidNumber;


    /**
     * 获奖照片
     */
    @ColumnInfo(comment="获奖照片",type="varchar(200)")
    @TableField(value = "huojiang_photo")

    private String huojiangPhoto;


    /**
     * 获奖类型
     */
    @ColumnInfo(comment="获奖类型",type="int(11)")
    @TableField(value = "huojiang_types")

    private Integer huojiangTypes;


    /**
     * 学生排名
     */
    @ColumnInfo(comment="学生排名",type="int(11)")
    @TableField(value = "huojiang_xues")

    private Integer huojiangXues;


    /**
     * 获奖介绍
     */
    @ColumnInfo(comment="获奖介绍",type="longtext")
    @TableField(value = "huojiang_content")

    private String huojiangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "huojiang_delete")

    private Integer huojiangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：获奖名称
	 */
    public String getHuojiangName() {
        return huojiangName;
    }
    /**
	 * 设置：获奖名称
	 */

    public void setHuojiangName(String huojiangName) {
        this.huojiangName = huojiangName;
    }
    /**
	 * 获取：获奖编号
	 */
    public String getHuojiangUuidNumber() {
        return huojiangUuidNumber;
    }
    /**
	 * 设置：获奖编号
	 */

    public void setHuojiangUuidNumber(String huojiangUuidNumber) {
        this.huojiangUuidNumber = huojiangUuidNumber;
    }
    /**
	 * 获取：获奖照片
	 */
    public String getHuojiangPhoto() {
        return huojiangPhoto;
    }
    /**
	 * 设置：获奖照片
	 */

    public void setHuojiangPhoto(String huojiangPhoto) {
        this.huojiangPhoto = huojiangPhoto;
    }
    /**
	 * 获取：获奖类型
	 */
    public Integer getHuojiangTypes() {
        return huojiangTypes;
    }
    /**
	 * 设置：获奖类型
	 */

    public void setHuojiangTypes(Integer huojiangTypes) {
        this.huojiangTypes = huojiangTypes;
    }
    /**
	 * 获取：学生排名
	 */
    public Integer getHuojiangXues() {
        return huojiangXues;
    }
    /**
	 * 设置：学生排名
	 */

    public void setHuojiangXues(Integer huojiangXues) {
        this.huojiangXues = huojiangXues;
    }
    /**
	 * 获取：获奖介绍
	 */
    public String getHuojiangContent() {
        return huojiangContent;
    }
    /**
	 * 设置：获奖介绍
	 */

    public void setHuojiangContent(String huojiangContent) {
        this.huojiangContent = huojiangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHuojiangDelete() {
        return huojiangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setHuojiangDelete(Integer huojiangDelete) {
        this.huojiangDelete = huojiangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huojiang{" +
            ", id=" + id +
            ", huojiangName=" + huojiangName +
            ", huojiangUuidNumber=" + huojiangUuidNumber +
            ", huojiangPhoto=" + huojiangPhoto +
            ", huojiangTypes=" + huojiangTypes +
            ", huojiangXues=" + huojiangXues +
            ", huojiangContent=" + huojiangContent +
            ", huojiangDelete=" + huojiangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
