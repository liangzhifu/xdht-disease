package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_temperature_protection_facilities_data")
public class RecordTemperatureProtectionFacilitiesData {
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
     * 工作地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 运行维护情况
     */
    @Column(name = "operation_and_maintenance")
    private String operationAndMaintenance;

    /**
     * 生产性热源
     */
    @Column(name = "productive_heat_source")
    private String productiveHeatSource;

    /**
     * 防高温设施（保温隔热、通风等）
     */
    @Column(name = "temperature_protection_facilities")
    private String temperatureProtectionFacilities;

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
     * 获取工作地点
     *
     * @return work_place - 工作地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置工作地点
     *
     * @param workPlace 工作地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * 获取运行维护情况
     *
     * @return operation_and_maintenance - 运行维护情况
     */
    public String getOperationAndMaintenance() {
        return operationAndMaintenance;
    }

    /**
     * 设置运行维护情况
     *
     * @param operationAndMaintenance 运行维护情况
     */
    public void setOperationAndMaintenance(String operationAndMaintenance) {
        this.operationAndMaintenance = operationAndMaintenance;
    }

    /**
     * 获取生产性热源
     *
     * @return productive_heat_source - 生产性热源
     */
    public String getProductiveHeatSource() {
        return productiveHeatSource;
    }

    /**
     * 设置生产性热源
     *
     * @param productiveHeatSource 生产性热源
     */
    public void setProductiveHeatSource(String productiveHeatSource) {
        this.productiveHeatSource = productiveHeatSource;
    }

    /**
     * 获取防高温设施（保温隔热、通风等）
     *
     * @return temperature_protection_facilities - 防高温设施（保温隔热、通风等）
     */
    public String getTemperatureProtectionFacilities() {
        return temperatureProtectionFacilities;
    }

    /**
     * 设置防高温设施（保温隔热、通风等）
     *
     * @param temperatureProtectionFacilities 防高温设施（保温隔热、通风等）
     */
    public void setTemperatureProtectionFacilities(String temperatureProtectionFacilities) {
        this.temperatureProtectionFacilities = temperatureProtectionFacilities;
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