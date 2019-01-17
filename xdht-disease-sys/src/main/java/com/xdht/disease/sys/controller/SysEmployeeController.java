package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.constant.ResultCode;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.service.SysEmployeeService;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysEmployee")
public class SysEmployeeController {

    @Autowired
    private SysEmployeeService sysEmployeeService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询员工列表")
    public ResponseEntity<Result<PageResult<Map<String, Object>>>> queryPageList(@RequestBody SysEmployeeRequest sysEmployeeRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.querySysEmpPage(sysEmployeeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工列表")
    public ResponseEntity<Result<List<SysEmployee>>> queryList(@RequestBody SysEmployeeRequest sysEmployeeRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.queryCompanyEmployeeList(sysEmployeeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加员工")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addEmployee(@RequestBody SysEmployeeResponse sysEmployeeResponse) {
        try {
            sysEmployeeService.addEmployee(sysEmployeeResponse);

        } catch (Exception e) {
            return new ResponseEntity<>(Result.error(ResultCode.FAIL, e.getMessage()), HttpStatus.OK);
        }

        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除员工")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteEmployee(@RequestParam Long id) {
        sysEmployeeService.deleteEmployee(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改员工")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateEmployee(@RequestBody SysEmployeeResponse sysEmployeeResponse) {
        sysEmployeeService.updateEmployee(sysEmployeeResponse);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取职工信息")
    public ResponseEntity<Result<SysEmployeeResponse>> getEmployeeDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeService.getEmployeeDetail(id)), HttpStatus.OK);
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ApiOperation(value = "职工Excel上传")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> upload(@RequestParam("uploadFile") MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);

            }
        } catch (IOException e) {

        }

        try {
            this.sysEmployeeService.saveEmployeeExcel(workbook);
            //FileUtil.uploadFile(file.getBytes(), fileName);
        } catch (Exception e) {
            return new ResponseEntity<>(Result.error(ResultCode.FAIL, e.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }
}
