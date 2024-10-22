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
 * 评审
 *
 * @author 
 * @email
 */
@TableName("pingshen")
public class PingshenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PingshenEntity() {

	}

	public PingshenEntity(T t) {
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
    @TableField(value = "pingshen_uuid_number")

    private String pingshenUuidNumber;


    /**
     * 赛事提交
     */
    @ColumnInfo(comment="赛事提交",type="int(11)")
    @TableField(value = "saishi_tijiao_id")

    private Integer saishiTijiaoId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 参赛作品
     */
    @ColumnInfo(comment="参赛作品",type="varchar(200)")
    @TableField(value = "pingshen_file")

    private String pingshenFile;


    /**
     * 指导老师
     */
    @ColumnInfo(comment="指导老师",type="varchar(200)")
    @TableField(value = "pingshen_zhidao")

    private String pingshenZhidao;


    /**
     * 内容
     */
    @ColumnInfo(comment="内容",type="text")
    @TableField(value = "pingshen_text")

    private String pingshenText;


    /**
     * 赛事提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="赛事提交时间",type="timestamp")
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
    public String getPingshenUuidNumber() {
        return pingshenUuidNumber;
    }
    /**
	 * 设置：报名唯一编号
	 */

    public void setPingshenUuidNumber(String pingshenUuidNumber) {
        this.pingshenUuidNumber = pingshenUuidNumber;
    }
    /**
	 * 获取：赛事提交
	 */
    public Integer getSaishiTijiaoId() {
        return saishiTijiaoId;
    }
    /**
	 * 设置：赛事提交
	 */

    public void setSaishiTijiaoId(Integer saishiTijiaoId) {
        this.saishiTijiaoId = saishiTijiaoId;
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
	 * 获取：参赛作品
	 */
    public String getPingshenFile() {
        return pingshenFile;
    }
    /**
	 * 设置：参赛作品
	 */

    public void setPingshenFile(String pingshenFile) {
        this.pingshenFile = pingshenFile;
    }
    /**
	 * 获取：指导老师
	 */
    public String getPingshenZhidao() {
        return pingshenZhidao;
    }
    /**
	 * 设置：指导老师
	 */

    public void setPingshenZhidao(String pingshenZhidao) {
        this.pingshenZhidao = pingshenZhidao;
    }
    /**
	 * 获取：内容
	 */
    public String getPingshenText() {
        return pingshenText;
    }
    /**
	 * 设置：内容
	 */

    public void setPingshenText(String pingshenText) {
        this.pingshenText = pingshenText;
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
        return "Pingshen{" +
            ", id=" + id +
            ", pingshenUuidNumber=" + pingshenUuidNumber +
            ", saishiTijiaoId=" + saishiTijiaoId +
            ", laoshiId=" + laoshiId +
            ", pingshenFile=" + pingshenFile +
            ", pingshenZhidao=" + pingshenZhidao +
            ", pingshenText=" + pingshenText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
