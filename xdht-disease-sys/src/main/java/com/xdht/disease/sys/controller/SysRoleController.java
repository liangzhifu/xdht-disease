package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysRole;
import com.xdht.disease.sys.service.SysRoleService;
import com.xdht.disease.sys.vo.request.SysRoleRequest;
import com.xdht.disease.sys.vo.response.SysRoleResponse;
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
@RequestMapping(value = "/api/v1/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/rolePage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询角色列表")
    public ResponseEntity<Result<PageResult<SysRole>>> rolePage(@RequestBody SysRoleRequest sysRoleRequest) {
        return new ResponseEntity<>(Result.ok(sysRoleService.querySysRolePage(sysRoleRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/roleList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询角色列表")
    public ResponseEntity<Result<List<SysRole>>> roleList(@RequestBody SysRole sysRole) {
        return new ResponseEntity<>(Result.ok(sysRoleService.querySysRoleList(sysRole)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加角色")
    @Authorization
    public ResponseEntity<Result<SysRoleResponse>> addRole(@RequestBody SysRole sysRole) {
        return new ResponseEntity<>(Result.ok(sysRoleService.addRole(sysRole)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除角色")
    @Authorization
    public ResponseEntity<Result<SysRoleResponse>> deleteRole(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysRoleService.deleteRole(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改角色")
    @Authorization
    public ResponseEntity<Result<SysRoleResponse>> updateRole(@RequestBody SysRole sysRole) {
        return new ResponseEntity<>(Result.ok(sysRoleService.updateRole(sysRole)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取角色信息")
    @Authorization
    public ResponseEntity<Result<SysRole>> getRoleDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysRoleService.getRoleDetail(id)), HttpStatus.OK);
    }

}
