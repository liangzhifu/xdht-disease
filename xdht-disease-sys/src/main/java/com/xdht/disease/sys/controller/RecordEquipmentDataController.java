package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.service.RecordEquipmentDataService;
import com.xdht.disease.sys.vo.request.RecordEquipmentDataRequest;
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
@RequestMapping(value = "/api/v1/recordEquipmentData")
public class RecordEquipmentDataController {

    @Autowired
    private RecordEquipmentDataService recordEquipmentDataService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordEquipmentData>>> recordList(@CurrentUser User user, @RequestBody RecordEquipmentDataRequest recordEquipmentDataRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentDataService.queryList(recordEquipmentDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEquipmentData>>> recordPage(@CurrentUser User user, @RequestBody RecordEquipmentDataRequest recordEquipmentDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordEquipmentDataService.queryListPage(recordEquipmentDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordEquipmentData>> add(@CurrentUser User user, @RequestBody RecordEquipmentData recordEquipmentData) {
        return new ResponseEntity<>(Result.ok(recordEquipmentDataService.add(recordEquipmentData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordEquipmentData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordEquipmentDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordEquipmentData>> update(@CurrentUser User user, @RequestBody RecordEquipmentData recordEquipmentData) {
        return new ResponseEntity<>(Result.ok(recordEquipmentDataService.update(recordEquipmentData)), HttpStatus.OK);
    }



}
