package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysConstant;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysMenuMapper;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.service.SysMenuService;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuTreeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private ThreadLocalUserService threadLocalUserService;

    @Override
    public void addMenu(SysMenu sysMenu) {
        Long parentId = sysMenu.getParentId();
        if (parentId == 0) {
            sysMenu.setParentIds(",0,");
        } else {
            SysMenu sysMenuTemp = this.selectByPrimaryKey(parentId);
            sysMenu.setParentIds(sysMenuTemp.getParentIds() + parentId + ",");
        }
        sysMenu.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysMenu);
    }

    @Override
    public void deleteMenu(Long id) {
        SysMenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(id);
        sysMenu.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysMenu);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", threadLocalUserService.getUser().getId());
        this.sysMenuMapper.deleteChild(map);
    }

    @Override
    public void updateMenu(SysMenu sysMenu) {
        this.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public List<SysMenuTreeResponse> getUserMenu() {
        List<SysMenuTreeResponse> sysMenuTreeResponses = new LinkedList<>();
        User user = threadLocalUserService.getUser();
        if (user != null) {
            List<SysMenu> sysMenuList = new LinkedList<>();
            if (user.getMgrType().equals(SysConstant.adminMgrType)) {
                Condition condition = new Condition(SysMenu.class);
                condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                        .andEqualTo("menuType", SysEnum.MenuTypeEnum.MENU_TYPE_MENU.getCode());
                sysMenuList = this.selectByCondition(condition);
            } else {
                sysMenuList = this.sysMenuMapper.selectUserMenu(user.getId());
            }
            sysMenuTreeResponses = this.convertSysMenuToSysMenuTree(sysMenuList);
        }
        return sysMenuTreeResponses;
    }

    @Override
    public List<SysMenu> getZTreeMenu(SysMenuRequest sysMenuRequest) {
        Condition condition = new Condition(SysMenu.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                .andEqualTo("menuType", sysMenuRequest.getMenuType());
        return this.selectByCondition(condition);
    }

    /**
     * 菜单列表转换为菜单树
     * @param sysMenuList 菜单列表
     * @return 返回结果
     */
    private List<SysMenuTreeResponse> convertSysMenuToSysMenuTree(List<SysMenu> sysMenuList) {
        List<SysMenuTreeResponse> treeResponse = new LinkedList<>();
        List<SysMenuTreeResponse> sysMenuTreeResponseList = new LinkedList<>();
        if (sysMenuList != null) {
            for (SysMenu sysMenu : sysMenuList) {
                SysMenuTreeResponse sysMenuTreeResponse = new SysMenuTreeResponse();
                sysMenuTreeResponse.setId(sysMenu.getId());
                sysMenuTreeResponse.setParentId(sysMenu.getParentId());
                sysMenuTreeResponse.setName(sysMenu.getMenuName());
                sysMenuTreeResponse.setUrl(sysMenu.getMenuHref());
                sysMenuTreeResponse.setIcon(sysMenu.getMenuIcon());
                sysMenuTreeResponse.setExpend(false);
                sysMenuTreeResponseList.add(sysMenuTreeResponse);
            }
            for (SysMenuTreeResponse sysMenuTreeResponse : sysMenuTreeResponseList){
                if (sysMenuTreeResponse.getParentId() == 0) {
                    List<SysMenuTreeResponse> childMenuList = this.getChildMenu(sysMenuTreeResponse, sysMenuTreeResponseList);
                    sysMenuTreeResponse.setChildren(childMenuList);
                    treeResponse.add(sysMenuTreeResponse);
                }
            }
        }
        return treeResponse;
    }

    /**
     * 获取子菜单
     * @param sysMenuTreeResponse 当前菜单
     * @param sysMenuTreeResponseList 菜单列表
     * @return 返回结果
     */
    private List<SysMenuTreeResponse> getChildMenu(SysMenuTreeResponse sysMenuTreeResponse, List<SysMenuTreeResponse> sysMenuTreeResponseList) {
        Long id = sysMenuTreeResponse.getId();
        List<SysMenuTreeResponse> childMenuList = new LinkedList<>();
        for (SysMenuTreeResponse SysMenuTreeResponseTemp : sysMenuTreeResponseList) {
            if (SysMenuTreeResponseTemp.getParentId().intValue() == id) {
                List<SysMenuTreeResponse> childList = this.getChildMenu(SysMenuTreeResponseTemp, sysMenuTreeResponseList);
                SysMenuTreeResponseTemp.setChildren(childList);
                childMenuList.add(SysMenuTreeResponseTemp);
            }
        }
        return childMenuList;
    }
}
