package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysEmployeeResponse {

    @ApiModelProperty(value = "员工信息")
    private SysEmployee sysEmployee;

    @ApiModelProperty(value = "部门信息")
    private SysCompanyOffice sysCompanyOffice;

    @ApiModelProperty(value = "职业病危害接触史")
    private List<SysEmployeeJob> sysEmployeeJobList;

    @ApiModelProperty(value = "既往病史")
    private List<SysEmployeeCase> sysEmployeeCaseList;

    @ApiModelProperty(value = "职业病诊断")
    private List<SysEmployeeDisease> sysEmployeeDiseaseList;

}
