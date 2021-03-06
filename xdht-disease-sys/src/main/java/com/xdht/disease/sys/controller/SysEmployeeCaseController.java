package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;
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
@RequestMapping(value = "/api/v1/sysEmployeeCase")
public class SysEmployeeCaseController {

    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工疾病列表")
    public ResponseEntity<Result<List<SysEmployeeCase>>> employeeCaseList(@RequestBody SysEmployeeCaseRequest sysEmployeeCaseRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeCaseService.querySysEmpCaseList(sysEmployeeCaseRequest)), HttpStatus.OK);
    }

}
