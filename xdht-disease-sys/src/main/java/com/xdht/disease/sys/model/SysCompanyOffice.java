package com.xdht.disease.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_company_office")
public class SysCompanyOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 父级ids
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 部门名称
     */
    @Column(name = "office_name")
    private String officeName;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

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
     * 状态（0正常 1删除）
     */
    private String status;

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
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门名称
     *
     * @return office_name - 部门名称
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * 设置部门名称
     *
     * @param officeName 部门名称
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
}