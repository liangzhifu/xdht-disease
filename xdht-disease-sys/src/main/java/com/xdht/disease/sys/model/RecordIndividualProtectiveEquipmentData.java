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
     * 耳塞型号
     */
    @Column(name = "earplugs_model")
    private String earplugsModel;

    /**
     * 耳塞NRR
     */
    @Column(name = "earplugs_nrr")
    private String earplugsNrr;

    /**
     * 耳塞SNR
     */
    @Column(name = "earplugs_snr")
    private String earplugsSnr;

    /**
     * 耳罩型号
     */
    @Column(name = "earmuff_model")
    private String earmuffModel;

    /**
     * 耳罩NRR
     */
    @Column(name = "earmuff_nrr")
    private String earmuffNrr;

    /**
     * 耳罩SNR
     */
    @Column(name = "earmuff_snr")
    private String earmuffSnr;

    /**
     * 配备情况
     */
    @Column(name = "allocation_situation")
    private String allocationSituation;

    /**
     * 使用情况
     */
    @Column(name = "usage_situation")
    private String usageSituation;

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
     *
     * @return relation_id - 关联id
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 设置关联id
     *
     * @param relationId 关联id
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取耳塞型号
     *
     * @return earplugs_model - 耳塞型号
     */
    public String getEarplugsModel() {
        return earplugsModel;
    }

    /**
     * 设置耳塞型号
     *
     * @param earplugsModel 耳塞型号
     */
    public void setEarplugsModel(String earplugsModel) {
        this.earplugsModel = earplugsModel;
    }

    /**
     * 获取耳塞NRR
     *
     * @return earplugs_nrr - 耳塞NRR
     */
    public String getEarplugsNrr() {
        return earplugsNrr;
    }

    /**
     * 设置耳塞NRR
     *
     * @param earplugsNrr 耳塞NRR
     */
    public void setEarplugsNrr(String earplugsNrr) {
        this.earplugsNrr = earplugsNrr;
    }

    /**
     * 获取耳塞SNR
     *
     * @return earplugs_snr - 耳塞SNR
     */
    public String getEarplugsSnr() {
        return earplugsSnr;
    }

    /**
     * 设置耳塞SNR
     *
     * @param earplugsSnr 耳塞SNR
     */
    public void setEarplugsSnr(String earplugsSnr) {
        this.earplugsSnr = earplugsSnr;
    }

    /**
     * 获取耳罩型号
     *
     * @return earmuff_model - 耳罩型号
     */
    public String getEarmuffModel() {
        return earmuffModel;
    }

    /**
     * 设置耳罩型号
     *
     * @param earmuffModel 耳罩型号
     */
    public void setEarmuffModel(String earmuffModel) {
        this.earmuffModel = earmuffModel;
    }

    /**
     * 获取耳罩NRR
     *
     * @return earmuff_nrr - 耳罩NRR
     */
    public String getEarmuffNrr() {
        return earmuffNrr;
    }

    /**
     * 设置耳罩NRR
     *
     * @param earmuffNrr 耳罩NRR
     */
    public void setEarmuffNrr(String earmuffNrr) {
        this.earmuffNrr = earmuffNrr;
    }

    /**
     * 获取耳罩SNR
     *
     * @return earmuff_snr - 耳罩SNR
     */
    public String getEarmuffSnr() {
        return earmuffSnr;
    }

    /**
     * 设置耳罩SNR
     *
     * @param earmuffSnr 耳罩SNR
     */
    public void setEarmuffSnr(String earmuffSnr) {
        this.earmuffSnr = earmuffSnr;
    }

    /**
     * 获取配备情况
     *
     * @return allocation_situation - 配备情况
     */
    public String getAllocationSituation() {
        return allocationSituation;
    }

    /**
     * 设置配备情况
     *
     * @param allocationSituation 配备情况
     */
    public void setAllocationSituation(String allocationSituation) {
        this.allocationSituation = allocationSituation;
    }

    /**
     * 获取使用情况
     *
     * @return usage_situation - 使用情况
     */
    public String getUsageSituation() {
        return usageSituation;
    }

    /**
     * 设置使用情况
     *
     * @param usageSituation 使用情况
     */
    public void setUsageSituation(String usageSituation) {
        this.usageSituation = usageSituation;
    }
}