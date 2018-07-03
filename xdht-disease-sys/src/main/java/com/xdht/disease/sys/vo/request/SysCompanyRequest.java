package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysCompanyRequest {

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "联系人姓名")
    private String contactUsername;

    @ApiModelProperty(value = "所属管辖")
    private String belongToJurisdiction;

    @ApiModelProperty(value = "法定代表人")
    private String legalRepresentative;

    @ApiModelProperty(value = "单位性质")
    private String companyNature;

    @ApiModelProperty(value = "成立日期")
    private Date establishDate;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
