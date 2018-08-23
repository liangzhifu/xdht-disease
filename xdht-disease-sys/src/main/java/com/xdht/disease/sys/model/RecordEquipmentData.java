package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_equipment_data")
public class RecordEquipmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "officd_id")
    private Long officdId;

    /**
     * 工艺过程
     */
    @Column(name = "process_name")
    private String processName;

    /**
     * 设备名称
     */
    @Column(name = "equipment_name")
    private String equipmentName;

    /**
     * 数量   （台/套）
     */
    @Column(name = "epuipment_number")
    private Long epuipmentNumber;

    /**
     * 关联id
     */
    @Column(name = "relation_id")
    private Long relationId;
    /*
    *
    * */
    @Column(name = "equipment_noise")
    private String equipmentNoise;


    public String getEquipmentNoise() {
        return equipmentNoise;
    }

    public void setEquipmentNoise(String equipmentNoise) {
        this.equipmentNoise = equipmentNoise;
    }

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
     * @return officd_id - 部门id
     */
    public Long getOfficdId() {
        return officdId;
    }

    /**
     * 设置部门id
     *
     * @param officdId 部门id
     */
    public void setOfficdId(Long officdId) {
        this.officdId = officdId;
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
     * 获取设备名称
     *
     * @return equipment_name - 设备名称
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * 设置设备名称
     *
     * @param equipmentName 设备名称
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * 获取数量   （台/套）
     *
     * @return epuipment_number - 数量   （台/套）
     */
    public Long getEpuipmentNumber() {
        return epuipmentNumber;
    }

    /**
     * 设置数量   （台/套）
     *
     * @param epuipmentNumber 数量   （台/套）
     */
    public void setEpuipmentNumber(Long epuipmentNumber) {
        this.epuipmentNumber = epuipmentNumber;
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
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
}