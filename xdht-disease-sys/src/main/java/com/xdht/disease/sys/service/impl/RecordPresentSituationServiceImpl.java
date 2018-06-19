package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordPresentSituationMapper;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.model.RecordPresentSituationProject;
import com.xdht.disease.sys.service.RecordPresentSituationDataService;
import com.xdht.disease.sys.service.RecordPresentSituationProjectService;
import com.xdht.disease.sys.service.RecordPresentSituationService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;
import com.xdht.disease.sys.vo.response.RecordPresentSituationDetailResponse;
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
public class RecordPresentSituationServiceImpl extends AbstractService<RecordPresentSituation> implements RecordPresentSituationService{

    @Autowired
    private RecordPresentSituationMapper recordPresentSituationMapper;

    @Autowired
    private RecordPresentSituationDataService recordPresentSituationDataService;

    @Autowired
    private RecordPresentSituationProjectService  recordPresentSituationProjectService;
    @Override
    public List<RecordPresentSituation> queryList(RecordPresentSituationRequest recordPresentSituationRequest) {
        Condition condition = new Condition(RecordPresentSituation.class);
        condition.createCriteria() .andEqualTo("id", recordPresentSituationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPresentSituationRequest.getPreEvaluationNo());
        if (recordPresentSituationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPresentSituationRequest.getVerificationResult()+"%");
        }
        if (recordPresentSituationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPresentSituationRequest.getStatus());
        }
        return this.recordPresentSituationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPresentSituation> queryListPage(RecordPresentSituationRequest recordPresentSituationRequest) {
        Condition condition = new Condition(RecordPresentSituation.class);
        if (recordPresentSituationRequest.getPreEvaluationNo() != null) {
            condition.createCriteria().andLike("preEvaluationNo","%" + recordPresentSituationRequest.getPreEvaluationNo() + "%");
        }
/*        if (recordPresentSituationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPresentSituationRequest.getVerificationResult()+"%");
        }
        if (recordPresentSituationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPresentSituationRequest.getStatus());
        }*/
        PageHelper.startPage(recordPresentSituationRequest.getPageNumber(), recordPresentSituationRequest.getPageSize());
        List<RecordPresentSituation> dataList = this.recordPresentSituationMapper.selectByCondition(condition);
        Integer count = this.recordPresentSituationMapper.selectCountByCondition(condition);
        PageResult<RecordPresentSituation> pageList = new  PageResult<RecordPresentSituation>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPresentSituation addRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest) {
        RecordPresentSituation recordPresentSituation = new RecordPresentSituation();
        recordPresentSituation.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordPresentSituation.setVerificationResult(recordPresentSituationInputRequest.getRecordPresentSituation().getVerificationResult());
        recordPresentSituation.setPreEvaluationNo(recordPresentSituationInputRequest.getRecordPresentSituation().getPreEvaluationNo());
        this.insertUseGeneratedKeys(recordPresentSituation);
        List<RecordPresentSituationData> recordPresentSituationDataList = new LinkedList<>();
        for ( RecordPresentSituationData recordPresentSituationData: recordPresentSituationInputRequest.getRecordPresentSituationDataList()) {
                recordPresentSituationData.setPreEvaluationId(recordPresentSituation.getId());
                recordPresentSituationDataList.add(recordPresentSituationData);
        }
        this.recordPresentSituationDataService.insertList(recordPresentSituationDataList);
        return recordPresentSituation;
    }

    @Override
    public RecordPresentSituation deleteRecordPresentSituation(Long id) {
        RecordPresentSituation recordPresentSituation = this.selectByPrimaryKey(id);
        recordPresentSituation.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordPresentSituationMapper.updateByPrimaryKeySelective(recordPresentSituation);
        return recordPresentSituation;
    }

    @Override
    public RecordPresentSituation updateRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest) {
        RecordPresentSituation recordPresentSituation = new RecordPresentSituation();
        recordPresentSituation.setId(recordPresentSituationInputRequest.getRecordPresentSituation().getId());
        recordPresentSituation.setPreEvaluationNo(recordPresentSituationInputRequest.getRecordPresentSituation().getPreEvaluationNo());
        recordPresentSituation.setVerificationResult(recordPresentSituationInputRequest.getRecordPresentSituation().getVerificationResult());
        this.recordPresentSituationMapper.updateByPrimaryKeySelective(recordPresentSituation);
        List<RecordPresentSituationData> recordPresentSituationDataList = new LinkedList<>();
        for (RecordPresentSituationData  recordPresentSituationData:  recordPresentSituationInputRequest.getRecordPresentSituationDataList()) {
            this.recordPresentSituationDataService.updateByPrimaryKeySelective(recordPresentSituationData);
        }
        return recordPresentSituation;
    }

    @Override
    public RecordPresentSituationDetailResponse queryRecordPresentSituationDetail(Long id) {
        RecordPresentSituationDetailResponse response = new RecordPresentSituationDetailResponse();
        RecordPresentSituation recordPresentSituation = this.recordPresentSituationMapper.selectByPrimaryKey(id);
        response.setRecordPresentSituation(recordPresentSituation);
        Condition condition = new Condition(RecordPresentSituationData.class);
        condition.createCriteria() .andEqualTo("preEvaluationId", id);
        List<RecordPresentSituationData> recordPresentSituationDataList = this.recordPresentSituationDataService.selectByCondition(condition);
        response.setRecordPresentSituationDataList(recordPresentSituationDataList);
        String projectIds = "";
        for (RecordPresentSituationData recordData : recordPresentSituationDataList) {
            projectIds += recordData.getPreEvaluationProjectId()+",";
        }
        projectIds = projectIds.substring(0,projectIds.lastIndexOf(","));
        List<RecordPresentSituationProject> projectList = this.recordPresentSituationProjectService.selectByIds(projectIds);
        response.setRecordPresentSituationProjectList(projectList);
        return response;
    }
}
