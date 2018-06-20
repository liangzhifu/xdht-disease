package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.sys.service.SysRoleMenuService;
import com.xdht.disease.sys.vo.request.SysRoleMenuEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleMenuQueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService{

    @Override
    public List<SysRoleMenu> querySysRoleMenuList(SysRoleMenuQueryRequest sysRoleMenuQueryRequest) {
        Condition condition = new Condition(SysRoleMenu.class);
        condition.createCriteria().andEqualTo("roleId", sysRoleMenuQueryRequest.getRoleId())
            .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }


    @Override
    public void updateRoleMenu(SysRoleMenuEditRequest sysRoleMenuEditRequest) {
        //删除旧的关联关系
        Long roleId = sysRoleMenuEditRequest.getRoleId();
        Condition condition = new Condition(SysRoleMenu.class);
        condition.createCriteria().andEqualTo("roleId", roleId);
        List<SysRoleMenu> sysRoleMenuList = this.selectByCondition(condition);
        if (sysRoleMenuList != null && sysRoleMenuList.size() > 0) {
            for (SysRoleMenu sysRoleMenu : sysRoleMenuList){
                SysRoleMenu sysRoleMenuTemp = new SysRoleMenu();
                sysRoleMenuTemp.setId(sysRoleMenu.getId());
                sysRoleMenuTemp.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.updateByPrimaryKeySelective(sysRoleMenuTemp);
            }
        }
        //新增新的关联关系
        String menuIds = sysRoleMenuEditRequest.getMenuIds();
        sysRoleMenuList = new LinkedList<>();
        if (menuIds != null && !"".equals(menuIds)) {
            String[] menuIdArray = menuIds.split(",");
            for (String menuId : menuIdArray){
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(roleId);
                sysRoleMenu.setMenuId(Long.valueOf(menuId));
                sysRoleMenu.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                sysRoleMenuList.add(sysRoleMenu);
            }
        }
        this.insertList(sysRoleMenuList);
    }

}
