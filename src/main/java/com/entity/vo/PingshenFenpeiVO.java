package com.entity.vo;

import com.entity.PingshenFenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 评审分配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pingshen_fenpei")
public class PingshenFenpeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "pingshen_fenpei_uuid_number")
    private String pingshenFenpeiUuidNumber;


    /**
     * 评审
     */

    @TableField(value = "pingshen_id")
    private Integer pingshenId;


    /**
     * 专家
     */

    @TableField(value = "zhuanjia_id")
    private Integer zhuanjiaId;


    /**
     * 内容
     */

    @TableField(value = "pingshen_fenpei_text")
    private String pingshenFenpeiText;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
    public String getPingshenFenpeiUuidNumber() {
        return pingshenFenpeiUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setPingshenFenpeiUuidNumber(String pingshenFenpeiUuidNumber) {
        this.pingshenFenpeiUuidNumber = pingshenFenpeiUuidNumber;
    }
    /**
	 * 设置：评审
	 */
    public Integer getPingshenId() {
        return pingshenId;
    }


    /**
	 * 获取：评审
	 */

    public void setPingshenId(Integer pingshenId) {
        this.pingshenId = pingshenId;
    }
    /**
	 * 设置：专家
	 */
    public Integer getZhuanjiaId() {
        return zhuanjiaId;
    }


    /**
	 * 获取：专家
	 */

    public void setZhuanjiaId(Integer zhuanjiaId) {
        this.zhuanjiaId = zhuanjiaId;
    }
    /**
	 * 设置：内容
	 */
    public String getPingshenFenpeiText() {
        return pingshenFenpeiText;
    }


    /**
	 * 获取：内容
	 */

    public void setPingshenFenpeiText(String pingshenFenpeiText) {
        this.pingshenFenpeiText = pingshenFenpeiText;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：分配时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
