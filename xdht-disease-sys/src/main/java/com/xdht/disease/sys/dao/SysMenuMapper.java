package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysMenu;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

    /**
     * 查询用户菜单
     * @param userId 用户ID
     * @return 返回结果
     */
    public List<SysMenu> selectUserMenu(Long userId);

}