package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordTemperatureInputRequest;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordTemperatureDetailResponse;
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
@RequestMapping(value = "/api/v1/recordTemperatureProtectionFacilities")
public class RecordTemperatureProtectionFacilitiesController {

    @Autowired
    private RecordTemperatureProtectionFacilitiesService recordService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordTemperatureProtectionFacilities>>> recordList( @RequestBody RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordTemperatureProtectionFacilities>>> recordPage( @RequestBody RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryListPage(recordRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordTemperatureProtectionFacilities>> add( @RequestBody RecordTemperatureInputRequest recordTemperatureInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.add(recordTemperatureInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordTemperatureProtectionFacilities>> delete( @PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordTemperatureProtectionFacilities>> update( @RequestBody RecordTemperatureInputRequest recordTemperatureInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.update(recordTemperatureInputRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordTemperatureDetailResponse>> getRecordTemperatureDetail(@PathVariable Long id) {
        RecordTemperatureDetailResponse recordTemperatureDetailResponse = this.recordService.queryTemperatureDetail(id);
        return new ResponseEntity<>(Result.ok(recordTemperatureDetailResponse), HttpStatus.OK);
    }



}
