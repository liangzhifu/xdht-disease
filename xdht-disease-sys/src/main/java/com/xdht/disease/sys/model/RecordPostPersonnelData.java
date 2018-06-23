package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_post_personnel_data")
public class RecordPostPersonnelData {
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
     * 每班
     */
    @Column(name = "per_shift")
    private Long perShift;

    /**
     * 总定员
     */
    @Column(name = "total_number")
    private Long totalNumber;

    /**
     * 天/周
     */
    @Column(name = "day_of_week")
    private Long dayOfWeek;

    /**
     * 班/天
     */
    @Column(name = "class_of_date")
    private Long classOfDate;

    /**
     * 小时/班
     */
    @Column(name = "hour_of_class")
    private Long hourOfClass;

    /**
     * 关联id
     */
    @Column(name = "post_personnel_id")
    private Long postPersonnelId;

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
     * 获取每班
     *
     * @return per_shift - 每班
     */
    public Long getPerShift() {
        return perShift;
    }

    /**
     * 设置每班
     *
     * @param perShift 每班
     */
    public void setPerShift(Long perShift) {
        this.perShift = perShift;
    }

    /**
     * 获取总定员
     *
     * @return total_number - 总定员
     */
    public Long getTotalNumber() {
        return totalNumber;
    }

    /**
     * 设置总定员
     *
     * @param totalNumber 总定员
     */
    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 获取天/周
     *
     * @return day_of_week - 天/周
     */
    public Long getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * 设置天/周
     *
     * @param dayOfWeek 天/周
     */
    public void setDayOfWeek(Long dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * 获取班/天
     *
     * @return class_of_date - 班/天
     */
    public Long getClassOfDate() {
        return classOfDate;
    }

    /**
     * 设置班/天
     *
     * @param classOfDate 班/天
     */
    public void setClassOfDate(Long classOfDate) {
        this.classOfDate = classOfDate;
    }

    /**
     * 获取小时/班
     *
     * @return hour_of_class - 小时/班
     */
    public Long getHourOfClass() {
        return hourOfClass;
    }

    /**
     * 设置小时/班
     *
     * @param hourOfClass 小时/班
     */
    public void setHourOfClass(Long hourOfClass) {
        this.hourOfClass = hourOfClass;
    }

    public Long getPostPersonnelId() {
        return postPersonnelId;
    }

    public void setPostPersonnelId(Long postPersonnelId) {
        this.postPersonnelId = postPersonnelId;
    }
}