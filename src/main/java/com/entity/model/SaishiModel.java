package com.entity.model;

import com.entity.SaishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛事名称
     */
    private String saishiName;


    /**
     * 赛事编号
     */
    private String saishiUuidNumber;


    /**
     * 赛事照片
     */
    private String saishiPhoto;


    /**
     * 赛事地点
     */
    private String saishiAddress;


    /**
     * 赛事类型
     */
    private Integer saishiTypes;


    /**
     * 赛事介绍
     */
    private String saishiContent;


    /**
     * 逻辑删除
     */
    private Integer saishiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：赛事名称
	 */
    public String getSaishiName() {
        return saishiName;
    }


    /**
	 * 设置：赛事名称
	 */
    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }
    /**
	 * 获取：赛事编号
	 */
    public String getSaishiUuidNumber() {
        return saishiUuidNumber;
    }


    /**
	 * 设置：赛事编号
	 */
    public void setSaishiUuidNumber(String saishiUuidNumber) {
        this.saishiUuidNumber = saishiUuidNumber;
    }
    /**
	 * 获取：赛事照片
	 */
    public String getSaishiPhoto() {
        return saishiPhoto;
    }


    /**
	 * 设置：赛事照片
	 */
    public void setSaishiPhoto(String saishiPhoto) {
        this.saishiPhoto = saishiPhoto;
    }
    /**
	 * 获取：赛事地点
	 */
    public String getSaishiAddress() {
        return saishiAddress;
    }


    /**
	 * 设置：赛事地点
	 */
    public void setSaishiAddress(String saishiAddress) {
        this.saishiAddress = saishiAddress;
    }
    /**
	 * 获取：赛事类型
	 */
    public Integer getSaishiTypes() {
        return saishiTypes;
    }


    /**
	 * 设置：赛事类型
	 */
    public void setSaishiTypes(Integer saishiTypes) {
        this.saishiTypes = saishiTypes;
    }
    /**
	 * 获取：赛事介绍
	 */
    public String getSaishiContent() {
        return saishiContent;
    }


    /**
	 * 设置：赛事介绍
	 */
    public void setSaishiContent(String saishiContent) {
        this.saishiContent = saishiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSaishiDelete() {
        return saishiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setSaishiDelete(Integer saishiDelete) {
        this.saishiDelete = saishiDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
