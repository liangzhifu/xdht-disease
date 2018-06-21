package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_vdd_equipment_data")
public class RecordVddEquipmentData {
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
     * 通风排毒除尘设施名称
     */
    @Column(name = "vdd_equipment_name")
    private String vddEquipmentName;

    /**
     * 毒物或粉尘名称
     */
    @Column(name = "poison_or_dust_name")
    private String poisonOrDustName;

    /**
     * 数量
     */
    private Long number;

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
     * 获取通风排毒除尘设施名称
     *
     * @return vdd_equipment_name - 通风排毒除尘设施名称
     */
    public String getVddEquipmentName() {
        return vddEquipmentName;
    }

    /**
     * 设置通风排毒除尘设施名称
     *
     * @param vddEquipmentName 通风排毒除尘设施名称
     */
    public void setVddEquipmentName(String vddEquipmentName) {
        this.vddEquipmentName = vddEquipmentName;
    }

    /**
     * 获取毒物或粉尘名称
     *
     * @return poison_or_dust_name - 毒物或粉尘名称
     */
    public String getPoisonOrDustName() {
        return poisonOrDustName;
    }

    /**
     * 设置毒物或粉尘名称
     *
     * @param poisonOrDustName 毒物或粉尘名称
     */
    public void setPoisonOrDustName(String poisonOrDustName) {
        this.poisonOrDustName = poisonOrDustName;
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