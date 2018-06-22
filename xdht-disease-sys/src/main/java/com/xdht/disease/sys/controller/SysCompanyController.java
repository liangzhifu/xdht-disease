package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
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
    public  ResponseEntity<Result<List<SysCompany>>> companyList(@RequestBody SysCompanyRequest sysCompanyRequest) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querySysCompanyList(sysCompanyRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addCompany(@RequestBody SysCompany sysCompany) {
        this.sysCompanyService.addCompany(sysCompany);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteCompany(@RequestParam Long id) {
        this.sysCompanyService.deleteCompany(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改单位")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateCompany(@RequestBody SysCompany sysCompany) {
        this.sysCompanyService.updateCompany(sysCompany);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询单位详情")
    public  ResponseEntity<Result<SysCompany>> getCompanyDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.selectByPrimaryKey(id)), HttpStatus.OK);
    }

}
