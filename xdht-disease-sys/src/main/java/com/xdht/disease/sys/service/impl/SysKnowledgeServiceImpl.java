package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysKnowledge;
import com.xdht.disease.sys.service.SysKnowledgeService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysKnowledgeRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/26.
 */
@Service
@Transactional
public class SysKnowledgeServiceImpl extends AbstractService<SysKnowledge> implements SysKnowledgeService {

    @Override
    public PageResult<SysKnowledge> querySysKnowledgePage(SysKnowledgeRequest sysKnowledgeRequest) {
        Condition condition = new Condition(SysKnowledge.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
            .andEqualTo("catalogId", sysKnowledgeRequest.getCatalogId());
        String knowledgeTitle = sysKnowledgeRequest.getKnowledgeTitle();
        if (knowledgeTitle != null && !"".equals(knowledgeTitle)){
            condition.getOredCriteria().get(0).andLike("knowledgeTitle", "%" + knowledgeTitle + "%");
        }
        PageHelper.startPage(sysKnowledgeRequest.getPageNumber(), sysKnowledgeRequest.getPageSize());
        List<SysKnowledge> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysKnowledge> pageList = new PageResult<SysKnowledge>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public List<SysKnowledge> querySysKnowledgeList(SysKnowledgeRequest sysKnowledgeRequest) {
        Condition condition = new Condition(SysKnowledge.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                .andEqualTo("catalogId", sysKnowledgeRequest.getCatalogId())
                .andEqualTo("knowledgeId", sysKnowledgeRequest.getKnowledgeId());
        return this.selectByCondition(condition);
    }

    @Override
    public void addKnowledge(SysKnowledge sysKnowledge) {
        sysKnowledge.setKnowledgeVersion(1L);
        sysKnowledge.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysKnowledge);
        sysKnowledge.setCatalogId(sysKnowledge.getId());
        this.updateByPrimaryKeySelective(sysKnowledge);
    }

    @Override
    public void deleteKnowledge(Long id) {
        SysKnowledge sysKnowledge = new SysKnowledge();
        sysKnowledge.setId(id);
        sysKnowledge.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysKnowledge);
    }

    @Override
    public void updateKnowledge(SysKnowledge sysKnowledge) {
        SysKnowledge sysKnowledgeTemp = new SysKnowledge();
        sysKnowledgeTemp.setId(sysKnowledge.getId());
        sysKnowledgeTemp.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysKnowledgeTemp);

        Long knowledgeVersion = sysKnowledge.getKnowledgeVersion();
        sysKnowledge.setKnowledgeVersion(knowledgeVersion + 1);
        sysKnowledge.setId(null);
        sysKnowledge.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysKnowledge);
    }
}
