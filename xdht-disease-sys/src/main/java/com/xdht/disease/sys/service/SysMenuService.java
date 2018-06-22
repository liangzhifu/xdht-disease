package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuTreeResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysMenuService extends Service<SysMenu> {

    /**
     * 添加菜单
     * @param sysMenu 菜单实体
     */
    void addMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id 菜单主键id
     */
    void deleteMenu(Long id);

    /**
     * 修改菜单
     * @param sysMenu 菜单实体
     */
    void updateMenu(SysMenu sysMenu);

    /**
     * 获取用户菜单
     * @return 返回结果
     */
    List<SysMenuTreeResponse> getUserMenu();

    /**
     * 获取ZTree菜单
     * @param sysMenuRequest 查询条件
     * @return 返回结果
     */
    List<SysMenu> getZTreeMenu(SysMenuRequest sysMenuRequest);

}
