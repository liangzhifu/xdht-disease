package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.service.SysEmployeeJobService;
import com.xdht.disease.sys.service.SysEmployeeService;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysCompanyResponse;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysEmployee")
public class SysEmployeeController {

    @Autowired
    private SysEmployeeService sysEmployeeService;
    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;
    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;
    @Autowired
    private SysEmployeeJobService sysEmployeeJobService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询员工列表")
    public ResponseEntity<Result<PageResult<SysEmployee>>> employeePage(@CurrentUser User user, @RequestBody SysEmployeeRequest sysEmployeeRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.querySysEmpPage(sysEmployeeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/companyEmployeeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工列表")
    public ResponseEntity<Result<List<SysEmployee>>> companyEmployeeList(@RequestBody SysEmployeeCompanyRequest sysEmployeeCompanyRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.queryCompanyEmployeeList(sysEmployeeCompanyRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加员工")
    public ResponseEntity<Result<SysEmployeeResponse>> addEmployee(@RequestBody SysEmployeeResponse sysEmployeeResponse) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.addEmployee(sysEmployeeResponse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除员工")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysEmployeeResponse>> deleteEmployee(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.deleteEmployee(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改员工")
    public ResponseEntity<Result<SysEmployeeResponse>> updateEmployee(@RequestBody SysEmployeeResponse sysEmployeeResponse) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.updateEmployee(sysEmployeeResponse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取职工信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysEmployeeResponse>> getEmployeeDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.getEmployeeDetail(id)), HttpStatus.OK);
    }
}
