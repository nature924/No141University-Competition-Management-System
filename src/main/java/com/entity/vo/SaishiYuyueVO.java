package com.entity.vo;

import com.entity.SaishiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishi_yuyue")
public class SaishiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "saishi_yuyue_uuid_number")
    private String saishiYuyueUuidNumber;


    /**
     * 赛事
     */

    @TableField(value = "saishi_id")
    private Integer saishiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 报名理由
     */

    @TableField(value = "saishi_yuyue_text")
    private String saishiYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "saishi_yuyue_yesno_types")
    private Integer saishiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "saishi_yuyue_yesno_text")
    private String saishiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "saishi_yuyue_shenhe_time")
    private Date saishiYuyueShenheTime;


    /**
     * 赛事报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getSaishiYuyueUuidNumber() {
        return saishiYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setSaishiYuyueUuidNumber(String saishiYuyueUuidNumber) {
        this.saishiYuyueUuidNumber = saishiYuyueUuidNumber;
    }
    /**
	 * 设置：赛事
	 */
    public Integer getSaishiId() {
        return saishiId;
    }


    /**
	 * 获取：赛事
	 */

    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getSaishiYuyueText() {
        return saishiYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setSaishiYuyueText(String saishiYuyueText) {
        this.saishiYuyueText = saishiYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getSaishiYuyueYesnoTypes() {
        return saishiYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setSaishiYuyueYesnoTypes(Integer saishiYuyueYesnoTypes) {
        this.saishiYuyueYesnoTypes = saishiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getSaishiYuyueYesnoText() {
        return saishiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setSaishiYuyueYesnoText(String saishiYuyueYesnoText) {
        this.saishiYuyueYesnoText = saishiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getSaishiYuyueShenheTime() {
        return saishiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setSaishiYuyueShenheTime(Date saishiYuyueShenheTime) {
        this.saishiYuyueShenheTime = saishiYuyueShenheTime;
    }
    /**
	 * 设置：赛事报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：赛事报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
