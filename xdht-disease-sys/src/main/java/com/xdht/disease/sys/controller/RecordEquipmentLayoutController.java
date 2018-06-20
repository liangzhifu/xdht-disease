package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.service.RecordEquipmentLayoutService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentLayoutDetailResponse;
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
@RequestMapping(value = "/api/v1/recordEquipmentLayout")
public class RecordEquipmentLayoutController {

    @Autowired
    private RecordEquipmentLayoutService recordEquipmentLayoutService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordEquipmentLayout>>> recordList( @RequestBody RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutService.queryList(recordEquipmentLayoutRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEquipmentLayout>>> recordPage( @RequestBody RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutService.queryListPage(recordEquipmentLayoutRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordEquipmentLayout>> add( @RequestBody RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutService.add(recordEquipmentLayoutInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordEquipmentLayout>> delete( @PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordEquipmentLayout>> update( @RequestBody RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutService.update(recordEquipmentLayoutInputRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordEquipmentLayoutDetailResponse>> getRecordPresentSituationDetail(@PathVariable Long id) {
        RecordEquipmentLayoutDetailResponse recordEquipmentLayoutDetailResponse = this.recordEquipmentLayoutService.queryEquipmentLayoutDetail(id);
        return new ResponseEntity<>(Result.ok(recordEquipmentLayoutDetailResponse), HttpStatus.OK);
    }


}
