package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RecordEmployeeSummaryRequest {
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 职工ID
     */
    @ApiModelProperty(value = "职工ID")
    private Long empId;

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Long officeId;

    /**
     * 工种
     */
    @ApiModelProperty(value = "工种")
    private Long workType;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 性别：0 男 1 女
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 接噪工龄
     */
    @ApiModelProperty(value = "接噪工龄")
    private Integer contactTime;

    /**
     * 职业病危害因素
     */
    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactor;

    private String bloodPressureShrink;

    private String bloodPressureDiastole;

    private String heart;

    private String lungs;

    private String skinMucousMembrane;

    private String lymphNode;

    private String thyroidGland;

    private String ear;

    private String whiteBloodCell;

    private String neutrophileGranulocyte;

    private String redBloodCell;

    private String hemoglobin;

    private String platelet;

    private String whiteBloodCellUrine;

    private String urineProtein;

    private String urineOccultBlood;

    private String urineSugar;

    private String altuL;

    private String electrocardiogram;

    private String dbhl500L;

    private String dbhl1kL;

    private String dbhl2kL;

    private String dbhl3kL;

    private String dbhl4kL;

    private String dbhl6kL;

    private String dbhl500R;

    private String dbhl1kR;

    private String dbhl2kR;

    private String dbhl3kR;

    private String dbhl4kR;

    private String dbhl6kR;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
}