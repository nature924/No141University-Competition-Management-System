package com.entity.model;

import com.entity.SaishiTijiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事提交
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiTijiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String saishiTijiaoUuidNumber;


    /**
     * 赛事
     */
    private Integer saishiId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 内容
     */
    private String saishiTijiaoText;


    /**
     * 赛事作品
     */
    private String saishiShangchuanFile;


    /**
     * 提交状态
     */
    private Integer saishiTijiaoYesnoTypes;


    /**
     * 赛事提交时间
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
