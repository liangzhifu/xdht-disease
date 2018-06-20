package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_individual_protective_equipment_data")
public class RecordIndividualProtectiveEquipmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "company_office_id")
    private Long companyOfficeId;

    /**
     * 工种id
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 接触职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

    /**
     * 防护用品名称
     */
    @Column(name = "protective_equipment")
    private String protectiveEquipment;

    /**
     * 技术参数
     */
    @Column(name = "technical_parameter")
    private String technicalParameter;

    /**
     * 数量
     */
    private Long number;

    /**
     * 使用情况
     */
    private String usaged;

    /**
     * 关联id
     */
    @Column(name = "relation_id")
    private Long relationId;

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
     * 获取部门id
     *
     * @return company_office_id - 部门id
     */
    public Long getCompanyOfficeId() {
        return companyOfficeId;
    }

    /**
     * 设置部门id
     *
     * @param companyOfficeId 部门id
     */
    public void setCompanyOfficeId(Long companyOfficeId) {
        this.companyOfficeId = companyOfficeId;
    }

    /**
     * 获取工种id
     *
     * @return post_id - 工种id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置工种id
     *
     * @param postId 工种id
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取接触职业病危害因素
     *
     * @return hazard_factors - 接触职业病危害因素
     */
    public String getHazardFactors() {
        return hazardFactors;
    }

    /**
     * 设置接触职业病危害因素
     *
     * @param hazardFactors 接触职业病危害因素
     */
    public void setHazardFactors(String hazardFactors) {
        this.hazardFactors = hazardFactors;
    }

    /**
     * 获取防护用品名称
     *
     * @return protective_equipment - 防护用品名称
     */
    public String getProtectiveEquipment() {
        return protectiveEquipment;
    }

    /**
     * 设置防护用品名称
     *
     * @param protectiveEquipment 防护用品名称
     */
    public void setProtectiveEquipment(String protectiveEquipment) {
        this.protectiveEquipment = protectiveEquipment;
    }

    /**
     * 获取技术参数
     *
     * @return technical_parameter - 技术参数
     */
    public String getTechnicalParameter() {
        return technicalParameter;
    }

    /**
     * 设置技术参数
     *
     * @param technicalParameter 技术参数
     */
    public void setTechnicalParameter(String technicalParameter) {
        this.technicalParameter = technicalParameter;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * 获取使用情况
     *
     * @return usaged - 使用情况
     */
    public String getUsaged() {
        return usaged;
    }

    /**
     * 设置使用情况
     *
     * @param usaged 使用情况
     */
    public void setUsaged(String usaged) {
        this.usaged = usaged;
    }

    /**
     * 获取关联id
     * @return relationId
     */
    public Long getRelationId() {
        return relationId;
    }

    /** 设置关联id
     * @param relationId
     */
    public void setRelationId(Long relationId) { this.relationId = relationId; }
}