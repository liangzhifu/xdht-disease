package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysWorkType;
import com.xdht.disease.sys.service.SysWorkTypeService;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.request.SysWorkTypeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysWorkType")
public class SysWorkTypeController {
    @Autowired
    private SysWorkTypeService sysWorkTypeService;

    @RequestMapping(value = "/sysWorkTypeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询工种列表")
    public ResponseEntity<Result<List<SysWorkType>>> sysWorkTypeList(@RequestBody SysWorkTypeRequest sysWorkTypeRequest) {
        return new ResponseEntity<>(Result.ok(sysWorkTypeService.querySysWorkTypeList(sysWorkTypeRequest)), HttpStatus.OK);
    }


}