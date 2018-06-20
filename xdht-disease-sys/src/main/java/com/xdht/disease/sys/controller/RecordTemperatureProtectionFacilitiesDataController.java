package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesDataRequest;
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
@RequestMapping(value = "/api/v1/recordTemperatureProtectionFacilitiesData")
public class RecordTemperatureProtectionFacilitiesDataController {

    @Autowired
    private RecordTemperatureProtectionFacilitiesDataService recordDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordTemperatureProtectionFacilitiesData>>> recordList(@RequestBody RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryList(recordDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordTemperatureProtectionFacilitiesData>>> recordPage(@RequestBody RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryListPage(recordDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordTemperatureProtectionFacilitiesData>> add(@RequestBody RecordTemperatureProtectionFacilitiesData recordData) {
        return new ResponseEntity<>(Result.ok(recordDataService.add(recordData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordTemperatureProtectionFacilitiesData>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordTemperatureProtectionFacilitiesData>> update(@RequestBody RecordTemperatureProtectionFacilitiesData recordData) {
        return new ResponseEntity<>(Result.ok(recordDataService.update(recordData)), HttpStatus.OK);
    }



}
