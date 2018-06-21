package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.service.SysMenuService;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuTreeResponse;
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
@RequestMapping(value = "/api/v1/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "用户菜单")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<List<SysMenuTreeResponse>>> getUserMenu() {
        return new ResponseEntity<>(Result.ok(this.sysMenuService.getUserMenu()), HttpStatus.OK);
    }

    @RequestMapping(value = "/zTreeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "ZTree菜单")
    public ResponseEntity<Result<List<SysMenu>>> getZTreeMenu(@RequestBody SysMenuRequest sysMenuRequest) {
        return new ResponseEntity<>(Result.ok(this.sysMenuService.getZTreeMenu(sysMenuRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加菜单")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.addMenu(sysMenu);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除菜单")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteMenu(@RequestParam Long id) {
        sysMenuService.deleteMenu(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改菜单")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateMenu(sysMenu);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取菜单信息")
    @Authorization
    public ResponseEntity<Result<SysMenu>> getRoleDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysMenuService.selectByPrimaryKey(id)), HttpStatus.OK);
    }

}
