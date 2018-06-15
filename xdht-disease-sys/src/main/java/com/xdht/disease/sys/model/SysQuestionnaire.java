package com.xdht.disease.sys.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "sys_questionnaire")
public class SysQuestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}