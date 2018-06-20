package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.model.TokenModel;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysUserMapper;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService{

        @Autowired
        private SysUserMapper sysUserMapper;

        @Resource(name = "ehcacheTokenManager")
        private TokenManager tokenManager;

    @Override
    public LoginResponse createToken(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        SysUser sysUser = new SysUser();
        sysUser.setLoginCode(loginRequest.getLoginCode());
        sysUser.setPassword(loginRequest.getPassword());
        sysUser = this.sysUserMapper.selectOne(sysUser);
//        if (sysUser == null) {
//            loginResponse.setStatus("0");
//        } else {
            User user = new User();
            user.setName(sysUser.getUserName());
            user.setId(sysUser.getId());
            TokenModel tokenModel = this.tokenManager.createToken(user);
            loginResponse.setToken(tokenModel.getToken());
            loginResponse.setUserName(sysUser.getUserName());
            loginResponse.setStatus("1");
//        }
        return loginResponse;
    }

    @Override
    public PageResult<SysUser> querySysUserPage(SysUserRequest sysUserRequest) {
        Condition condition = new Condition(SysUser.class);
        if (sysUserRequest.getUserName() != null){
            condition.createCriteria().andLike("userName", "%"+sysUserRequest.getUserName()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(sysUserRequest.getPageNumber(), sysUserRequest.getPageSize());
        List<SysUser> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysUser> pageList = new PageResult<SysUser>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public List<SysUser> querySysUserList(SysUser sysUser) {
        Condition condition = new Condition(SysUser.class);
        if (sysUser.getUserName() != null){
            condition.createCriteria().andLike("userName", "%"+sysUser.getUserName()+"%");
        }
        condition.setOrderByClause("id desc");
        List<SysUser> sysUserList = this.sysUserMapper.selectByCondition(condition);
        return sysUserList;
    }


    @Override
    public SysUserResponse addUser(SysUser sysUser) {
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
    }

    @Override
    public SysUserResponse deleteUser(Long id) {
        SysUser sysUser = this.sysUserMapper.selectByPrimaryKey(id);
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysUser);
//        this.sysUserMapper.deleteByPrimaryKey(id);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(id);
        return sysUserResponse;
    }

    @Override
    public SysUserResponse updateUser(SysUser sysUser) {
        this.updateByPrimaryKeySelective(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
    }

    @Override
    public SysUser getUserDetail(Long id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

}
