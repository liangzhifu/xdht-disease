package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysConstant;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysMenuMapper;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysMenuService;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuResponse;
import com.xdht.disease.sys.vo.response.SysMenuTreeResponse;
import com.xdht.disease.sys.vo.response.SysMenuZTreeNodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private ThreadLocalUserService threadLocalUserService;

        @Override
        public PageResult<SysMenu> querySysMenuPage(SysMenuRequest sysMenuRequest) {
            Condition condition = new Condition(SysMenu.class);
            if (sysMenuRequest.getMenuName() != null) {
                condition.createCriteria().andLike("menuName","%"+sysMenuRequest.getMenuName()+"%");
            }
            PageHelper.startPage(sysMenuRequest.getPageNumber(), sysMenuRequest.getPageSize());
            List<SysMenu> dataList = this.selectByCondition(condition);
            Integer count = this.selectCountByCondition(condition);
            PageResult<SysMenu> pageList = new PageResult<SysMenu>();
            pageList.setDataList(dataList);
            pageList.setTotal(count);
            return pageList;
        }
        @Override
        public List<SysMenu> querySysMenuList(SysMenu sysMenu) {
            Condition condition = new Condition(SysMenu.class);

            if (sysMenu.getMenuName() != null) {
                condition.createCriteria().andLike("menuName","%"+sysMenu.getMenuName()+"%");
            }
            List<SysMenu> sysMenuList = this.sysMenuMapper.selectByCondition(condition);
            return sysMenuList;
        }

        @Override
        public SysMenuResponse addMenu(SysMenu sysMenu) {
            this.insertUseGeneratedKeys(sysMenu);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(sysMenu.getId());
            sysMenuResponse.setMenuName(sysMenu.getMenuName());
            return sysMenuResponse;
        }

        @Override
        public SysMenuResponse deleteMenu(Long id) {
            SysMenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(id);
            sysMenu.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(id);
            return sysMenuResponse;
        }

        @Override
        public SysMenuResponse updateMenu(SysMenu sysMenu) {
            this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(sysMenu.getId());
            sysMenuResponse.setMenuName(sysMenu.getMenuName());
            return sysMenuResponse;
        }

    @Override
    public SysMenu getMenuDetail(Long id) {
       return  this.sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysMenuTreeResponse> getUserMenu() {
        List<SysMenuTreeResponse> sysMenuTreeResponses = new LinkedList<>();
        User user = threadLocalUserService.getUser();
        if (user != null) {
            List<SysMenu> sysMenuList = null;
            if (user.getId() == SysConstant.adminId) {
                Condition condition = new Condition(SysMenu.class);
                condition.createCriteria().andEqualTo("isShow", SysEnum.IsShowEnum.IS_SHOW_YES.getCode())
                        .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
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
    public List<SysMenuZTreeNodeResponse> getZTreeMenu() {
        Condition condition = new Condition(SysMenu.class);
        condition.createCriteria().andEqualTo("isShow", SysEnum.IsShowEnum.IS_SHOW_YES.getCode())
                .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                .andEqualTo("menuType", SysEnum.MenuTypeEnum.MENU_TYPE_MENU.getCode());
        List<SysMenu> sysMenuList = this.selectByCondition(condition);
        List<SysMenuZTreeNodeResponse> sysMenuZTreeNodeResponseList = new LinkedList<>();
        for (SysMenu sysMenu : sysMenuList) {
            SysMenuZTreeNodeResponse zTreeNodeResponse = new SysMenuZTreeNodeResponse();
            zTreeNodeResponse.setId(sysMenu.getId());
            zTreeNodeResponse.setPId(sysMenu.getParentId());
            zTreeNodeResponse.setName(sysMenu.getMenuName());
            sysMenuZTreeNodeResponseList.add(zTreeNodeResponse);
        }
        return sysMenuZTreeNodeResponseList;
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
            if (SysMenuTreeResponseTemp.getParentId() == id) {
                List<SysMenuTreeResponse> childList = this.getChildMenu(SysMenuTreeResponseTemp, sysMenuTreeResponseList);
                SysMenuTreeResponseTemp.setChildren(childList);
                childMenuList.add(SysMenuTreeResponseTemp);
            }
        }
        return childMenuList;
    }
}
