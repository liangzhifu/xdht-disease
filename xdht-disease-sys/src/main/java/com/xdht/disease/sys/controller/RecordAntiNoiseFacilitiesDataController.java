package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesDataRequest;
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
@RequestMapping(value = "/api/v1/recordAntiNoiseFacilitiesData")
public class RecordAntiNoiseFacilitiesDataController {

    @Autowired
    private RecordAntiNoiseFacilitiesDataService recordAntiNoiseFacilitiesDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordAntiNoiseFacilitiesData>>> recordList( @RequestBody RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesDataService.queryList(recordAntiNoiseFacilitiesDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordAntiNoiseFacilitiesData>>> recordPage( @RequestBody RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesDataService.queryListPage(recordAntiNoiseFacilitiesDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilitiesData>> add( @RequestBody RecordAntiNoiseFacilitiesData recordControlEffectData) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesDataService.add(recordControlEffectData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilitiesData>> delete( @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordAntiNoiseFacilitiesData>> update( @RequestBody RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesDataService.update(recordAntiNoiseFacilitiesData)), HttpStatus.OK);
    }



}
