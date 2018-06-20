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

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
