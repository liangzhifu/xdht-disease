package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysRole;
import com.xdht.disease.sys.service.SysRoleService;
import com.xdht.disease.sys.vo.request.SysRoleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService{

    @Override
    public PageResult<SysRole> querySysRolePage(SysRoleRequest sysRoleRequest) {
        Condition condition = new Condition(SysRole.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysRoleRequest.getRoleName() != null){
            condition.getOredCriteria().get(0).andLike("roleName", "%"+sysRoleRequest.getRoleName()+"%");
        }
        PageHelper.startPage(sysRoleRequest.getPageNumber(), sysRoleRequest.getPageSize());
        List<SysRole> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysRole> pageList = new PageResult<SysRole>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public List<SysRole> querySysRoleList(SysRole sysRole) {
        Condition condition = new Condition(SysRole.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysRole.getRoleName() != null){
            condition.getOredCriteria().get(0).andLike("roleName", "%"+sysRole.getRoleName()+"%");
        }
        condition.setOrderByClause("id desc");
        List<SysRole> sysRoleList = this.selectByCondition(condition);
        return sysRoleList;
    }

    @Override
    public void addRole(SysRole sysRole) {
        this.insertUseGeneratedKeys(sysRole);
    }

    @Override
    public void deleteRole(Long id) {
        SysRole sysRole = this.selectByPrimaryKey(id);
        sysRole.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public void updateRole(SysRole sysRole) {
        this.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public SysRole getRoleDetail(Long id) {
        return this.selectByPrimaryKey(id);
    }
}
