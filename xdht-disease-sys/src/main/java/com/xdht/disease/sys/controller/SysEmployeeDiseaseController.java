package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;
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
@RequestMapping(value = "/api/v1/sysEmployeeDisease")
public class SysEmployeeDiseaseController {

    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工职业病列表")
    public ResponseEntity<Result<List<SysEmployeeDisease>>> employeeDiseaseList(@RequestBody SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeDiseaseService.querySysEmpDiseaseList(sysEmployeeDiseaseRequest)), HttpStatus.OK);

    }

}
