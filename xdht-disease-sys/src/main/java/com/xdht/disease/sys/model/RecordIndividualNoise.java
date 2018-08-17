package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "record_individual_noise")
public class RecordIndividualNoise {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 部门ID
     */
    @Column(name = "office_id")
    private Long officeId;

    /**
     * 工种ID
     */
    @Column(name = "work_type_id")
    private Long workTypeId;

    /**
     * 检查时间
     */
    @JSONField(format="yyyy-MM-dd")
    @Column(name = "inspect_date")
    private Date inspectDate;

    /**
     * 检查年份
     */
    @Column(name = "inspect_year")
    private Integer inspectYear;

    /**
     * 每班工作时间（h）
     */
    @Column(name = "Working_hours_per_shift")
    private BigDecimal workingHoursPerShift;

    /**
     * 工作日/周（d）
     */
    @Column(name = "workday_week")
    private BigDecimal workdayWeek;

    /**
     * 8h等效声级dB（A）
     */
    @Column(name = "sound_level")
    private BigDecimal soundLevel;

    /**
     * 判定结果
     */
    @Column(name = "decision_result")
    private String decisionResult;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "carete_date")
    private Date careteDate;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门ID
     *
     * @return office_id - 部门ID
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置部门ID
     *
     * @param officeId 部门ID
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取工种ID
     *
     * @return work_type_id - 工种ID
     */
    public Long getWorkTypeId() {
        return workTypeId;
    }

    /**
     * 设置工种ID
     *
     * @param workTypeId 工种ID
     */
    public void setWorkTypeId(Long workTypeId) {
        this.workTypeId = workTypeId;
    }

    /**
     * 获取检查时间
     *
     * @return inspect_date - 检查时间
     */
    public Date getInspectDate() {
        return inspectDate;
    }

    /**
     * 设置检查时间
     *
     * @param inspectDate 检查时间
     */
    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    /**
     * 获取检查年份
     *
     * @return inspect_year - 检查年份
     */
    public Integer getInspectYear() {
        return inspectYear;
    }

    /**
     * 设置检查年份
     *
     * @param inspectYear 检查年份
     */
    public void setInspectYear(Integer inspectYear) {
        this.inspectYear = inspectYear;
    }

    /**
     * 获取每班工作时间（h）
     *
     * @return Working_hours_per_shift - 每班工作时间（h）
     */
    public BigDecimal getWorkingHoursPerShift() {
        return workingHoursPerShift;
    }

    /**
     * 设置每班工作时间（h）
     *
     * @param workingHoursPerShift 每班工作时间（h）
     */
    public void setWorkingHoursPerShift(BigDecimal workingHoursPerShift) {
        this.workingHoursPerShift = workingHoursPerShift;
    }

    /**
     * 获取工作日/周（d）
     *
     * @return workday_week - 工作日/周（d）
     */
    public BigDecimal getWorkdayWeek() {
        return workdayWeek;
    }

    /**
     * 设置工作日/周（d）
     *
     * @param workdayWeek 工作日/周（d）
     */
    public void setWorkdayWeek(BigDecimal workdayWeek) {
        this.workdayWeek = workdayWeek;
    }

    /**
     * 获取8h等效声级dB（A）
     *
     * @return sound_level - 8h等效声级dB（A）
     */
    public BigDecimal getSoundLevel() {
        return soundLevel;
    }

    /**
     * 设置8h等效声级dB（A）
     *
     * @param soundLevel 8h等效声级dB（A）
     */
    public void setSoundLevel(BigDecimal soundLevel) {
        this.soundLevel = soundLevel;
    }

    /**
     * 获取判定结果
     *
     * @return decision_result - 判定结果
     */
    public String getDecisionResult() {
        return decisionResult;
    }

    /**
     * 设置判定结果
     *
     * @param decisionResult 判定结果
     */
    public void setDecisionResult(String decisionResult) {
        this.decisionResult = decisionResult;
    }

    /**
     * 获取状态（0正常 1删除）
     *
     * @return status - 状态（0正常 1删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除）
     *
     * @param status 状态（0正常 1删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return carete_date - 创建时间
     */
    public Date getCareteDate() {
        return careteDate;
    }

    /**
     * 设置创建时间
     *
     * @param careteDate 创建时间
     */
    public void setCareteDate(Date careteDate) {
        this.careteDate = careteDate;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}