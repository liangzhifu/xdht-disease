package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_work_log_data")
public class RecordWorkLogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "company_office_id")
    private Long companyOfficeId;

    /**
     * 职位ID
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 每班人数
     */
    @Column(name = "person_of_class")
    private Long personOfClass;

    /**
     * 工作时间
     */
    @Column(name = "work_hours")
    private String workHours;

    /**
     * 工作地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 工作内容
     */
    @Column(name = "work_content")
    private String workContent;

    /**
     * 危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

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
     * 获取职位ID
     *
     * @return post_id - 职位ID
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置职位ID
     *
     * @param postId 职位ID
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取每班人数
     *
     * @return person_of_class - 每班人数
     */
    public Long getPersonOfClass() {
        return personOfClass;
    }

    /**
     * 设置每班人数
     *
     * @param personOfClass 每班人数
     */
    public void setPersonOfClass(Long personOfClass) {
        this.personOfClass = personOfClass;
    }

    /**
     * 获取工作时间
     *
     * @return work_hours - 工作时间
     */
    public String getWorkHours() {
        return workHours;
    }

    /**
     * 设置工作时间
     *
     * @param workHours 工作时间
     */
    public void setWorkHours(String workHours) {
        this.workHours = workHours;
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
     * 获取工作内容
     *
     * @return work_content - 工作内容
     */
    public String getWorkContent() {
        return workContent;
    }

    /**
     * 设置工作内容
     *
     * @param workContent 工作内容
     */
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    /**
     * 获取危害因素
     *
     * @return hazard_factors - 危害因素
     */
    public String getHazardFactors() {
        return hazardFactors;
    }

    /**
     * 设置危害因素
     *
     * @param hazardFactors 危害因素
     */
    public void setHazardFactors(String hazardFactors) {
        this.hazardFactors = hazardFactors;
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