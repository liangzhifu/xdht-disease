package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysEmployeeRequest {

    @ApiModelProperty(value = "员工id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

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

    @ApiModelProperty(value = "状态（0在职 1离职）")
    private String status;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNum;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
