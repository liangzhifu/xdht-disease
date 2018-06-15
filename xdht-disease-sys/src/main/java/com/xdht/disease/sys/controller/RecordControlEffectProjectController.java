package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordControlEffectProject;
import com.xdht.disease.sys.service.RecordControlEffectProjectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectProjectRequest;
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
@RequestMapping(value = "/api/v1/recordControlEffectProject")
public class RecordControlEffectProjectController {

    @Autowired
    private RecordControlEffectProjectService recordControlEffectProjectService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordControlEffectProject>>> recordList(@RequestBody RecordControlEffectProjectRequest recordControlEffectProjectRequest) {
        return new ResponseEntity<>(Result.ok(recordControlEffectProjectService.queryList(recordControlEffectProjectRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordControlEffectProject>> add(@RequestBody RecordControlEffectProject recordControlEffectProject) {
        return new ResponseEntity<>(Result.ok(recordControlEffectProjectService.add(recordControlEffectProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordControlEffectProject>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordControlEffectProjectService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordControlEffectProject>> update(@RequestBody RecordControlEffectProject recordControlEffectProject) {
        return new ResponseEntity<>(Result.ok(recordControlEffectProjectService.update(recordControlEffectProject)), HttpStatus.OK);
    }



}
