package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "record_workplace_noise")
public class RecordWorkplaceNoise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司
     */
    @Column(name = "company_id")
    private Long companyId;

    /*
    * 检查时间*/
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "inspect_date")
    private Date inspectDate;

    /*
    * 检查年份*/

    @Column(name = "inspect_year")
    private Integer inspectYear;

    /**
     * 部门
     */
    @Column(name = "post_id")
    private Long postId;

    /*
    * 岗位*/
    @Column(name = "work_type_id")
    private Long workTypeId;

    /**
     * 接触时间
     */
    @Column(name = "contact_time")
    private BigDecimal contactTime;


    /**
     * 噪声频谱分析结果
     */
    @Column(name = "analysis_result")
    private String analysisResult;

    /**
     * 8h（或40h）等效声级[dB(A)]
     */
    @Column(name = "sound_level")
    private BigDecimal soundLevel;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

    /**
     * 检测地点
     */
    @Column(name = "check_place")
    private String checkPlace;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;


    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public Integer getInspectYear() {
        return inspectYear;
    }

    public void setInspectYear(Integer inspectYear) {
        this.inspectYear = inspectYear;
    }

    public Long getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Long workTypeId) {
        this.workTypeId = workTypeId;
    }

    public void setContactTime(BigDecimal contactTime) {
        this.contactTime = contactTime;
    }

    public void setSoundLevel(BigDecimal soundLevel) {
        this.soundLevel = soundLevel;
    }

    public BigDecimal getContactTime() {
        return contactTime;
    }

    public BigDecimal getSoundLevel() {
        return soundLevel;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取岗位
     *
     * @return post_id - 岗位
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置岗位
     *
     * @param postId 岗位
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }


    /**
     * 获取噪声频谱分析结果
     *
     * @return analysis_result - 噪声频谱分析结果
     */
    public String getAnalysisResult() {
        return analysisResult;
    }

    /**
     * 设置噪声频谱分析结果
     *
     * @param analysisResult 噪声频谱分析结果
     */
    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }


    /**
     * 获取状态（0正常 1删除）
     *
     * @return status - 状态（0正常 1删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除）
     *
     * @param status 状态（0正常 1删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取检测地点
     *
     * @return check_place - 检测地点
     */
    public String getCheckPlace() {
        return checkPlace;
    }

    /**
     * 设置检测地点
     *
     * @param checkPlace 检测地点
     */
    public void setCheckPlace(String checkPlace) {
        this.checkPlace = checkPlace;
    }
}