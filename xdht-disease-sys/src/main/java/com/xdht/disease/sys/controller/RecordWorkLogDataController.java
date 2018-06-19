package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordWorkLogData;
import com.xdht.disease.sys.service.RecordWorkLogDataService;
import com.xdht.disease.sys.vo.request.RecordWorkLogDataRequest;
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
@RequestMapping(value = "/api/v1/recordWorkLogData")
public class RecordWorkLogDataController {

    @Autowired
    private RecordWorkLogDataService recordWorkLogDataService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordWorkLogData>>> recordList(@CurrentUser User user, @RequestBody RecordWorkLogDataRequest recordDataRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogDataService.queryList(recordDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordWorkLogData>>> recordPage(@CurrentUser User user, @RequestBody RecordWorkLogDataRequest recordDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordWorkLogDataService.queryListPage(recordDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordWorkLogData>> add(@CurrentUser User user, @RequestBody RecordWorkLogData recordData) {
        return new ResponseEntity<>(Result.ok(recordWorkLogDataService.add(recordData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordWorkLogData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordWorkLogDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordWorkLogData>> update(@CurrentUser User user, @RequestBody RecordWorkLogData recordData) {
        return new ResponseEntity<>(Result.ok(recordWorkLogDataService.update(recordData)), HttpStatus.OK);
    }



}
