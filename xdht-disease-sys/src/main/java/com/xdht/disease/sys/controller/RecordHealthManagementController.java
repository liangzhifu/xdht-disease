package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.service.RecordHealthManagementService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementInputRequest;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;
import com.xdht.disease.sys.vo.response.RecordHealthManagementDetailResponse;
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
@RequestMapping(value = "/api/v1/recordHealthManagement")
public class RecordHealthManagementController {

    @Autowired
    private RecordHealthManagementService recordHealthManagementService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHealthManagement>>> recordList(@RequestBody RecordHealthManagementRequest recordHealthManagementRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementService.queryList(recordHealthManagementRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordHealthManagement>>> recordPage(@RequestBody RecordHealthManagementRequest recordHealthManagementRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementService.queryListPage(recordHealthManagementRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHealthManagement>> add(@RequestBody RecordHealthManagementInputRequest recordHealthManagementInputRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementService.add(recordHealthManagementInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHealthManagement>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHealthManagement>> update(@RequestBody RecordHealthManagementInputRequest recordHealthManagementInputRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementService.update(recordHealthManagementInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取职业卫生管理情况调查表--详细内容")
    public ResponseEntity<Result<RecordHealthManagementDetailResponse>> getRecordHealthManagementDetail(@PathVariable Long id) {
        RecordHealthManagementDetailResponse recordHealthManagementDetailResponse = this.recordHealthManagementService.queryRecordHealthManagementDetail(id);
        return new ResponseEntity<>(Result.ok(recordHealthManagementDetailResponse), HttpStatus.OK);
    }


}
