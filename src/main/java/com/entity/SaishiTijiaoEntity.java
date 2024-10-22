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
 * 赛事提交
 *
 * @author 
 * @email
 */
@TableName("saishi_tijiao")
public class SaishiTijiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishiTijiaoEntity() {

	}

	public SaishiTijiaoEntity(T t) {
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
     * 报名唯一编号
     */
    @ColumnInfo(comment="报名唯一编号",type="varchar(200)")
    @TableField(value = "saishi_tijiao_uuid_number")

    private String saishiTijiaoUuidNumber;


    /**
     * 赛事
     */
    @ColumnInfo(comment="赛事",type="int(11)")
    @TableField(value = "saishi_id")

    private Integer saishiId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 内容
     */
    @ColumnInfo(comment="内容",type="text")
    @TableField(value = "saishi_tijiao_text")

    private String saishiTijiaoText;


    /**
     * 赛事作品
     */
    @ColumnInfo(comment="赛事作品",type="varchar(200)")
    @TableField(value = "saishi_shangchuan_file")

    private String saishiShangchuanFile;


    /**
     * 提交状态
     */
    @ColumnInfo(comment="提交状态",type="int(11)")
    @TableField(value = "saishi_tijiao_yesno_types")

    private Integer saishiTijiaoYesnoTypes;


    /**
     * 赛事提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="赛事提交时间",type="timestamp")
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
	 * 获取：报名唯一编号
	 */
    public String getSaishiTijiaoUuidNumber() {
        return saishiTijiaoUuidNumber;
    }
    /**
	 * 设置：报名唯一编号
	 */

    public void setSaishiTijiaoUuidNumber(String saishiTijiaoUuidNumber) {
        this.saishiTijiaoUuidNumber = saishiTijiaoUuidNumber;
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
	 * 获取：内容
	 */
    public String getSaishiTijiaoText() {
        return saishiTijiaoText;
    }
    /**
	 * 设置：内容
	 */

    public void setSaishiTijiaoText(String saishiTijiaoText) {
        this.saishiTijiaoText = saishiTijiaoText;
    }
    /**
	 * 获取：赛事作品
	 */
    public String getSaishiShangchuanFile() {
        return saishiShangchuanFile;
    }
    /**
	 * 设置：赛事作品
	 */

    public void setSaishiShangchuanFile(String saishiShangchuanFile) {
        this.saishiShangchuanFile = saishiShangchuanFile;
    }
    /**
	 * 获取：提交状态
	 */
    public Integer getSaishiTijiaoYesnoTypes() {
        return saishiTijiaoYesnoTypes;
    }
    /**
	 * 设置：提交状态
	 */

    public void setSaishiTijiaoYesnoTypes(Integer saishiTijiaoYesnoTypes) {
        this.saishiTijiaoYesnoTypes = saishiTijiaoYesnoTypes;
    }
    /**
	 * 获取：赛事提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：赛事提交时间
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
        return "SaishiTijiao{" +
            ", id=" + id +
            ", saishiTijiaoUuidNumber=" + saishiTijiaoUuidNumber +
            ", saishiId=" + saishiId +
            ", laoshiId=" + laoshiId +
            ", yonghuId=" + yonghuId +
            ", saishiTijiaoText=" + saishiTijiaoText +
            ", saishiShangchuanFile=" + saishiShangchuanFile +
            ", saishiTijiaoYesnoTypes=" + saishiTijiaoYesnoTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
