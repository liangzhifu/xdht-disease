package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
import com.xdht.disease.sys.vo.response.SysCompanyResponse;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
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
@RequestMapping(value = "/api/v1/sysCompany")
public class SysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询单位列表")
    public ResponseEntity<Result<PageResult<SysCompany>>> companyPage(@RequestBody SysCompanyRequest sysCompanyRequest) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querySysCompanyListPage(sysCompanyRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询单位列表")
    public  ResponseEntity<Result<List<SysCompany>>> companyList(@RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querySysCompanyList(sysCompany)), HttpStatus.OK);
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询单位列表")
    public  ResponseEntity<Result<List<SysCompany>>> listAll() {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querylistAll()), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysCompanyResponse>> addCompany(@RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.addCompany(sysCompany)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysCompanyResponse>> deleteCompany(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.deleteCompany(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysCompanyResponse>> updateCompany(@RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.updateCompany(sysCompany)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取企业信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysCompanyResponse>> getCompanyDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.getCompanyDetail(id)), HttpStatus.OK);
    }


}
