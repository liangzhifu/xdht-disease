package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysMenuService extends Service<SysMenu> {

    /**
     * 分页查询菜单
     * @param sysMenuRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysMenu> querySysMenuPage(SysMenuRequest sysMenuRequest);

    /**
     * 查询菜单列表
     * @param sysMenu 查询条件
     * @return 返回结果
     */
    public List<SysMenu> querySysMenuList(SysMenu sysMenu);

    /**
     * 添加菜单
     * @param sysMenu 菜单实体
     * @return 返回结果
     */
    public SysMenuResponse addMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id 菜单主键id
     * @return 返回结果
     */
    public SysMenuResponse  deleteMenu(Long id);

    /**
     * 修改菜单
     * @param sysMenu 菜单实体
     * @return 返回结果
     */
    public SysMenuResponse  updateMenu(SysMenu sysMenu);


    public SysMenu getMenuDetail(Long id);
}
