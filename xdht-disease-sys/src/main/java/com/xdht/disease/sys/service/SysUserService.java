package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.exception.ServiceException;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 用户登录
     * @param loginRequest 登录信息
     * @return 返回结果
     */
    LoginResponse createToken(LoginRequest loginRequest);

    /**
     * 分页查询用户
     * @param sysUserRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysUser> querySysUserPage(SysUserRequest sysUserRequest);

    /**
     * 查询用户列表
     * @param sysUser 查询条件
     * @return 返回结果
     */
    List<SysUser> querySysUserList(SysUser sysUser);

    /**
     * 添加用户
     * @param sysUser 添加用户实体
     */
    void addUser(SysUser sysUser) throws ServiceException;

    /**
     * 删除用户
     * @param id 用户表id
     */
    void deleteUser(Long id);

    /**
     * 修改用户
     * @param sysUser 用户
     */
    void updateUser(SysUser sysUser);

}
