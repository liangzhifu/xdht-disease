package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.sys.service.SysQuestionnaireService;
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
@RequestMapping(value = "/api/v1/sysQuestionnaire")
public class SysQuestionnaireController {

    @Autowired
    private SysQuestionnaireService sysQuestionnaireService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<SysQuestionnaire>>> recordList() {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.queryList()), HttpStatus.OK);
    }
    @RequestMapping(value = "/selectOne/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询调查表")
    public ResponseEntity<Result<SysQuestionnaire>> selcetOne(@PathVariable Long id) {
        SysQuestionnaire sysQuestionnaire=this.sysQuestionnaireService.selectOne(id);
          return new ResponseEntity<>(Result.ok(sysQuestionnaire), HttpStatus.OK);

    }

}
