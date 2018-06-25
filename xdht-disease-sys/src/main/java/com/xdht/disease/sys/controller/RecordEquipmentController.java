package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.vo.request.RecordEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentDetailResponse;
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
@RequestMapping(value = "/api/v1/recordEquipment")
public class RecordEquipmentController {

    @Autowired
    private RecordEquipmentService recordEquipmentService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEquipment>>> recordPage(@RequestBody RecordEquipmentRequest recordEquipmentRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.queryListPage(recordEquipmentRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> add(@RequestBody RecordEquipmentInputRequest recordEquipmentInputRequest) {
        recordEquipmentService.add(recordEquipmentInputRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@PathVariable Long id) {
        recordEquipmentService.delete(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> update(@RequestBody RecordEquipmentInputRequest recordEquipmentInputRequest) {
        recordEquipmentService.update(recordEquipmentInputRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordEquipmentDetailResponse>> getRecordPresentSituationDetail(@PathVariable Long id) {
        RecordEquipmentDetailResponse recordEquipmentDetailResponse = this.recordEquipmentService.queryEquipmentDetail(id);
        return new ResponseEntity<>(Result.ok(recordEquipmentDetailResponse), HttpStatus.OK);
    }

}
