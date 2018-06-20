package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_informing_facilities_data")
public class RecordInformingFacilitiesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "company_office_id")
    private Long companyOfficeId;

    /**
     * 工艺过程
     */
    @Column(name = "process_name")
    private String processName;

    /**
     * 职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

    /**
     * 危害告知设施设置情况（告知卡、警示线、警示标识、公告栏等）
     */
    @Column(name = "informing_facilities")
    private String informingFacilities;

    /**
     * 设置地点
     */
    @Column(name = "setting_place")
    private String settingPlace;

    /**
     * 备注
     */
    private String remarks;


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
     * 获取部门ID
     *
     * @return company_office_id - 部门ID
     */
    public Long getCompanyOfficeId() {
        return companyOfficeId;
    }

    /**
     * 设置部门ID
     *
     * @param companyOfficeId 部门ID
     */
    public void setCompanyOfficeId(Long companyOfficeId) {
        this.companyOfficeId = companyOfficeId;
    }

    /**
     * 获取工艺过程
     *
     * @return process_name - 工艺过程
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 设置工艺过程
     *
     * @param processName 工艺过程
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 获取职业病危害因素
     *
     * @return hazard_factors - 职业病危害因素
     */
    public String getHazardFactors() {
        return hazardFactors;
    }

    /**
     * 设置职业病危害因素
     *
     * @param hazardFactors 职业病危害因素
     */
    public void setHazardFactors(String hazardFactors) {
        this.hazardFactors = hazardFactors;
    }

    /**
     * 获取危害告知设施设置情况（告知卡、警示线、警示标识、公告栏等）
     *
     * @return informing_facilities - 危害告知设施设置情况（告知卡、警示线、警示标识、公告栏等）
     */
    public String getInformingFacilities() {
        return informingFacilities;
    }

    /**
     * 设置危害告知设施设置情况（告知卡、警示线、警示标识、公告栏等）
     *
     * @param informingFacilities 危害告知设施设置情况（告知卡、警示线、警示标识、公告栏等）
     */
    public void setInformingFacilities(String informingFacilities) {
        this.informingFacilities = informingFacilities;
    }

    /**
     * 获取设置地点
     *
     * @return setting_place - 设置地点
     */
    public String getSettingPlace() {
        return settingPlace;
    }

    /**
     * 设置设置地点
     *
     * @param settingPlace 设置地点
     */
    public void setSettingPlace(String settingPlace) {
        this.settingPlace = settingPlace;
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