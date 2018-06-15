package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
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
@RequestMapping(value = "/api/v1/recordAntiNoiseFacilities")
public class RecordAntiNoiseFacilitiesController {

    @Autowired
    private RecordAntiNoiseFacilitiesService recordAntiNoiseFacilitiesService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordAntiNoiseFacilities>>> recordList(@CurrentUser User user, @RequestBody RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.queryList(recordAntiNoiseFacilitiesRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordAntiNoiseFacilities>>> recordPage(@CurrentUser User user, @RequestBody RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.queryListPage(recordAntiNoiseFacilitiesRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> addRecordAntiNoiseFacilities(@CurrentUser User user, @RequestBody RecordAntiNoiseFacilities recordControlEffect) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.addRecordAntiNoiseFacilities(recordControlEffect)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> deleteRecordAntiNoiseFacilities(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.deleteRecordAntiNoiseFacilities(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordAntiNoiseFacilities>> updateRecordAntiNoiseFacilities(@CurrentUser User user, @RequestBody RecordAntiNoiseFacilities recordAntiNoiseFacilities) {
        return new ResponseEntity<>(Result.ok(recordAntiNoiseFacilitiesService.updateRecordAntiNoiseFacilities(recordAntiNoiseFacilities)), HttpStatus.OK);
    }


}
