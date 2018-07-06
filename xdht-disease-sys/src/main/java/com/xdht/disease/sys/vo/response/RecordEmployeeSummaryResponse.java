package com.xdht.disease.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class RecordEmployeeSummaryResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "职工ID")
    private Long empId;

    @ApiModelProperty(value = "职工年龄")
    private  Integer age;

    @ApiModelProperty(value = "职工姓名")
    private String empName;

    @ApiModelProperty(value = "职工性别")
    private String empSex;

    @ApiModelProperty(value = "部门ID")
    private Long officeId;

    @ApiModelProperty(value = "部门名称")
    private String officeName;

    @ApiModelProperty(value = "单位ID")
    private Long companyId;

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "工种id")
    private Long workType;

    @ApiModelProperty(value = "工种")
    private String workTypeName;

    @JSONField(format="yyyy-MM-dd")
    @ApiModelProperty(value = "检查日期")
    private Date inspectDate;

    @ApiModelProperty(value = "0：初检  1：复检")
    private String inspect;

    @ApiModelProperty(value = "接噪工龄")
    private Integer contactTime;

    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactor;

    @ApiModelProperty(value = "血压收缩压")
    private Long bloodPressureShrink;

    @ApiModelProperty(value = "血压舒张压")
    private Long bloodPressureDiastole;

    @ApiModelProperty(value = "心脏")
    private String heart;

    @ApiModelProperty(value = "肺")
    private String lungs;

    @ApiModelProperty(value = "皮肤粘膜")
    private String skinMucousMembrane;

    @ApiModelProperty(value = "浅表淋巴结")
    private String lymphNode;

    @ApiModelProperty(value = "甲状腺")
    private String thyroidGland;

    @ApiModelProperty(value = "耳朵")
    private String ear;

    @ApiModelProperty(value = "白细胞×109/L")
    private Long whiteBloodCell;

    @ApiModelProperty(value = "中性粒细胞计数×109/L")
    private Long neutrophileGranulocyte;

    @ApiModelProperty(value = "红细胞计数×1012/L")
    private Long redBloodCell;

    @ApiModelProperty(value = "血色素g/L")
    private Long hemoglobin;

    @ApiModelProperty(value = "血小板×109/L")
    private Long platelet;

    @ApiModelProperty(value = "白细胞（尿）")
    private String whiteBloodCellUrine;

    @ApiModelProperty(value = "尿蛋白")
    private String urineProtein;

    @ApiModelProperty(value = "尿潜血")
    private String urineOccultBlood;

    @ApiModelProperty(value = "尿糖")
    private String urineSugar;

    @ApiModelProperty(value = "ALTU/L")
    private String altuL;

    @ApiModelProperty(value = "心电图")
    private String electrocardiogram;

    @ApiModelProperty(value = "dbhl_500_l")
    private Long dbhl500L;

    @ApiModelProperty(value = "dbhl_1k_l")
    private Long dbhl1kL;

    @ApiModelProperty(value = "dbhl_2k_l")
    private Long dbhl2kL;

    @ApiModelProperty(value = "dbhl_3k_l")
    private Long dbhl3kL;

    @ApiModelProperty(value = "dbhl_4k_l")
    private Long dbhl4kL;

    @ApiModelProperty(value = "dbhl_6k_l")
    private Long dbhl6kL;

    @ApiModelProperty(value = "dbhl_500_r")
    private Long dbhl500R;

    @ApiModelProperty(value = "dbhl_1k_r")
    private Long dbhl1kR;

    @ApiModelProperty(value = "dbhl_2k_r")
    private Long dbhl2kR;

    @ApiModelProperty(value = "dbhl_3k_r")
    private Long dbhl3kR;

    @ApiModelProperty(value = "dbhl_4k_r")
    private Long dbhl4kR;

    @ApiModelProperty(value = "dbhl_6k_r")
    private Long dbhl6kR;

}