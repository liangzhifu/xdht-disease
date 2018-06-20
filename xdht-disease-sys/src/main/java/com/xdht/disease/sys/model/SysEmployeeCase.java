package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_employee_case")
public class SysEmployeeCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 员工ID
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 疾病名称
     */
    @Column(name = "case_name")
    private String caseName;

    /**
     * 诊断时间
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    /**
     * 诊断医院
     */
    @Column(name = "diagnosis_hospital")
    private String diagnosisHospital;

    /**
     * 治疗结果
     */
    @Column(name = "treatment_results")
    private String treatmentResults;

    /**
     * 备注
     */
    private String remarks;

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
     * 获取员工ID
     *
     * @return employee_id - 员工ID
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工ID
     *
     * @param employeeId 员工ID
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取疾病名称
     *
     * @return case_name - 疾病名称
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * 设置疾病名称
     *
     * @param caseName 疾病名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 获取诊断时间
     *
     * @return diagnosis_date - 诊断时间
     */
    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    /**
     * 设置诊断时间
     *
     * @param diagnosisDate 诊断时间
     */
    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    /**
     * 获取诊断医院
     *
     * @return diagnosis_hospital - 诊断医院
     */
    public String getDiagnosisHospital() {
        return diagnosisHospital;
    }

    /**
     * 设置诊断医院
     *
     * @param diagnosisHospital 诊断医院
     */
    public void setDiagnosisHospital(String diagnosisHospital) {
        this.diagnosisHospital = diagnosisHospital;
    }

    /**
     * 获取治疗结果
     *
     * @return treatment_results - 治疗结果
     */
    public String getTreatmentResults() {
        return treatmentResults;
    }

    /**
     * 设置治疗结果
     *
     * @param treatmentResults 治疗结果
     */
    public void setTreatmentResults(String treatmentResults) {
        this.treatmentResults = treatmentResults;
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