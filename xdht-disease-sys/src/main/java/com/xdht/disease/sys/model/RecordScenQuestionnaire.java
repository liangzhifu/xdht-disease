package com.xdht.disease.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "record_scen_questionnaire")
public class RecordScenQuestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 现场调查id
     */
    @Column(name = "scene_id")
    private Long sceneId;

    /**
     * 调查表id
     */
    @Column(name = "questionnaire_id")
    private Long questionnaireId;

    /**
     * 是否填写调查表（0没有 1有）
     */
    @Column(name = "generator_record")
    private String generatorRecord;

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
     * 编辑状态
     */
    @Column(name = "edit_status")
    private String editStatus;

    public String getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(String editStatus) {
        this.editStatus = editStatus;
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
     * 获取现场调查id
     *
     * @return scene_id - 现场调查id
     */
    public Long getSceneId() {
        return sceneId;
    }

    /**
     * 设置现场调查id
     *
     * @param sceneId 现场调查id
     */
    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    /**
     * 获取调查表id
     *
     * @return questionnaire_id - 调查表id
     */
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * 设置调查表id
     *
     * @param questionnaireId 调查表id
     */
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    /**
     * 获取是否填写调查表（0没有 1有）
     *
     * @return generator_record - 是否填写调查表（0没有 1有）
     */
    public String getGeneratorRecord() {
        return generatorRecord;
    }

    /**
     * 设置是否填写调查表（0没有 1有）
     *
     * @param generatorRecord 是否填写调查表（0没有 1有）
     */
    public void setGeneratorRecord(String generatorRecord) {
        this.generatorRecord = generatorRecord;
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