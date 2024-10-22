package com.entity.model;

import com.entity.PingshenFenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 评审分配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PingshenFenpeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String pingshenFenpeiUuidNumber;


    /**
     * 评审
     */
    private Integer pingshenId;


    /**
     * 专家
     */
    private Integer zhuanjiaId;


    /**
     * 内容
     */
    private String pingshenFenpeiText;


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
    public String getPingshenFenpeiUuidNumber() {
        return pingshenFenpeiUuidNumber;
    }


    /**
	 * 设置：报名唯一编号
	 */
    public void setPingshenFenpeiUuidNumber(String pingshenFenpeiUuidNumber) {
        this.pingshenFenpeiUuidNumber = pingshenFenpeiUuidNumber;
    }
    /**
	 * 获取：评审
	 */
    public Integer getPingshenId() {
        return pingshenId;
    }


    /**
	 * 设置：评审
	 */
    public void setPingshenId(Integer pingshenId) {
        this.pingshenId = pingshenId;
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
	 * 获取：内容
	 */
    public String getPingshenFenpeiText() {
        return pingshenFenpeiText;
    }


    /**
	 * 设置：内容
	 */
    public void setPingshenFenpeiText(String pingshenFenpeiText) {
        this.pingshenFenpeiText = pingshenFenpeiText;
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
