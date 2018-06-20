package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_employee_disease")
public class SysEmployeeDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 员工id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 职业病名称
     */
    @Column(name = "disease_name")
    private String diseaseName;

    /**
     * 诊断日期
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
     * 诊断级别
     */
    @Column(name = "diagnosis_level")
    private String diagnosisLevel;

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
     * 获取职业病名称
     *
     * @return disease_name - 职业病名称
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * 设置职业病名称
     *
     * @param diseaseName 职业病名称
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    /**
     * 获取诊断日期
     *
     * @return diagnosis_date - 诊断日期
     */
    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    /**
     * 设置诊断日期
     *
     * @param diagnosisDate 诊断日期
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
     * 获取诊断级别
     *
     * @return diagnosis_level - 诊断级别
     */
    public String getDiagnosisLevel() {
        return diagnosisLevel;
    }

    /**
     * 设置诊断级别
     *
     * @param diagnosisLevel 诊断级别
     */
    public void setDiagnosisLevel(String diagnosisLevel) {
        this.diagnosisLevel = diagnosisLevel;
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