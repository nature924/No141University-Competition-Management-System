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
 * 评审打分
 *
 * @author 
 * @email
 */
@TableName("pingshen_pingfen")
public class PingshenPingfenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PingshenPingfenEntity() {

	}

	public PingshenPingfenEntity(T t) {
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
    @TableField(value = "pingshen_pingfen_uuid_number")

    private String pingshenPingfenUuidNumber;


    /**
     * 评审分配
     */
    @ColumnInfo(comment="评审分配",type="int(11)")
    @TableField(value = "pingshen_fenpei_id")

    private Integer pingshenFenpeiId;


    /**
     * 专家
     */
    @ColumnInfo(comment="专家",type="int(11)")
    @TableField(value = "zhuanjia_id")

    private Integer zhuanjiaId;


    /**
     * 打分
     */
    @ColumnInfo(comment="打分",type="int(11)")
    @TableField(value = "pingshen_pingfen_pingfen")

    private Integer pingshenPingfenPingfen;


    /**
     * 内容
     */
    @ColumnInfo(comment="内容",type="text")
    @TableField(value = "pingshen_pingfen_text")

    private String pingshenPingfenText;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
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
	 * 获取：报名唯一编号
	 */
    public String getPingshenPingfenUuidNumber() {
        return pingshenPingfenUuidNumber;
    }
    /**
	 * 设置：报名唯一编号
	 */

    public void setPingshenPingfenUuidNumber(String pingshenPingfenUuidNumber) {
        this.pingshenPingfenUuidNumber = pingshenPingfenUuidNumber;
    }
    /**
	 * 获取：评审分配
	 */
    public Integer getPingshenFenpeiId() {
        return pingshenFenpeiId;
    }
    /**
	 * 设置：评审分配
	 */

    public void setPingshenFenpeiId(Integer pingshenFenpeiId) {
        this.pingshenFenpeiId = pingshenFenpeiId;
    }
    /**
	 * 获取：专家
	 */
    public Integer getZhuanjiaId() {
        return zhuanjiaId;
    }
    /**
	 * 设置：专家
	 */

    public void setZhuanjiaId(Integer zhuanjiaId) {
        this.zhuanjiaId = zhuanjiaId;
    }
    /**
	 * 获取：打分
	 */
    public Integer getPingshenPingfenPingfen() {
        return pingshenPingfenPingfen;
    }
    /**
	 * 设置：打分
	 */

    public void setPingshenPingfenPingfen(Integer pingshenPingfenPingfen) {
        this.pingshenPingfenPingfen = pingshenPingfenPingfen;
    }
    /**
	 * 获取：内容
	 */
    public String getPingshenPingfenText() {
        return pingshenPingfenText;
    }
    /**
	 * 设置：内容
	 */

    public void setPingshenPingfenText(String pingshenPingfenText) {
        this.pingshenPingfenText = pingshenPingfenText;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：分配时间
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
        return "PingshenPingfen{" +
            ", id=" + id +
            ", pingshenPingfenUuidNumber=" + pingshenPingfenUuidNumber +
            ", pingshenFenpeiId=" + pingshenFenpeiId +
            ", zhuanjiaId=" + zhuanjiaId +
            ", pingshenPingfenPingfen=" + pingshenPingfenPingfen +
            ", pingshenPingfenText=" + pingshenPingfenText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
