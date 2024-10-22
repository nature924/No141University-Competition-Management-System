package com.entity.vo;

import com.entity.PingshenPingfenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 评审打分
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pingshen_pingfen")
public class PingshenPingfenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "pingshen_pingfen_uuid_number")
    private String pingshenPingfenUuidNumber;


    /**
     * 评审分配
     */

    @TableField(value = "pingshen_fenpei_id")
    private Integer pingshenFenpeiId;


    /**
     * 专家
     */

    @TableField(value = "zhuanjia_id")
    private Integer zhuanjiaId;


    /**
     * 打分
     */

    @TableField(value = "pingshen_pingfen_pingfen")
    private Integer pingshenPingfenPingfen;


    /**
     * 内容
     */

    @TableField(value = "pingshen_pingfen_text")
    private String pingshenPingfenText;


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
    public String getPingshenPingfenUuidNumber() {
        return pingshenPingfenUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setPingshenPingfenUuidNumber(String pingshenPingfenUuidNumber) {
        this.pingshenPingfenUuidNumber = pingshenPingfenUuidNumber;
    }
    /**
	 * 设置：评审分配
	 */
    public Integer getPingshenFenpeiId() {
        return pingshenFenpeiId;
    }


    /**
	 * 获取：评审分配
	 */

    public void setPingshenFenpeiId(Integer pingshenFenpeiId) {
        this.pingshenFenpeiId = pingshenFenpeiId;
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
	 * 设置：打分
	 */
    public Integer getPingshenPingfenPingfen() {
        return pingshenPingfenPingfen;
    }


    /**
	 * 获取：打分
	 */

    public void setPingshenPingfenPingfen(Integer pingshenPingfenPingfen) {
        this.pingshenPingfenPingfen = pingshenPingfenPingfen;
    }
    /**
	 * 设置：内容
	 */
    public String getPingshenPingfenText() {
        return pingshenPingfenText;
    }


    /**
	 * 获取：内容
	 */

    public void setPingshenPingfenText(String pingshenPingfenText) {
        this.pingshenPingfenText = pingshenPingfenText;
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
