package com.entity.vo;

import com.entity.PingshenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 评审
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pingshen")
public class PingshenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "pingshen_uuid_number")
    private String pingshenUuidNumber;


    /**
     * 赛事提交
     */

    @TableField(value = "saishi_tijiao_id")
    private Integer saishiTijiaoId;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 参赛作品
     */

    @TableField(value = "pingshen_file")
    private String pingshenFile;


    /**
     * 指导老师
     */

    @TableField(value = "pingshen_zhidao")
    private String pingshenZhidao;


    /**
     * 内容
     */

    @TableField(value = "pingshen_text")
    private String pingshenText;


    /**
     * 赛事提交时间
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
    public String getPingshenUuidNumber() {
        return pingshenUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setPingshenUuidNumber(String pingshenUuidNumber) {
        this.pingshenUuidNumber = pingshenUuidNumber;
    }
    /**
	 * 设置：赛事提交
	 */
    public Integer getSaishiTijiaoId() {
        return saishiTijiaoId;
    }


    /**
	 * 获取：赛事提交
	 */

    public void setSaishiTijiaoId(Integer saishiTijiaoId) {
        this.saishiTijiaoId = saishiTijiaoId;
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
	 * 设置：参赛作品
	 */
    public String getPingshenFile() {
        return pingshenFile;
    }


    /**
	 * 获取：参赛作品
	 */

    public void setPingshenFile(String pingshenFile) {
        this.pingshenFile = pingshenFile;
    }
    /**
	 * 设置：指导老师
	 */
    public String getPingshenZhidao() {
        return pingshenZhidao;
    }


    /**
	 * 获取：指导老师
	 */

    public void setPingshenZhidao(String pingshenZhidao) {
        this.pingshenZhidao = pingshenZhidao;
    }
    /**
	 * 设置：内容
	 */
    public String getPingshenText() {
        return pingshenText;
    }


    /**
	 * 获取：内容
	 */

    public void setPingshenText(String pingshenText) {
        this.pingshenText = pingshenText;
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
