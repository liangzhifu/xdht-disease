package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_employee_job")
public class SysEmployeeJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 员工id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 开始日期
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * 结束日期
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 工作单位
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 工种
     */
    @Column(name = "work_type")
    private Long workType;

    /**
     * 噪声检测结果
     */
    @Column(name = "noise_detection_results")
    private String noiseDetectionResults;

    /**
     * 防护措施
     */
    @Column(name = "protective_measures")
    private String protectiveMeasures;

    /**
     * 状态（0有效 1删除）
     */
    private String status;

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

    /**
     * 获取员工id
     *
     * @return employee_id - 员工id
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工id
     *
     * @param employeeId 员工id
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取开始日期
     *
     * @return begin_date - 开始日期
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置开始日期
     *
     * @param beginDate 开始日期
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取介绍日期
     *
     * @return end_date - 介绍日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置介绍日期
     *
     * @param endDate 介绍日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取工作单位
     *
     * @return company_name - 工作单位
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置工作单位
     *
     * @param companyName 工作单位
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取工种
     *
     * @return work_type - 工种
     */
    public Long getWorkType() {
        return workType;
    }

    /**
     * 设置工种
     *
     * @param workType 工种
     */
    public void setWorkType(Long workType) {
        this.workType = workType;
    }

    /**
     * 获取噪声检测结果
     *
     * @return noise_detection_results - 噪声检测结果
     */
    public String getNoiseDetectionResults() {
        return noiseDetectionResults;
    }

    /**
     * 设置噪声检测结果
     *
     * @param noiseDetectionResults 噪声检测结果
     */
    public void setNoiseDetectionResults(String noiseDetectionResults) {
        this.noiseDetectionResults = noiseDetectionResults;
    }

    /**
     * 获取防护措施
     *
     * @return protective_measures - 防护措施
     */
    public String getProtectiveMeasures() {
        return protectiveMeasures;
    }

    /**
     * 设置防护措施
     *
     * @param protectiveMeasures 防护措施
     */
    public void setProtectiveMeasures(String protectiveMeasures) {
        this.protectiveMeasures = protectiveMeasures;
    }

    /**
     * 获取状态（0有效 1删除）
     *
     * @return status - 状态（0有效 1删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0有效 1删除）
     *
     * @param status 状态（0有效 1删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}