package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.service.RecordVddEquipmentService;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordVddEquipmentDetailResponse;
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
@RequestMapping(value = "/api/v1/recordVddEquipment")
public class RecordVddEquipmentController {

    @Autowired
    private RecordVddEquipmentService recordVddEquipmentService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordVddEquipment>>> recordList(@RequestBody RecordVddEquipmentRequest recordVddEquipmentRequest) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.queryList(recordVddEquipmentRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordVddEquipment>>> recordPage(@RequestBody RecordVddEquipmentRequest recordVddEquipmentRequest) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.queryListPage(recordVddEquipmentRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordVddEquipment>> add(@RequestBody RecordVddEquipmentInputRequest recordVddEquipmentInputRequest) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.add(recordVddEquipmentInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordVddEquipment>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordVddEquipment>> update(@RequestBody RecordVddEquipmentInputRequest recordVddEquipmentInputRequest) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.update(recordVddEquipmentInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordVddEquipmentDetailResponse>> getRecordVddEquipmentDetail(@PathVariable Long id) {
        RecordVddEquipmentDetailResponse recordVddEquipmentDetailResponse = this.recordVddEquipmentService.queryVddEquipmentDetail(id);
        return new ResponseEntity<>(Result.ok(recordVddEquipmentDetailResponse), HttpStatus.OK);
    }

}
