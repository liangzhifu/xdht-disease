package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.SysCompanyOfficeRequest;
import com.xdht.disease.sys.vo.response.SysCompanyOfficeResponse;
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
@RequestMapping(value = "/api/v1/sysCompanyOffice")
public class SysCompanyOfficeController {

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @RequestMapping(value = "/companyOfficePage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询单位部门列表")
    public ResponseEntity<Result<PageResult<SysCompanyOffice>>> companyOfficePage(@RequestBody SysCompanyOfficeRequest sysCompanyOfficeRequest) {
        return new ResponseEntity<>(Result.ok(sysCompanyOfficeService.querySysCompanyOfficePage(sysCompanyOfficeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/companyOfficeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询单位部门列表")
    public ResponseEntity<Result<List<SysCompanyOffice>>> companyOfficeList(@RequestBody SysCompanyOffice sysCompanyOffice) {
        return new ResponseEntity<>(Result.ok(sysCompanyOfficeService.querySysCompanyOfficeList(sysCompanyOffice)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加单位部门")
    public ResponseEntity<Result<SysCompanyOfficeResponse>> addCompanyOffice(@CurrentUser User user, @RequestBody SysCompanyOffice sysCompanyOffice) {
        return new ResponseEntity<>(Result.ok(sysCompanyOfficeService.addCompanyOffice(sysCompanyOffice)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除单位部门")
    public ResponseEntity<Result<SysCompanyOfficeResponse>> deleteCompanyOffice(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysCompanyOfficeService.deleteCompanyOffice(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改单位部门")
    public ResponseEntity<Result<SysCompanyOfficeResponse>> updateCompanyOffice(@CurrentUser User user, @RequestBody SysCompanyOffice sysCompanyOffice) {
        return new ResponseEntity<>(Result.ok(sysCompanyOfficeService.updateCompanyOffice(sysCompanyOffice)), HttpStatus.OK);
    }

}
