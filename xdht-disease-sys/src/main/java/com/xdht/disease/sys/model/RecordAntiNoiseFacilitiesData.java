package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_anti_noise_facilities_data")
public class RecordAntiNoiseFacilitiesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门id
     */
    @Column(name = "company_office_id")
    private Long companyOfficeId;

    /**
     * 职位id
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 作业地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 噪声源
     */
    @Column(name = "noise_source")
    private String noiseSource;

    /**
     * 噪声防护设施（减振、隔声、吸声等）
     */
    @Column(name = "noise_protection_facilities")
    private String noiseProtectionFacilities;

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
     * 获取职位id
     *
     * @return post_id - 职位id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置职位id
     *
     * @param postId 职位id
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取作业地点
     *
     * @return work_place - 作业地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置作业地点
     *
     * @param workPlace 作业地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * 获取噪声源
     *
     * @return noise_source - 噪声源
     */
    public String getNoiseSource() {
        return noiseSource;
    }

    /**
     * 设置噪声源
     *
     * @param noiseSource 噪声源
     */
    public void setNoiseSource(String noiseSource) {
        this.noiseSource = noiseSource;
    }

    /**
     * 获取噪声防护设施（减振、隔声、吸声等）
     *
     * @return noise_protection_facilities - 噪声防护设施（减振、隔声、吸声等）
     */
    public String getNoiseProtectionFacilities() {
        return noiseProtectionFacilities;
    }

    /**
     * 设置噪声防护设施（减振、隔声、吸声等）
     *
     * @param noiseProtectionFacilities 噪声防护设施（减振、隔声、吸声等）
     */
    public void setNoiseProtectionFacilities(String noiseProtectionFacilities) {
        this.noiseProtectionFacilities = noiseProtectionFacilities;
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