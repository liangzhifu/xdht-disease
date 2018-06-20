package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentDataService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentDataRequest;
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
@RequestMapping(value = "/api/v1/recordIndividualProtectiveEquipmentData")
public class RecordIndividualProtectiveEquipmentDataController {

    @Autowired
    private RecordIndividualProtectiveEquipmentDataService recordDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordIndividualProtectiveEquipmentData>>> recordList( @RequestBody RecordIndividualProtectiveEquipmentDataRequest recordDataRequest) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryList(recordDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordIndividualProtectiveEquipmentData>>> recordPage( @RequestBody RecordIndividualProtectiveEquipmentDataRequest recordDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryListPage(recordDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipmentData>> add( @RequestBody RecordIndividualProtectiveEquipmentData recordData) {
        return new ResponseEntity<>(Result.ok(recordDataService.add(recordData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipmentData>> delete( @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipmentData>> update( @RequestBody RecordIndividualProtectiveEquipmentData recordData) {
        return new ResponseEntity<>(Result.ok(recordDataService.update(recordData)), HttpStatus.OK);
    }



}
