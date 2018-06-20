package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysRole;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysRoleRequest;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysRoleService extends Service<SysRole> {

    /**
     * 查询角色列表
     * @param sysRoleRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysRole> querySysRolePage(SysRoleRequest sysRoleRequest);

    /**
     * 查询角色列表
     * @param sysRole 查询条件
     * @return 返回结果
     */
    List<SysRole> querySysRoleList(SysRole sysRole);

    /**
     * 添加角色
     * @param sysRole 角色实体
     * @return 返回结果
     */
    void addRole(SysRole sysRole);

    /**
     * 删除角色
     * @param id 角色主键id
     * @return 返回结果
     */
    void deleteRole(Long id);

    /**
     * 修改角色
     * @param sysRole 角色实体
     * @return 返回结果
     */
    void updateRole(SysRole sysRole);

    /**
     * 获取角色信息
     * @param id 主键id
     * @return 返回结果
     */
    SysRole getRoleDetail(Long id);
}
