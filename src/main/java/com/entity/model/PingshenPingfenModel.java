package com.entity.model;

import com.entity.PingshenPingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 评审打分
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PingshenPingfenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String pingshenPingfenUuidNumber;


    /**
     * 评审分配
     */
    private Integer pingshenFenpeiId;


    /**
     * 专家
     */
    private Integer zhuanjiaId;


    /**
     * 打分
     */
    private Integer pingshenPingfenPingfen;


    /**
     * 内容
     */
    private String pingshenPingfenText;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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

    }
