package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.SysCompanyOffice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysEmployeeRequest {

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "身份证号")
    private String empIdentityNumber;

    @ApiModelProperty(value = "公司")
    private String companyName;

    @ApiModelProperty(value = "部门")
    private String officeName;

    @ApiModelProperty(value = "工种")
    private String workTypeName;

    @ApiModelProperty(value = "分页数")
    private Integer pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(value = "每页开始位置")
    private Integer start;
}
