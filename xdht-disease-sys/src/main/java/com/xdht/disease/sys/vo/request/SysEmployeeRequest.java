package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysEmployeeRequest {

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "身份证号")
    private String empIdentityNumber;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "籍贯")
    private String empNative;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
