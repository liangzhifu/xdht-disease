package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.sys.service.SysRoleMenuService;
import com.xdht.disease.sys.vo.request.SysRoleMenuEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleMenuQueryRequest;
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
@RequestMapping(value = "/api/v1/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询角色菜单列表")
    public ResponseEntity<Result<List<SysRoleMenu>>> roleMenuList(@RequestBody SysRoleMenuQueryRequest sysRoleMenuQueryRequest) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.querySysRoleMenuList(sysRoleMenuQueryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改角色菜单")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateRoleMenu(@RequestBody SysRoleMenuEditRequest sysRoleMenuEditRequest) {
        sysRoleMenuService.updateRoleMenu(sysRoleMenuEditRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

}
