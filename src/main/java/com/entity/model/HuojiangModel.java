package com.entity.model;

import com.entity.HuojiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 获奖
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuojiangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 获奖名称
     */
    private String huojiangName;


    /**
     * 获奖编号
     */
    private String huojiangUuidNumber;


    /**
     * 获奖照片
     */
    private String huojiangPhoto;


    /**
     * 获奖类型
     */
    private Integer huojiangTypes;


    /**
     * 学生排名
     */
    private Integer huojiangXues;


    /**
     * 获奖介绍
     */
    private String huojiangContent;


    /**
     * 逻辑删除
     */
    private Integer huojiangDelete;


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
