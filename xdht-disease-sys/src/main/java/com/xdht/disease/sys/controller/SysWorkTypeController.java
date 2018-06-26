package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysWorkType;
import com.xdht.disease.sys.service.SysWorkTypeService;
import com.xdht.disease.sys.vo.request.SysWorkTypeRequest;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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