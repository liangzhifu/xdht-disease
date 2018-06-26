package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.service.SysFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by L on 2018/6/26.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysFile")
public class SysFileController {

    @Autowired
    private SysFileService sysFileService;

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "文件上传")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> uploadFile(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        String filePath = "";
        if(!file.isEmpty()){
            filePath = this.sysFileService.addFile(file);
        }
        return new ResponseEntity<>(Result.ok(filePath), HttpStatus.OK);
    }

}
