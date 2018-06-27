package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_building_aeration_data")
public class RecordBuildingAerationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 建筑物名称
     */
    @Column(name = "building_name")
    private String buildingName;

    /**
     * 通风及空气调节方式
     */
    @Column(name = "regulation_mode")
    private String regulationMode;

    /**
     * 通风及空气调节设施
     */
    @Column(name = "adjustment_facilities")
    private String adjustmentFacilities;

    /**
     * 数量（台）
     */
    private Long number;

    /**
     * 采暖方式
     */
    @Column(name = "heating_mode")
    private String heatingMode;

    /**
     * 建筑物采暖通风及空调调查表id
     */
    @Column(name = "building_aeration_id")
    private Long buildingAerationId;

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
     * 获取建筑物名称
     *
     * @return building_name - 建筑物名称
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置建筑物名称
     *
     * @param buildingName 建筑物名称
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * 获取通风及空气调节方式
     *
     * @return regulation_mode - 通风及空气调节方式
     */
    public String getRegulationMode() {
        return regulationMode;
    }

    /**
     * 设置通风及空气调节方式
     *
     * @param regulationMode 通风及空气调节方式
     */
    public void setRegulationMode(String regulationMode) {
        this.regulationMode = regulationMode;
    }

    /**
     * 获取通风及空气调节设施
     *
     * @return adjustment_facilities - 通风及空气调节设施
     */
    public String getAdjustmentFacilities() {
        return adjustmentFacilities;
    }

    /**
     * 设置通风及空气调节设施
     *
     * @param adjustmentFacilities 通风及空气调节设施
     */
    public void setAdjustmentFacilities(String adjustmentFacilities) {
        this.adjustmentFacilities = adjustmentFacilities;
    }

    /**
     * 获取数量（台）
     *
     * @return number - 数量（台）
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置数量（台）
     *
     * @param number 数量（台）
     */
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * 获取采暖方式
     *
     * @return heating_mode - 采暖方式
     */
    public String getHeatingMode() {
        return heatingMode;
    }

    /**
     * 设置采暖方式
     *
     * @param heatingMode 采暖方式
     */
    public void setHeatingMode(String heatingMode) {
        this.heatingMode = heatingMode;
    }

    public Long getBuildingAerationId() {
        return buildingAerationId;
    }

    public void setBuildingAerationId(Long buildingAerationId) {
        this.buildingAerationId = buildingAerationId;
    }
}