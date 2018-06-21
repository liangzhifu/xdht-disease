package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class SysEmployeeCompanyRequest {

    @ApiModelProperty(value = "单位id")
    private Long companyId;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "性别")
    private String empSex;

    @ApiModelProperty(value = "籍贯")
    private String empNative;

    @ApiModelProperty(value = "婚姻")
    private String empMarriage;

    @ApiModelProperty(value = "文化程度")
    private String empEducation;

    @ApiModelProperty(value = "嗜好")
    private String empHobby;

    @ApiModelProperty(value = "参加工作时间")
    private Date empWorkDate;

    @ApiModelProperty(value = "身份证号")
    private String empIdentityNumber;


}
