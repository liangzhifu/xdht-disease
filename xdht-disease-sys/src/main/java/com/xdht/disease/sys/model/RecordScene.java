package com.xdht.disease.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "record_scene")
public class RecordScene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 编号
     */
    @Column(name = "record_no")
    private String recordNo;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 调查年份
     */
    @Column(name = "inquiry_year")
    private Integer inquiryYear;

    /**
     * 调查类型
     */
    @Column(name = "inquiry_type")
    private Long inquiryType;

    /**
     * 调查人
     */
    @Column(name = "inquiry_person")
    private String inquiryPerson;

    /**
     * 调查对象
     */
    @Column(name = "inquiry_company")
    private Long inquiryCompany;

    /**
     * 用人单位陪同人
     */
    @Column(name = "inquiry_company_employee")
    private Long inquiryCompanyEmployee;

    /**
     * 调查日期
     */
    @Column(name = "inquiry_date")
    private Date inquiryDate;

    /**
     * 状态（0正常 1删除）
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
     * 更新状态
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
     * 获取编号
     *
     * @return record_no - 编号
     */
    public String getRecordNo() {
        return recordNo;
    }

    /**
     * 设置编号
     *
     * @param recordNo 编号
     */
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取调查年份
     *
     * @return inquiry_year - 调查年份
     */
    public Integer getInquiryYear() {
        return inquiryYear;
    }

    /**
     * 设置调查年份
     *
     * @param inquiryYear 调查年份
     */
    public void setInquiryYear(Integer inquiryYear) {
        this.inquiryYear = inquiryYear;
    }

    /**
     * 获取调查类型
     *
     * @return inquiry_type - 调查类型
     */
    public Long getInquiryType() {
        return inquiryType;
    }

    /**
     * 设置调查类型
     *
     * @param inquiryType 调查类型
     */
    public void setInquiryType(Long inquiryType) {
        this.inquiryType = inquiryType;
    }

    /**
     * 获取调查人
     *
     * @return inquiry_person - 调查人
     */
    public String getInquiryPerson() {
        return inquiryPerson;
    }

    /**
     * 设置调查人
     *
     * @param inquiryPerson 调查人
     */
    public void setInquiryPerson(String inquiryPerson) {
        this.inquiryPerson = inquiryPerson;
    }

    /**
     * 获取调查对象
     *
     * @return inquiry_company - 调查对象
     */
    public Long getInquiryCompany() {
        return inquiryCompany;
    }

    /**
     * 设置调查对象
     *
     * @param inquiryCompany 调查对象
     */
    public void setInquiryCompany(Long inquiryCompany) {
        this.inquiryCompany = inquiryCompany;
    }

    /**
     * 获取用人单位陪同人
     *
     * @return inquiry_company_employee - 用人单位陪同人
     */
    public Long getInquiryCompanyEmployee() {
        return inquiryCompanyEmployee;
    }

    /**
     * 设置用人单位陪同人
     *
     * @param inquiryCompanyEmployee 用人单位陪同人
     */
    public void setInquiryCompanyEmployee(Long inquiryCompanyEmployee) {
        this.inquiryCompanyEmployee = inquiryCompanyEmployee;
    }

    /**
     * 获取调查日期
     *
     * @return inquiry_date - 调查日期
     */
    public Date getInquiryDate() {
        return inquiryDate;
    }

    /**
     * 设置调查日期
     *
     * @param inquiryDate 调查日期
     */
    public void setInquiryDate(Date inquiryDate) {
        this.inquiryDate = inquiryDate;
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
     * 获取更新状态
     *
     * @return update_date - 更新状态
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新状态
     *
     * @param updateDate 更新状态
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}