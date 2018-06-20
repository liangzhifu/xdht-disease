package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_emergency_facilities_data")
public class RecordEmergencyFacilitiesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 工作地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 应急设施
     */
    @Column(name = "emergency_facilities")
    private String emergencyFacilities;

    /**
     * 数量(台/套)
     */
    private Long number;

    /**
     * 运行维护情况
     */
    @Column(name = "operation_and_maintenance")
    private String operationAndMaintenance;

    /**
     * 技术参数（服务半径、报警浓度、换气次数等）
     */
    @Column(name = "technical_parameter")
    private String technicalParameter;

    /**
     * 可致急性损伤的职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

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
     * 获取应急设施
     *
     * @return emergency_facilities - 应急设施
     */
    public String getEmergencyFacilities() {
        return emergencyFacilities;
    }

    /**
     * 设置应急设施
     *
     * @param emergencyFacilities 应急设施
     */
    public void setEmergencyFacilities(String emergencyFacilities) {
        this.emergencyFacilities = emergencyFacilities;
    }

    /**
     * 获取数量(台/套)
     *
     * @return number - 数量(台/套)
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置数量(台/套)
     *
     * @param number 数量(台/套)
     */
    public void setNumber(Long number) {
        this.number = number;
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
     * 获取技术参数（服务半径、报警浓度、换气次数等）
     *
     * @return technical_parameter - 技术参数（服务半径、报警浓度、换气次数等）
     */
    public String getTechnicalParameter() {
        return technicalParameter;
    }

    /**
     * 设置技术参数（服务半径、报警浓度、换气次数等）
     *
     * @param technicalParameter 技术参数（服务半径、报警浓度、换气次数等）
     */
    public void setTechnicalParameter(String technicalParameter) {
        this.technicalParameter = technicalParameter;
    }

    /**
     * 获取可致急性损伤的职业病危害因素
     *
     * @return hazard_factors - 可致急性损伤的职业病危害因素
     */
    public String getHazardFactors() {
        return hazardFactors;
    }

    /**
     * 设置可致急性损伤的职业病危害因素
     *
     * @param hazardFactors 可致急性损伤的职业病危害因素
     */
    public void setHazardFactors(String hazardFactors) {
        this.hazardFactors = hazardFactors;
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