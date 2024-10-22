package com.entity.model;

import com.entity.SaishiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String saishiYuyueUuidNumber;


    /**
     * 赛事
     */
    private Integer saishiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 报名理由
     */
    private String saishiYuyueText;


    /**
     * 报名状态
     */
    private Integer saishiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String saishiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date saishiYuyueShenheTime;


    /**
     * 赛事报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
