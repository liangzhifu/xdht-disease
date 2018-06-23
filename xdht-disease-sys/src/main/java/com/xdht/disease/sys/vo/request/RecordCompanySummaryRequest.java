package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordCompanySummaryRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "检查日期")
    private Date inspectionDate;

    @ApiModelProperty(value = "检查机构")
    private String inspectionAgency;

    @ApiModelProperty(value = "体检种类")
    private String physicalExaminationType;

    @ApiModelProperty(value = "应检人数")
    private Long inspectedNumber;

    @ApiModelProperty(value = "实检人数")
    private Long actualInspectdNumber;

    @ApiModelProperty(value = "未见异常")
    private Long noAbnormality;

    @ApiModelProperty(value = "复查")
    private Long reviewNumber;

    @ApiModelProperty(value = "疑似")
    private Long doubtfulNumber;

    @ApiModelProperty(value = "禁忌证")
    private Long tabooNumber;

    @ApiModelProperty(value = "其他疾患")
    private Long otherDiseasesNumber;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;


}
