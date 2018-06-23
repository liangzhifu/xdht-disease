package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordPreEvaluationMapper;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.model.RecordPreEvaluationProject;
import com.xdht.disease.sys.service.RecordPreEvaluationDataService;
import com.xdht.disease.sys.service.RecordPreEvaluationProjectService;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordPreEvaluationServiceImpl extends AbstractService<RecordPreEvaluation> implements RecordPreEvaluationService{

    @Autowired
    private RecordPreEvaluationMapper recordPreEvaluationMapper;

    @Autowired
    private RecordPreEvaluationDataService recordPreEvaluationDataService;

    @Autowired
    private RecordPreEvaluationProjectService recordPreEvaluationProjectService;

    @Override
    public List<RecordPreEvaluation> queryList(RecordPreEvaluationRequest recordPreEvaluationRequest) {
        Condition condition = new Condition(RecordPreEvaluation.class);
        condition.createCriteria() .andEqualTo("id", recordPreEvaluationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPreEvaluationRequest.getPreEvaluationNo());
        if (recordPreEvaluationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPreEvaluationRequest.getVerificationResult()+"%");
        }
        if (recordPreEvaluationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPreEvaluationRequest.getStatus());
        }
        return this.recordPreEvaluationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPreEvaluation> queryListPage(RecordPreEvaluationRequest recordPreEvaluationRequest) {
        Condition condition = new Condition(RecordPreEvaluation.class);
        if (recordPreEvaluationRequest.getPreEvaluationNo() != null) {
            condition.createCriteria().andLike("preEvaluationNo","%"+recordPreEvaluationRequest.getPreEvaluationNo()+"%");
        }

        PageHelper.startPage(recordPreEvaluationRequest.getPageNumber(), recordPreEvaluationRequest.getPageSize());
        List<RecordPreEvaluation> dataList = this.recordPreEvaluationMapper.selectByCondition(condition);
        Integer count = this.recordPreEvaluationMapper.selectCountByCondition(condition);
        PageResult<RecordPreEvaluation> pageList = new  PageResult<RecordPreEvaluation>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPreEvaluation add(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        RecordPreEvaluation recordPreEvaluation = new RecordPreEvaluation();
        recordPreEvaluation.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordPreEvaluation.setPreEvaluationNo(recordPreEvaluationInputRequest.getRecordPreEvaluation().getPreEvaluationNo());
        recordPreEvaluation.setVerificationResult(recordPreEvaluationInputRequest.getRecordPreEvaluation().getVerificationResult());
        this.insertUseGeneratedKeys(recordPreEvaluation);
        List<RecordPreEvaluationData> recordPreEvaluationDataList = new LinkedList<>();
        for (RecordPreEvaluationData recordPreEvaluationData : recordPreEvaluationInputRequest.getRecordPreEvaluationDataList() ) {
            recordPreEvaluationData.setPreEvaluationId(recordPreEvaluation.getId());
            recordPreEvaluationDataList.add(recordPreEvaluationData);
        }
        this.recordPreEvaluationDataService.insertList(recordPreEvaluationDataList);
        return recordPreEvaluation;
    }

    @Override
    public RecordPreEvaluation deleteRecordPreEvaluation(Long id) {
        RecordPreEvaluation recordPreEvaluation = this.recordPreEvaluationMapper.selectByPrimaryKey(id);
        recordPreEvaluation.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordPreEvaluationMapper.updateByPrimaryKeySelective(recordPreEvaluation);
        return recordPreEvaluation;
    }

    @Override
    public RecordPreEvaluation updateRecordPreEvaluation(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        RecordPreEvaluation recordPreEvaluation = new RecordPreEvaluation();
        recordPreEvaluation.setId(recordPreEvaluationInputRequest.getRecordPreEvaluation().getId());
        recordPreEvaluation.setPreEvaluationNo(recordPreEvaluationInputRequest.getRecordPreEvaluation().getPreEvaluationNo());
        recordPreEvaluation.setVerificationResult(recordPreEvaluationInputRequest.getRecordPreEvaluation().getVerificationResult());

        List<RecordPreEvaluationData> recordPreEvaluationDataList = new LinkedList<>();
        for (RecordPreEvaluationData recordPreEvaluationData : recordPreEvaluationInputRequest.getRecordPreEvaluationDataList() ) {
            this.recordPreEvaluationDataService.updateByPrimaryKeySelective(recordPreEvaluationData);
        }
        this.recordPreEvaluationMapper.updateByPrimaryKeySelective(recordPreEvaluation);
        return recordPreEvaluation;
    }

    @Override
    public RecordPreEvaluationDetailResponse queryRecordPreEvaluationDetail(Long id) {
        RecordPreEvaluationDetailResponse recordPreEvaluationDetailResponse = new RecordPreEvaluationDetailResponse();
        //根据sceneId 获取表的数据
        RecordPreEvaluation recordPreEvaluation = new RecordPreEvaluation();
        recordPreEvaluation.setSceneId(id);
        recordPreEvaluation = this.recordPreEvaluationMapper.selectOne(recordPreEvaluation);
        if (recordPreEvaluation != null){
            Long recordId = recordPreEvaluation.getId();
            recordPreEvaluationDetailResponse.setRecordPreEvaluation(recordPreEvaluation);
            Condition condition = new Condition(RecordPreEvaluationData.class);
            condition.createCriteria() .andEqualTo("preEvaluationId", recordId);
            List<RecordPreEvaluationData> recordPreEvaluationDataList = this.recordPreEvaluationDataService.selectByCondition(condition);
            recordPreEvaluationDetailResponse.setRecordPreEvaluationDataList(recordPreEvaluationDataList);
            String projectIds = "";
            for (RecordPreEvaluationData recordData : recordPreEvaluationDataList) {
                projectIds += recordData.getPreEvaluationProjectId()+",";
            }
            projectIds = projectIds.substring(0,projectIds.lastIndexOf(","));
            List<RecordPreEvaluationProject> projectList = this.recordPreEvaluationProjectService.selectByIds(projectIds);
            recordPreEvaluationDetailResponse.setRecordPreEvaluationProjectList(projectList);
        }
        return recordPreEvaluationDetailResponse;
    }
}
