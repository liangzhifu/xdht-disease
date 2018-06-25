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
import java.util.Map;


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
        if (recordPresentSituationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPresentSituationRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordPresentSituationRequest.getPageNumber(), recordPresentSituationRequest.getPageSize());
        List<RecordPresentSituation> dataList = this.recordPresentSituationMapper.selectByCondition(condition);
        Integer count = this.recordPresentSituationMapper.selectCountByCondition(condition);
        PageResult<RecordPresentSituation> pageList = new  PageResult<RecordPresentSituation>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void addRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest) {
        RecordPresentSituation recordPresentSituation = new RecordPresentSituation();
        recordPresentSituation.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordPresentSituation);
        List<RecordPresentSituationData> recordPresentSituationDataList = new LinkedList<>();
        for ( RecordPresentSituationData recordPresentSituationData: recordPresentSituationInputRequest.getRecordPresentSituationDataList()) {
                recordPresentSituationData.setPreEvaluationId(recordPresentSituation.getId());
                recordPresentSituationDataList.add(recordPresentSituationData);
        }
        this.recordPresentSituationDataService.insertList(recordPresentSituationDataList);
    }

    @Override
    public void deleteRecordPresentSituation(Long id) {
        RecordPresentSituation recordPresentSituation = this.selectByPrimaryKey(id);
        recordPresentSituation.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordPresentSituationMapper.updateByPrimaryKeySelective(recordPresentSituation);
    }

    @Override
    public void updateRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest) {
        RecordPresentSituation recordPresentSituation = new RecordPresentSituation();
        recordPresentSituation.setId(recordPresentSituationInputRequest.getRecordPresentSituation().getId());
        recordPresentSituation.setPreEvaluationNo(recordPresentSituationInputRequest.getRecordPresentSituation().getPreEvaluationNo());
        recordPresentSituation.setVerificationResult(recordPresentSituationInputRequest.getRecordPresentSituation().getVerificationResult());
        this.recordPresentSituationMapper.updateByPrimaryKeySelective(recordPresentSituation);
        List<RecordPresentSituationData> recordPresentSituationDataList = new LinkedList<>();
        for (RecordPresentSituationData  recordPresentSituationData:  recordPresentSituationInputRequest.getRecordPresentSituationDataList()) {
            this.recordPresentSituationDataService.updateByPrimaryKeySelective(recordPresentSituationData);
        }
    }

    @Override
    public RecordPresentSituationDetailResponse queryRecordPresentSituationDetail(Long id) {
        RecordPresentSituationDetailResponse response = new RecordPresentSituationDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordPresentSituationMapper.selectRecordBySceneId(id);
        if (map != null){
            response.setRecordPresentSituation(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordPresentSituationDataService.queryRecordDataByPreEvaluationId(recordId);
            response.setRecordPresentSituationDataList(mapList);
        }
        return response;
    }
}
