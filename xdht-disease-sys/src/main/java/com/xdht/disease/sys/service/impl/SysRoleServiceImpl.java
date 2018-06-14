package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysRoleMapper;
import com.xdht.disease.sys.model.SysRole;
import com.xdht.disease.sys.service.SysRoleService;
import com.xdht.disease.sys.vo.request.SysRoleRequest;
import com.xdht.disease.sys.vo.response.SysRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageResult<SysRole> querySysRolePage(SysRoleRequest sysRoleRequest) {
        Condition condition = new Condition(SysRole.class);
        if (sysRoleRequest.getRoleName() != null){
        condition.createCriteria().andLike("roleName", "%"+sysRoleRequest.getRoleName()+"%");
        }
        PageHelper.startPage(sysRoleRequest.getPageNumber(), sysRoleRequest.getPageSize());
        List<SysRole> dataList = this.sysRoleMapper.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysRole> pageList = new PageResult<SysRole>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public List<SysRole> querySysRoleList(SysRole sysRole) {
        Condition condition = new Condition(SysRole.class);
        if (sysRole.getRoleName() != null){
        condition.createCriteria().andLike("roleName", "%"+sysRole.getRoleName()+"%");
        }
        condition.setOrderByClause("id desc");
        List<SysRole> sysRoleList = this.sysRoleMapper.selectByCondition(condition);
        return sysRoleList;
    }

    @Override
    public SysRoleResponse addRole(SysRole sysRole) {
        this.insertUseGeneratedKeys(sysRole);
        SysRoleResponse sysRoleResponse = new SysRoleResponse();
        sysRoleResponse.setId(sysRole.getId());
        sysRoleResponse.setRoleName(sysRole.getRoleName());
        return sysRoleResponse;
    }

    @Override
    public SysRoleResponse deleteRole(Long id) {
        SysRole sysRole = this.sysRoleMapper.selectByPrimaryKey(id);
        sysRole.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        SysRoleResponse sysRoleResponse = new SysRoleResponse();
        sysRoleResponse.setId(id);
        sysRoleResponse.setRoleName(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        return sysRoleResponse;
    }

    @Override
    public SysRoleResponse updateRole(SysRole sysRole) {
        this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        SysRoleResponse sysRoleResponse = new SysRoleResponse();
        sysRoleResponse.setId(sysRole.getId());
        sysRoleResponse.setRoleName(sysRole.getRoleName());
        return sysRoleResponse;
    }

    @Override
    public SysRole getRoleDetail(Long id) {
        return this.sysRoleMapper.selectByPrimaryKey(id);
    }
}
