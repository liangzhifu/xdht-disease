package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.sys.service.SysUserRoleService;
import com.xdht.disease.sys.vo.request.SysUserRoleEditRequest;
import com.xdht.disease.sys.vo.request.SysUserRoleQueryRequest;
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
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService{

    @Override
    public List<SysUserRole> querySysUserRoleList(SysUserRoleQueryRequest sysUserRoleQueryRequest) {
        Condition condition = new Condition(SysUserRole.class);
        condition.createCriteria().andEqualTo("userId", sysUserRoleQueryRequest.getUserId())
                .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }

    @Override
    public void updateUserRole(SysUserRoleEditRequest sysUserRoleEditRequest) {
        //删除旧的关联数据
        Long userId = sysUserRoleEditRequest.getUserId();
        Condition condition = new Condition(SysUserRole.class);
        condition.createCriteria().andEqualTo("userId", userId);
        List<SysUserRole> sysUserRoleList = this.selectByCondition(condition);
        if (sysUserRoleList != null && sysUserRoleList.size() > 0) {
            for (SysUserRole sysUserRole : sysUserRoleList) {
                SysUserRole sysUserRoleTemp = new SysUserRole();
                sysUserRoleTemp.setId(sysUserRole.getId());
                sysUserRoleTemp.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.updateByPrimaryKeySelective(sysUserRoleTemp);
            }
        }
        //添加新的关联数据
        sysUserRoleList = new LinkedList<>();
        String roleIds = sysUserRoleEditRequest.getRoleIds();
        if (roleIds != null && !"".equals(roleIds)) {
            String[] roleIdArray = roleIds.split(",");
            for (String roleId : roleIdArray) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(Long.valueOf(roleId));
                sysUserRole.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                sysUserRoleList.add(sysUserRole);
            }
            this.insertList(sysUserRoleList);
        }
    }

}
