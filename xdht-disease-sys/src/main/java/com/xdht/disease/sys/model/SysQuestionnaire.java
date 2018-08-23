package com.xdht.disease.sys.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/*@Data*/
@Table(name = "sys_questionnaire")
public class SysQuestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    * 调查编号
    */
    @Column(name = "questionnaire_num")
    private Long questionnaireNum;
    /**
     * 调查表名称
     */
    @Column(name = "questionnaire_name")
    private String questionnaireName;

    /**
     * 调查表别名
     */
    @Column(name = "questionnaire_alias")
    private String questionnaireAlias;

    /**
     * 状态（0正常 1删除）
     */
    @Column(name = "status")
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

    public Long getQuestionnaireNum() {
        return questionnaireNum;
    }

    public void setQuestionnaireNum(Long questionnaireNum) {
        this.questionnaireNum = questionnaireNum;
    }

    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireAlias() {
        return questionnaireAlias;
    }

    public void setQuestionnaireAlias(String questionnaireAlias) {
        this.questionnaireAlias = questionnaireAlias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}