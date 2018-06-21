package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper extends Mapper<SysMenu> {

    /**
     * 查询用户菜单
     * @param userId 用户ID
     * @return 返回结果
     */
    List<SysMenu> selectUserMenu(Long userId);

    /**
     * 删除子菜单
     * @param map 条件
     */
    void deleteChild(Map<String, Object> map);

}