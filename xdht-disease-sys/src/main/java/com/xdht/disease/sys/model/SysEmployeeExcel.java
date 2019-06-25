package com.xdht.disease.sys.model;

import com.xdht.disease.common.annotation.ExcelImport;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_employee_excel")
public class SysEmployeeExcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司
     */
    @ExcelImport
    @Column(name = "company_name")
    private String companyName;

    /**
     * 部门
     */
    @ExcelImport
    @Column(name = "office_name")
    private String officeName;

    /**
     * 工种
     */
    @ExcelImport
    @Column(name = "work_type_name")
    private String workTypeName;

    /**
     * 员工姓名
     */
    @ExcelImport
    @Column(name = "emp_name")
    private String empName;

    /**
     * 员工性别
     */
    @ExcelImport
    @Column(name = "emp_sex_name")
    private String empSexName;

    /**
     * 籍贯
     */
    @ExcelImport
    @Column(name = "emp_native")
    private String empNative;

    /**
     * 婚姻
     */
    @ExcelImport
    @Column(name = "emp_marriage_name")
    private String empMarriageName;

    /**
     * 文化程度
     */
    @ExcelImport
    @Column(name = "emp_education")
    private String empEducation;

    /**
     * 嗜好
     */
    @ExcelImport
    @Column(name = "emp_hobby")
    private String empHobby;

    /**
     * 接害时间
     */
    @ExcelImport
    @Column(name = "contact_time")
    private Integer contactTime;

    /**
     * 参加工作时间
     */
    @ExcelImport
    @Column(name = "emp_work_date")
    private Date empWorkDate;

    /**
     * 身份证号
     */
    @ExcelImport
    @Column(name = "emp_identity_number")
    private String empIdentityNumber;

    /**
     * 公司Id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 部门ID
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 工种ID
     */
    @Column(name = "work_type_id")
    private Long workTypeId;

    /**
     * 性别
     */
    @Column(name = "emp_sex")
    private String empSex;

    /**
     * 婚姻
     */
    @Column(name = "emp_marriage")
    private String empMarriage;

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
     * 获取公司
     *
     * @return company_name - 公司
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司
     *
     * @param companyName 公司
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取部门
     *
     * @return office_name - 部门
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * 设置部门
     *
     * @param officeName 部门
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * 获取工种
     *
     * @return work_type_name - 工种
     */
    public String getWorkTypeName() {
        return workTypeName;
    }

    /**
     * 设置工种
     *
     * @param workTypeName 工种
     */
    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
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
     * 获取员工性别
     *
     * @return emp_sex_name - 员工性别
     */
    public String getEmpSexName() {
        return empSexName;
    }

    /**
     * 设置员工性别
     *
     * @param empSexName 员工性别
     */
    public void setEmpSexName(String empSexName) {
        this.empSexName = empSexName;
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
     * @return emp_marriage_name - 婚姻
     */
    public String getEmpMarriageName() {
        return empMarriageName;
    }

    /**
     * 设置婚姻
     *
     * @param empMarriageName 婚姻
     */
    public void setEmpMarriageName(String empMarriageName) {
        this.empMarriageName = empMarriageName;
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
     * 获取接害时间
     *
     * @return contact_time - 接害时间
     */
    public Integer getContactTime() {
        return contactTime;
    }

    /**
     * 设置接害时间
     *
     * @param contactTime 接害时间
     */
    public void setContactTime(Integer contactTime) {
        this.contactTime = contactTime;
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
     * 获取公司Id
     *
     * @return company_id - 公司Id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司Id
     *
     * @param companyId 公司Id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门ID
     *
     * @return office_id - 部门ID
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门ID
     *
     * @param officeId 部门ID
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取工种ID
     *
     * @return work_type_id - 工种ID
     */
    public Long getWorkTypeId() {
        return workTypeId;
    }

    /**
     * 设置工种ID
     *
     * @param workTypeId 工种ID
     */
    public void setWorkTypeId(Long workTypeId) {
        this.workTypeId = workTypeId;
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

}