package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordOtherProtectiveDetailResponse;
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
@RequestMapping(value = "/api/v1/recordOtherProtectiveFacilities")
public class RecordOtherProtectiveFacilitiesController {

    @Autowired
    private RecordOtherProtectiveFacilitiesService recordService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordOtherProtectiveFacilities>>> recordList( @RequestBody RecordOtherProtectiveFacilitiesRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordOtherProtectiveFacilities>>> recordPage( @RequestBody RecordOtherProtectiveFacilitiesRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryListPage(recordRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordOtherProtectiveFacilities>> add( @RequestBody RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.add(recordOtherProtectiveInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordOtherProtectiveFacilities>> delete( @PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordOtherProtectiveFacilities>> update( @RequestBody RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.update(recordOtherProtectiveInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordOtherProtectiveDetailResponse>> getRecordOtherProtectiveDetail(@PathVariable Long id) {
        RecordOtherProtectiveDetailResponse recordOtherProtectiveDetailResponse = this.recordService.queryOtherProtetiveDetail(id);
        return new ResponseEntity<>(Result.ok(recordOtherProtectiveDetailResponse), HttpStatus.OK);
    }


}
