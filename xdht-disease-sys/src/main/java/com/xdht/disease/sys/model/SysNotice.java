package com.xdht.disease.sys.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_notice")
public class SysNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 通知标题
     */
    @Column(name = "notice_title")
    private String noticeTitle;

    /**
     * 通知内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 通知发布时间
     */
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "notice_release_date")
    private Date noticeReleaseDate;

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
     * 获取通知标题
     *
     * @return notice_title - 通知标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 设置通知标题
     *
     * @param noticeTitle 通知标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 获取通知内容
     *
     * @return notice_content - 通知内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置通知内容
     *
     * @param noticeContent 通知内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * 获取通知发布时间
     *
     * @return notice_release_date - 通知发布时间
     */
    public Date getNoticeReleaseDate() {
        return noticeReleaseDate;
    }

    /**
     * 设置通知发布时间
     *
     * @param noticeReleaseDate 通知发布时间
     */
    public void setNoticeReleaseDate(Date noticeReleaseDate) {
        this.noticeReleaseDate = noticeReleaseDate;
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
}