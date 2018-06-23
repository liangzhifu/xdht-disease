package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesInputRequest;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordEmergencyFacilitiesDetailResponse;
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
@RequestMapping(value = "/api/v1/recordEmergencyFacilities")
public class RecordEmergencyFacilitiesController {

    @Autowired
    private RecordEmergencyFacilitiesService recordEmergencyFacilitiesService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordEmergencyFacilities>>> recordList( @RequestBody RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesService.queryList(recordEmergencyFacilitiesRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEmergencyFacilities>>> recordPage( @RequestBody RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesService.queryListPage(recordEmergencyFacilitiesRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordEmergencyFacilities>> add( @RequestBody RecordEmergencyFacilitiesInputRequest recordData) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesService.add(recordData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordEmergencyFacilities>> delete( @PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordEmergencyFacilities>> update( @RequestBody RecordEmergencyFacilitiesInputRequest recordData) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesService.update(recordData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordEmergencyFacilitiesDetailResponse>> getEmergencyFancilitiesDetail(@PathVariable Long id) {
        RecordEmergencyFacilitiesDetailResponse recordEmergencyFacilitiesDetailResponse = this.recordEmergencyFacilitiesService.queryEmergencyFacilitiesDetail(id);
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDetailResponse), HttpStatus.OK);
    }

}
