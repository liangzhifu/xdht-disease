package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysDictionaryType;
import com.xdht.disease.sys.service.SysDictionaryTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by L on 2018/6/21.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/SysDictionaryType")
public class SysDictionaryTypeController {

    @Autowired
    private SysDictionaryTypeService sysDictionaryTypeService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询字典类型列表")
    public ResponseEntity<Result<PageResult<SysDictionaryType>>> rolePage() {
        return new ResponseEntity<>(Result.ok(sysDictionaryTypeService.selectAll()), HttpStatus.OK);
    }

}
