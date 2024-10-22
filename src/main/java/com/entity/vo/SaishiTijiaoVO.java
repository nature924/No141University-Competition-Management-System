package com.entity.vo;

import com.entity.SaishiTijiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事提交
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishi_tijiao")
public class SaishiTijiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "saishi_tijiao_uuid_number")
    private String saishiTijiaoUuidNumber;


    /**
     * 赛事
     */

    @TableField(value = "saishi_id")
    private Integer saishiId;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 内容
     */

    @TableField(value = "saishi_tijiao_text")
    private String saishiTijiaoText;


    /**
     * 赛事作品
     */

    @TableField(value = "saishi_shangchuan_file")
    private String saishiShangchuanFile;


    /**
     * 提交状态
     */

    @TableField(value = "saishi_tijiao_yesno_types")
    private Integer saishiTijiaoYesnoTypes;


    /**
     * 赛事提交时间
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
	 * 设置：报名唯一编号
	 */
    public String getSaishiTijiaoUuidNumber() {
        return saishiTijiaoUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setSaishiTijiaoUuidNumber(String saishiTijiaoUuidNumber) {
        this.saishiTijiaoUuidNumber = saishiTijiaoUuidNumber;
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
	 * 设置：内容
	 */
    public String getSaishiTijiaoText() {
        return saishiTijiaoText;
    }


    /**
	 * 获取：内容
	 */

    public void setSaishiTijiaoText(String saishiTijiaoText) {
        this.saishiTijiaoText = saishiTijiaoText;
    }
    /**
	 * 设置：赛事作品
	 */
    public String getSaishiShangchuanFile() {
        return saishiShangchuanFile;
    }


    /**
	 * 获取：赛事作品
	 */

    public void setSaishiShangchuanFile(String saishiShangchuanFile) {
        this.saishiShangchuanFile = saishiShangchuanFile;
    }
    /**
	 * 设置：提交状态
	 */
    public Integer getSaishiTijiaoYesnoTypes() {
        return saishiTijiaoYesnoTypes;
    }


    /**
	 * 获取：提交状态
	 */

    public void setSaishiTijiaoYesnoTypes(Integer saishiTijiaoYesnoTypes) {
        this.saishiTijiaoYesnoTypes = saishiTijiaoYesnoTypes;
    }
    /**
	 * 设置：赛事提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：赛事提交时间
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
