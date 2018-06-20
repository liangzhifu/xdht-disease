package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_employee")
public class SysEmployee {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 员工姓名
     */
    @Column(name = "emp_name")
    private String empName;

    /**
     * 性别
     */
    @Column(name = "emp_sex")
    private String empSex;

    /**
     * 籍贯
     */
    @Column(name = "emp_native")
    private String empNative;

    /**
     * 婚姻
     */
    @Column(name = "emp_marriage")
    private String empMarriage;

    /**
     * 文化程度
     */
    @Column(name = "emp_education")
    private String empEducation;

    /**
     * 嗜好
     */
    @Column(name = "emp_hobby")
    private String empHobby;

    /**
     * 参加工作时间
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "emp_work_date")
    private Date empWorkDate;

    /**
     * 身份证号
     */
    @Column(name = "emp_identity_number")
    private String empIdentityNumber;

    /**
     * 照片路径
     */
    @Column(name = "emp_photo_url")
    private String empPhotoUrl;

    /**
     * 状态（0在职 1离职）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取部门id
     *
     * @return office_id - 部门id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门id
     *
     * @param officeId 部门id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取员工姓名
     *
     * @return emp_name - 员工姓名
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置员工姓名
     *
     * @param empName 员工姓名
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取性别
     *
     * @return emp_sex - 性别
     */
    public String getEmpSex() {
        return empSex;
    }

    /**
     * 设置性别
     *
     * @param empSex 性别
     */
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    /**
     * 获取籍贯
     *
     * @return emp_native - 籍贯
     */
    public String getEmpNative() {
        return empNative;
    }

    /**
     * 设置籍贯
     *
     * @param empNative 籍贯
     */
    public void setEmpNative(String empNative) {
        this.empNative = empNative;
    }

    /**
     * 获取婚姻
     *
     * @return emp_marriage - 婚姻
     */
    public String getEmpMarriage() {
        return empMarriage;
    }

    /**
     * 设置婚姻
     *
     * @param empMarriage 婚姻
     */
    public void setEmpMarriage(String empMarriage) {
        this.empMarriage = empMarriage;
    }

    /**
     * 获取文化程度
     *
     * @return emp_education - 文化程度
     */
    public String getEmpEducation() {
        return empEducation;
    }

    /**
     * 设置文化程度
     *
     * @param empEducation 文化程度
     */
    public void setEmpEducation(String empEducation) {
        this.empEducation = empEducation;
    }

    /**
     * 获取嗜好
     *
     * @return emp_hobby - 嗜好
     */
    public String getEmpHobby() {
        return empHobby;
    }

    /**
     * 设置嗜好
     *
     * @param empHobby 嗜好
     */
    public void setEmpHobby(String empHobby) {
        this.empHobby = empHobby;
    }

    /**
     * 获取参加工作时间
     *
     * @return emp_work_date - 参加工作时间
     */
    public Date getEmpWorkDate() {
        return empWorkDate;
    }

    /**
     * 设置参加工作时间
     *
     * @param empWorkDate 参加工作时间
     */
    public void setEmpWorkDate(Date empWorkDate) {
        this.empWorkDate = empWorkDate;
    }

    /**
     * 获取身份证号
     *
     * @return emp_identity_number - 身份证号
     */
    public String getEmpIdentityNumber() {
        return empIdentityNumber;
    }

    /**
     * 设置身份证号
     *
     * @param empIdentityNumber 身份证号
     */
    public void setEmpIdentityNumber(String empIdentityNumber) {
        this.empIdentityNumber = empIdentityNumber;
    }

    /**
     * 获取照片路径
     *
     * @return emp_photo_url - 照片路径
     */
    public String getEmpPhotoUrl() {
        return empPhotoUrl;
    }

    /**
     * 设置照片路径
     *
     * @param empPhotoUrl 照片路径
     */
    public void setEmpPhotoUrl(String empPhotoUrl) {
        this.empPhotoUrl = empPhotoUrl;
    }

    /**
     * 获取状态（0在职 1离职）
     *
     * @return status - 状态（0在职 1离职）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0在职 1离职）
     *
     * @param status 状态（0在职 1离职）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
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

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}