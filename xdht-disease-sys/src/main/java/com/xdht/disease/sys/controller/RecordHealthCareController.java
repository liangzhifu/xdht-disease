package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordHealthCare;
import com.xdht.disease.sys.service.RecordHealthCareService;
import com.xdht.disease.sys.vo.request.RecordHealthCareRequest;
import com.xdht.disease.sys.vo.response.RecordHealthCareResponse;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
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
@RequestMapping(value = "/api/v1/recordHealthCare")
public class RecordHealthCareController {

    @Autowired
    private RecordHealthCareService recordHealthCareService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHealthCare>>> recordList(@CurrentUser User user, @RequestBody RecordHealthCareRequest recordHealthCareRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthCareService.queryList(recordHealthCareRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordHealthCare>>> recordPage(@CurrentUser User user, @RequestBody RecordHealthCareRequest recordHealthCareRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordHealthCareService.queryListPage(recordHealthCareRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<String>> add(@RequestBody RecordHealthCareRequest recordHealthCareRequest) {
        this.recordHealthCareService.add(recordHealthCareRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHealthCare>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordHealthCareService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHealthCare>> update(@RequestBody RecordHealthCareRequest recordHealthCareRequest) {
        recordHealthCareService.update(recordHealthCareRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "职业健康监护情况调查表--详细内容")
    public ResponseEntity<Result<RecordHealthCareResponse>> getRecordHealthCareDetail(@PathVariable Long id) {
        RecordHealthCareResponse recordHealthCareResponse = this.recordHealthCareService.queryRecordHealthCareDetail(id);
        return new ResponseEntity<>(Result.ok(recordHealthCareResponse), HttpStatus.OK);
    }

}
