package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_other_protective_facilities_data")
public class RecordOtherProtectiveFacilitiesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "office_id")
    private Long officeId;

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
     * 职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

    /**
     * 防护设施名称
     */
    @Column(name = "protective_facilities")
    private String protectiveFacilities;

    /**
     * 运行维护情况
     */
    @Column(name = "operation_and_maintenance")
    private String operationAndMaintenance;

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
     * 获取防护设施名称
     *
     * @return protective_facilities - 防护设施名称
     */
    public String getProtectiveFacilities() {
        return protectiveFacilities;
    }

    /**
     * 设置防护设施名称
     *
     * @param protectiveFacilities 防护设施名称
     */
    public void setProtectiveFacilities(String protectiveFacilities) {
        this.protectiveFacilities = protectiveFacilities;
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