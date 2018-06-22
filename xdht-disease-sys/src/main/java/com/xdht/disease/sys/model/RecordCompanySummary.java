package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "record_company_summary")
public class RecordCompanySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 检查日期
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "inspection_date")
    private Date inspectionDate;

    /**
     * 检查机构
     */
    @Column(name = "inspection_agency")
    private String inspectionAgency;

    /**
     * 体检种类
     */
    @Column(name = "physical_examination_type")
    private String physicalExaminationType;

    /**
     * 应检人数
     */
    @Column(name = "inspected_number")
    private Long inspectedNumber;

    /**
     * 实检人数
     */
    @Column(name = "actual_inspectd_number")
    private Long actualInspectdNumber;

    /**
     * 未见异常
     */
    @Column(name = "no_abnormality")
    private Long noAbnormality;

    /**
     * 复查
     */
    @Column(name = "review_number")
    private Long reviewNumber;

    /**
     * 疑似
     */
    @Column(name = "doubtful_number")
    private Long doubtfulNumber;

    /**
     * 禁忌证
     */
    @Column(name = "taboo_number")
    private Long tabooNumber;

    /**
     * 其他疾患
     */
    @Column(name = "other_diseases_number")
    private Long otherDiseasesNumber;

    /**
     * 状态（0正常 1删除）
     */
    @Column(name = "status")
    private String status;

    /**
     * 备注
     */
    private String remarks;

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

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取检查日期
     *
     * @return inspection_date - 检查日期
     */
    public Date getInspectionDate() {
        return inspectionDate;
    }

    /**
     * 设置检查日期
     *
     * @param inspectionDate 检查日期
     */
    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    /**
     * 获取检查机构
     *
     * @return inspection_agency - 检查机构
     */
    public String getInspectionAgency() {
        return inspectionAgency;
    }

    /**
     * 设置检查机构
     *
     * @param inspectionAgency 检查机构
     */
    public void setInspectionAgency(String inspectionAgency) {
        this.inspectionAgency = inspectionAgency;
    }

    /**
     * 获取体检种类
     *
     * @return physical_examination_type - 体检种类
     */
    public String getPhysicalExaminationType() {
        return physicalExaminationType;
    }

    /**
     * 设置体检种类
     *
     * @param physicalExaminationType 体检种类
     */
    public void setPhysicalExaminationType(String physicalExaminationType) {
        this.physicalExaminationType = physicalExaminationType;
    }

    /**
     * 获取应检人数
     *
     * @return inspected_number - 应检人数
     */
    public Long getInspectedNumber() {
        return inspectedNumber;
    }

    /**
     * 设置应检人数
     *
     * @param inspectedNumber 应检人数
     */
    public void setInspectedNumber(Long inspectedNumber) {
        this.inspectedNumber = inspectedNumber;
    }

    /**
     * 获取实检人数
     *
     * @return actual_inspectd_number - 实检人数
     */
    public Long getActualInspectdNumber() {
        return actualInspectdNumber;
    }

    /**
     * 设置实检人数
     *
     * @param actualInspectdNumber 实检人数
     */
    public void setActualInspectdNumber(Long actualInspectdNumber) {
        this.actualInspectdNumber = actualInspectdNumber;
    }

    /**
     * 获取未见异常
     *
     * @return no_abnormality - 未见异常
     */
    public Long getNoAbnormality() {
        return noAbnormality;
    }

    /**
     * 设置未见异常
     *
     * @param noAbnormality 未见异常
     */
    public void setNoAbnormality(Long noAbnormality) {
        this.noAbnormality = noAbnormality;
    }

    /**
     * 获取复查
     *
     * @return review_number - 复查
     */
    public Long getReviewNumber() {
        return reviewNumber;
    }

    /**
     * 设置复查
     *
     * @param reviewNumber 复查
     */
    public void setReviewNumber(Long reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    /**
     * 获取疑似
     *
     * @return doubtful_number - 疑似
     */
    public Long getDoubtfulNumber() {
        return doubtfulNumber;
    }

    /**
     * 设置疑似
     *
     * @param doubtfulNumber 疑似
     */
    public void setDoubtfulNumber(Long doubtfulNumber) {
        this.doubtfulNumber = doubtfulNumber;
    }

    /**
     * 获取禁忌证
     *
     * @return taboo_number - 禁忌证
     */
    public Long getTabooNumber() {
        return tabooNumber;
    }

    /**
     * 设置禁忌证
     *
     * @param tabooNumber 禁忌证
     */
    public void setTabooNumber(Long tabooNumber) {
        this.tabooNumber = tabooNumber;
    }

    /**
     * 获取其他疾患
     *
     * @return other_diseases_number - 其他疾患
     */
    public Long getOtherDiseasesNumber() {
        return otherDiseasesNumber;
    }

    /**
     * 设置其他疾患
     *
     * @param otherDiseasesNumber 其他疾患
     */
    public void setOtherDiseasesNumber(Long otherDiseasesNumber) {
        this.otherDiseasesNumber = otherDiseasesNumber;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}