package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class SysEmployeeCompanyRequest {

    @ApiModelProperty(value = "单位id")
    private Long companyId;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

}
