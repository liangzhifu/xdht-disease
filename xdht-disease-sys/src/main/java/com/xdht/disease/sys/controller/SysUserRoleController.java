package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.sys.service.SysUserRoleService;
import com.xdht.disease.sys.vo.request.SysUserRoleEditRequest;
import com.xdht.disease.sys.vo.request.SysUserRoleQueryRequest;
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
@RequestMapping(value = "/api/v1/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询用户角色列表")
    public ResponseEntity<Result<List<SysUserRole>>> usersRoleList(@RequestBody SysUserRoleQueryRequest sysUserRoleQueryRequest) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.querySysUserRoleList(sysUserRoleQueryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户角色")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateUserRole(@RequestBody SysUserRoleEditRequest sysUserRoleEditRequest) {
        this.sysUserRoleService.updateUserRole(sysUserRoleEditRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

}
