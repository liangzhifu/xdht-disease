package com.xdht.disease.sys.vo.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordWorkplaceNoiseRequest {

    @ApiModelProperty(value = "单位Id")
    private Long companyId;

    @ApiModelProperty(value = "部门名称")
    private String companyOfficeName;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(value = "开始位置")
    private Integer start;

}
