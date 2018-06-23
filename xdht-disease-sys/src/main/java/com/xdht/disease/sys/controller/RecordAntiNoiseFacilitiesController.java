package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseInputRequest;
import com.xdht.disease.sys.vo.response.RecordAntiNoiseDetailResponse;
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
@RequestMapping(value = "/api/v1/recordAntiNoiseFacilities")
public class RecordAntiNoiseFacilitiesController {

    @Autowired
    private RecordAntiNoiseFacilitiesService recordAntiNoiseFacilitiesService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordAntiNoiseFacilities>>> recordList( @RequestBody RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.queryList(recordAntiNoiseFacilitiesRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordAntiNoiseFacilities>>> recordPage( @RequestBody RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.queryListPage(recordAntiNoiseFacilitiesRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> addRecordAntiNoiseFacilities( @RequestBody RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.addRecordAntiNoiseFacilities(recordAntiNoiseInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> deleteRecordAntiNoiseFacilities( @PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.deleteRecordAntiNoiseFacilities(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> updateRecordAntiNoiseFacilities( @RequestBody RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.updateRecordAntiNoiseFacilities(recordAntiNoiseInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{sceneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordAntiNoiseDetailResponse>> getRecordAntiNoiseDetail(@PathVariable Long sceneId) {
        RecordAntiNoiseDetailResponse recordAntiNoiseDetailResponse = this.recordAntiNoiseFacilitiesService.queryAntiNoiseDetail(sceneId);
        return new ResponseEntity<>(Result.ok(recordAntiNoiseDetailResponse), HttpStatus.OK);
    }

}
