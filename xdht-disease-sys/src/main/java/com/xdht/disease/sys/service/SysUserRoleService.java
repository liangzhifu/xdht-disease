package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysUserRoleEditRequest;
import com.xdht.disease.sys.vo.request.SysUserRoleQueryRequest;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysUserRoleService extends Service<SysUserRole> {

    /**
     * 查询用户角色列表
     * @param sysUserRoleQueryRequest 查询条件
     * @return 返回结果
     */
    List<SysUserRole> querySysUserRoleList(SysUserRoleQueryRequest sysUserRoleQueryRequest);

    /**
     * 修改用户角色
     * @param sysUserRoleEditRequest 用户角色实体
     * @return 返回结果
     */
    void updateUserRole(SysUserRoleEditRequest sysUserRoleEditRequest);

}
