package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysPostMapper;
import com.xdht.disease.sys.model.SysPost;
import com.xdht.disease.sys.service.SysPostService;
import com.xdht.disease.sys.vo.request.SysPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class SysPostServiceImpl extends AbstractService<SysPost> implements SysPostService{

    @Autowired
    private SysPostMapper sysPostMapper;

    @Override
    public List<SysPost> queryList(SysPostRequest sysPostRequest) {
        Condition condition = new Condition(SysPost.class);
        condition.createCriteria() .andEqualTo("id", sysPostRequest.getId());
        if (sysPostRequest.getPostName() != null) {
            condition.getOredCriteria().get(0).andLike("postName","%"+sysPostRequest.getPostName()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.sysPostMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<SysPost> queryListPage(SysPostRequest sysPostRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(SysPost.class);
        condition.createCriteria() .andEqualTo("id", sysPostRequest.getId());
        if (sysPostRequest.getPostName() != null) {
            condition.getOredCriteria().get(0).andLike("postName","%"+sysPostRequest.getPostName()+"%");
        }
        if (sysPostRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",sysPostRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SysPost> dataList = this.sysPostMapper.selectByCondition(condition);
        PageResult<SysPost> pageList = new  PageResult<SysPost>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public SysPost add(SysPost sysPost) {
        this.sysPostMapper.insertUseGeneratedKeys(sysPost);
        return sysPost;
    }

    @Override
    public SysPost delete(Long id) {
        this.sysPostMapper.deleteByPrimaryKey(id);
        SysPost sysPost = new SysPost();
        sysPost.setId(id);
        return sysPost;
    }

    @Override
    public SysPost update(SysPost sysPost) {
        this.sysPostMapper.updateByPrimaryKeySelective(sysPost);
        return sysPost;
    }
}
