package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
import com.xdht.disease.sys.vo.response.RecordFundsDetailResponse;
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
@RequestMapping(value = "/api/v1/recordFunds")
public class RecordFundsController {

    @Autowired
    private RecordFundsService recordFundsService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordFunds>>> recordList(@CurrentUser User user, @RequestBody RecordFundsRequest recordFundsRequest) {
        return new ResponseEntity<>(Result.ok(recordFundsService.queryList(recordFundsRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordFunds>>> recordPage(@CurrentUser User user, @RequestBody RecordFundsRequest recordFundsRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordFundsService.queryListPage(recordFundsRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordFunds>> add(@RequestBody RecordFundsRequest recordFundsRequest) {
        this.recordFundsService.add(recordFundsRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordFunds>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordFundsService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordFunds>> update(@RequestBody RecordFundsRequest recordFundsRequest) {
        this.recordFundsService.update(recordFundsRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取建设项目概况调查表(预评价)--详细内容")
    public ResponseEntity<Result<RecordFundsDetailResponse>> getRecordFundsDetail(@PathVariable Long id) {
        RecordFundsDetailResponse recordFundsDetailResponse = this.recordFundsService.queryRecordFundsDetail(id);
        return new ResponseEntity<>(Result.ok(recordFundsDetailResponse), HttpStatus.OK);
    }


}
