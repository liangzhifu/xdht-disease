package com.xdht.disease.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 所有父级id
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单类型（1菜单 2权限）
     */
    @Column(name = "menu_type")
    private String menuType;

    /**
     * 链接
     */
    @Column(name = "menu_href")
    private String menuHref;

    /**
     * 图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 权限标识
     */
    private String permission;


    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

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
     * 获取父级id
     *
     * @return parent_id - 父级id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     *
     * @param parentId 父级id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有父级id
     *
     * @return parent_ids - 所有父级id
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有父级id
     *
     * @param parentIds 所有父级id
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单类型（1菜单 2权限）
     *
     * @return menu_type - 菜单类型（1菜单 2权限）
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型（1菜单 2权限）
     *
     * @param menuType 菜单类型（1菜单 2权限）
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取链接
     *
     * @return menu_href - 链接
     */
    public String getMenuHref() {
        return menuHref;
    }

    /**
     * 设置链接
     *
     * @param menuHref 链接
     */
    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    /**
     * 获取图标
     *
     * @return menu_icon - 图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置图标
     *
     * @param menuIcon 图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取权限标识
     *
     * @return permission - 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     *
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取状态（0正常 1删除 2停用）
     *
     * @return status - 状态（0正常 1删除 2停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用）
     *
     * @param status 状态（0正常 1删除 2停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
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
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}