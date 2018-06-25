package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.service.RecordControlEffectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectInputRequest;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;
import com.xdht.disease.sys.vo.response.RecordControlEffectDetailResponse;
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
@RequestMapping(value = "/api/v1/recordControlEffect")
public class RecordControlEffectController {

    @Autowired
    private RecordControlEffectService recordControlEffectService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordControlEffect>>> pageList(@RequestBody RecordControlEffectRequest recordControlEffectRequest) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.queryListPage(recordControlEffectRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<String>> addRecordControlEffect(@RequestBody RecordControlEffectInputRequest recordData) {
        recordControlEffectService.addRecordControlEffect(recordData);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<String>> deleteRecordControlEffect(@PathVariable Long id) {
        recordControlEffectService.deleteRecordControlEffect(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<String>> updateRecordControlEffect(@RequestBody RecordControlEffectInputRequest recordData) {
        recordControlEffectService.updateRecordControlEffect(recordData);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取建设项目概况调查表(控制效果评价)--详细内容")
    public ResponseEntity<Result<RecordControlEffectDetailResponse>> getRecordControlEffectDetail(@PathVariable Long id) {
        RecordControlEffectDetailResponse recordPreEvaluationDetailResponse = this.recordControlEffectService.queryRecordControlEffectDetail(id);
        return new ResponseEntity<>(Result.ok(recordPreEvaluationDetailResponse), HttpStatus.OK);
    }



}
