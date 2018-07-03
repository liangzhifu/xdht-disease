package com.xdht.disease.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by L on 2018/7/2.
 */
@Data
public class RecordCompanySummaryResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "调查年份")
    private Integer inspectionYear;

    @JSONField(format="yyyy-MM-dd")
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

}
