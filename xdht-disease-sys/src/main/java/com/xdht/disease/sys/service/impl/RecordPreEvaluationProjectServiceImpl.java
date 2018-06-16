package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordPreEvaluationProjectMapper;
import com.xdht.disease.sys.model.RecordPreEvaluationProject;
import com.xdht.disease.sys.service.RecordPreEvaluationProjectService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordPreEvaluationProjectServiceImpl extends AbstractService<RecordPreEvaluationProject> implements RecordPreEvaluationProjectService{

    @Autowired
    private RecordPreEvaluationProjectMapper recordPreEvaluationProjectMapper;

    @Override
    public List<RecordPreEvaluationProject> queryList(RecordPreEvaluationProjectRequest recordPreEvaluationProjectRequest) {
        Condition condition =  new Condition(RecordPreEvaluationProject.class);
        condition.createCriteria().andEqualTo("id",recordPreEvaluationProjectRequest.getId());
        if (recordPreEvaluationProjectRequest.getProjectName() != null){
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordPreEvaluationProjectRequest.getProjectName()+"%");
        }
        return this.recordPreEvaluationProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordPreEvaluationProject add(RecordPreEvaluationProject recordPreEvaluationProject) {
            this.recordPreEvaluationProjectMapper.insertUseGeneratedKeys(recordPreEvaluationProject);
            return recordPreEvaluationProject;
    }

    @Override
    public RecordPreEvaluationProject delete(Long id) {
        this.recordPreEvaluationProjectMapper.deleteByPrimaryKey(id);
        RecordPreEvaluationProject recordPreEvaluationProject = new RecordPreEvaluationProject();
        recordPreEvaluationProject.setId(id);
        return recordPreEvaluationProject;
    }

    @Override
    public RecordPreEvaluationProject update(RecordPreEvaluationProject recordPreEvaluationProject) {
        this.recordPreEvaluationProjectMapper.updateByPrimaryKeySelective(recordPreEvaluationProject);
        return recordPreEvaluationProject;
    }

    @Override
    public List<RecordPreEvaluationProject> queryListAll() {
        return this.selectAll();
    }
}
