package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysRoleMenuEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleMenuQueryRequest;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysRoleMenuService extends Service<SysRoleMenu> {

    /**
     * 查询角色菜单列表
     * @param sysRoleMenuQueryRequest 查询条件
     * @return 返回结果
     */
    List<SysRoleMenu> querySysRoleMenuList(SysRoleMenuQueryRequest sysRoleMenuQueryRequest);

    /**
     * 修改角色菜单
     * @param sysRoleMenuEditRequest 修改数据
     * @return 返回结果
     */
    void updateRoleMenu(SysRoleMenuEditRequest sysRoleMenuEditRequest);

}
