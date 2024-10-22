package com.entity.vo;

import com.entity.HuojiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 获奖
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huojiang")
public class HuojiangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 获奖名称
     */

    @TableField(value = "huojiang_name")
    private String huojiangName;


    /**
     * 获奖编号
     */

    @TableField(value = "huojiang_uuid_number")
    private String huojiangUuidNumber;


    /**
     * 获奖照片
     */

    @TableField(value = "huojiang_photo")
    private String huojiangPhoto;


    /**
     * 获奖类型
     */

    @TableField(value = "huojiang_types")
    private Integer huojiangTypes;


    /**
     * 学生排名
     */

    @TableField(value = "huojiang_xues")
    private Integer huojiangXues;


    /**
     * 获奖介绍
     */

    @TableField(value = "huojiang_content")
    private String huojiangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "huojiang_delete")
    private Integer huojiangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：获奖名称
	 */
    public String getHuojiangName() {
        return huojiangName;
    }


    /**
	 * 获取：获奖名称
	 */

    public void setHuojiangName(String huojiangName) {
        this.huojiangName = huojiangName;
    }
    /**
	 * 设置：获奖编号
	 */
    public String getHuojiangUuidNumber() {
        return huojiangUuidNumber;
    }


    /**
	 * 获取：获奖编号
	 */

    public void setHuojiangUuidNumber(String huojiangUuidNumber) {
        this.huojiangUuidNumber = huojiangUuidNumber;
    }
    /**
	 * 设置：获奖照片
	 */
    public String getHuojiangPhoto() {
        return huojiangPhoto;
    }


    /**
	 * 获取：获奖照片
	 */

    public void setHuojiangPhoto(String huojiangPhoto) {
        this.huojiangPhoto = huojiangPhoto;
    }
    /**
	 * 设置：获奖类型
	 */
    public Integer getHuojiangTypes() {
        return huojiangTypes;
    }


    /**
	 * 获取：获奖类型
	 */

    public void setHuojiangTypes(Integer huojiangTypes) {
        this.huojiangTypes = huojiangTypes;
    }
    /**
	 * 设置：学生排名
	 */
    public Integer getHuojiangXues() {
        return huojiangXues;
    }


    /**
	 * 获取：学生排名
	 */

    public void setHuojiangXues(Integer huojiangXues) {
        this.huojiangXues = huojiangXues;
    }
    /**
	 * 设置：获奖介绍
	 */
    public String getHuojiangContent() {
        return huojiangContent;
    }


    /**
	 * 获取：获奖介绍
	 */

    public void setHuojiangContent(String huojiangContent) {
        this.huojiangContent = huojiangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getHuojiangDelete() {
        return huojiangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setHuojiangDelete(Integer huojiangDelete) {
        this.huojiangDelete = huojiangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
