package com.entity.model;

import com.entity.PingshenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 评审
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PingshenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String pingshenUuidNumber;


    /**
     * 赛事提交
     */
    private Integer saishiTijiaoId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 参赛作品
     */
    private String pingshenFile;


    /**
     * 指导老师
     */
    private String pingshenZhidao;


    /**
     * 内容
     */
    private String pingshenText;


    /**
     * 赛事提交时间
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

    }
