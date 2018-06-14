package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysQuestionnaireMapper;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.sys.service.SysQuestionnaireService;
import com.xdht.disease.sys.vo.request.SysQuestionnaireRequest;
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
public class SysQuestionnaireServiceImpl extends AbstractService<SysQuestionnaire> implements SysQuestionnaireService{

    @Autowired
    private SysQuestionnaireMapper sysQuestionnaireMapper;

    @Override
    public List<SysQuestionnaire> queryList(SysQuestionnaireRequest sysQuestionnaireRequest) {
        Condition condition = new Condition(SysQuestionnaire.class);
        condition.createCriteria() .andEqualTo("id", sysQuestionnaireRequest.getId());
        if (sysQuestionnaireRequest.getQuestionnaireName() != null) {
            condition.getOredCriteria().get(0).andLike("questionnaireName","%"+sysQuestionnaireRequest.getQuestionnaireName()+"%");
        }
        if (sysQuestionnaireRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",sysQuestionnaireRequest.getStatus());
        }
        return this.sysQuestionnaireMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<SysQuestionnaire> queryListPage(SysQuestionnaireRequest sysQuestionnaireRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(SysQuestionnaire.class);
        condition.createCriteria() .andEqualTo("id", sysQuestionnaireRequest.getId());
        if (sysQuestionnaireRequest.getQuestionnaireName() != null) {
            condition.getOredCriteria().get(0).andLike("questionnaireName","%"+sysQuestionnaireRequest.getQuestionnaireName()+"%");
        }
        if (sysQuestionnaireRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",sysQuestionnaireRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SysQuestionnaire> dataList = this.sysQuestionnaireMapper.selectByCondition(condition);
        Integer count = this.sysQuestionnaireMapper.selectCountByCondition(condition);
        PageResult<SysQuestionnaire> pageList = new  PageResult<SysQuestionnaire>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public SysQuestionnaire add(SysQuestionnaire sysQuestionnaire) {
        this.insertUseGeneratedKeys(sysQuestionnaire);
        return sysQuestionnaire;
    }

    @Override
    public SysQuestionnaire delete(Long id) {
        this.sysQuestionnaireMapper.deleteByPrimaryKey(id);
        SysQuestionnaire sysQuestionnaire = new SysQuestionnaire();
        sysQuestionnaire.setId(id);
        return sysQuestionnaire;
    }

    @Override
    public SysQuestionnaire update(SysQuestionnaire sysQuestionnaire) {
        this.sysQuestionnaireMapper.updateByPrimaryKeySelective(sysQuestionnaire);
        return sysQuestionnaire;
    }

    @Override
    public List<SysQuestionnaire> queryListAll() {
        return this.sysQuestionnaireMapper.selectAll();
    }
}
