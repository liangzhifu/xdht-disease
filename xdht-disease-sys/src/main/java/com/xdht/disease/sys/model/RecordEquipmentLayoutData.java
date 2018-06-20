package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_equipment_layout_data")
public class RecordEquipmentLayoutData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "officd_id")
    private Long officdId;

    /**
     * 工艺过程及设备
     */
    @Column(name = "process_and_equipment")
    private String processAndEquipment;

    /**
     * 职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

    /**
     * 布局情况
     */
    @Column(name = "layout_detail")
    private String layoutDetail;

    /**
     * 备注
     */
    private String remarkds;

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
     * 获取工艺过程及设备
     *
     * @return process_and_equipment - 工艺过程及设备
     */
    public String getProcessAndEquipment() {
        return processAndEquipment;
    }

    /**
     * 设置工艺过程及设备
     *
     * @param processAndEquipment 工艺过程及设备
     */
    public void setProcessAndEquipment(String processAndEquipment) {
        this.processAndEquipment = processAndEquipment;
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
     * 获取布局情况
     *
     * @return layout_detail - 布局情况
     */
    public String getLayoutDetail() {
        return layoutDetail;
    }

    /**
     * 设置布局情况
     *
     * @param layoutDetail 布局情况
     */
    public void setLayoutDetail(String layoutDetail) {
        this.layoutDetail = layoutDetail;
    }

    /**
     * 获取备注
     *
     * @return remarkds - 备注
     */
    public String getRemarkds() {
        return remarkds;
    }

    /**
     * 设置备注
     *
     * @param remarkds 备注
     */
    public void setRemarkds(String remarkds) {
        this.remarkds = remarkds;
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