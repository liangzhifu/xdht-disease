package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordPreEvaluationMapper;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordPreEvaluationDataService;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
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
public class RecordPreEvaluationServiceImpl extends AbstractService<RecordPreEvaluation> implements RecordPreEvaluationService{

    @Autowired
    private RecordPreEvaluationMapper recordPreEvaluationMapper;

    @Autowired
    private RecordPreEvaluationDataService recordPreEvaluationDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

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
    public void add(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        RecordPreEvaluation recordPreEvaluation = recordPreEvaluationInputRequest.getRecordPreEvaluation();
        recordPreEvaluation.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordPreEvaluation);
        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordPreEvaluationInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordPreEvaluationInputRequest.getRecordPreEvaluation().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }
        List<RecordPreEvaluationData> recordPreEvaluationDataList = new LinkedList<>();
        for (RecordPreEvaluationData recordPreEvaluationData : recordPreEvaluationInputRequest.getRecordPreEvaluationDataList() ) {
            recordPreEvaluationData.setPreEvaluationId(recordPreEvaluation.getId());
            recordPreEvaluationDataList.add(recordPreEvaluationData);
        }
        this.recordPreEvaluationDataService.insertList(recordPreEvaluationDataList);
    }

    @Override
    public void deleteRecordPreEvaluation(Long id) {
        RecordPreEvaluation recordPreEvaluation = new RecordPreEvaluation();
        recordPreEvaluation.setId(id);
        recordPreEvaluation.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(recordPreEvaluation);
    }

    @Override
    public void updateRecordPreEvaluation(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        RecordPreEvaluation recordPreEvaluation = recordPreEvaluationInputRequest.getRecordPreEvaluation();
        this.updateByPrimaryKeySelective(recordPreEvaluation);

        List<RecordPreEvaluationData> recordPreEvaluationDataList = recordPreEvaluationInputRequest.getRecordPreEvaluationDataList();
        for (RecordPreEvaluationData recordPreEvaluationData : recordPreEvaluationDataList) {
            this.recordPreEvaluationDataService.updateByPrimaryKeySelective(recordPreEvaluationData);
        }
    }

    @Override
    public RecordPreEvaluationDetailResponse queryRecordPreEvaluationDetail(Long id) {
        RecordPreEvaluationDetailResponse recordPreEvaluationDetailResponse = new RecordPreEvaluationDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordPreEvaluationMapper.selectRecordPreEvaluationBySceneId(id);
        if (map != null){
            recordPreEvaluationDetailResponse.setRecordPreEvaluation(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordPreEvaluationDataService.queryRecordPreEvaluationDataByPreEvaluationId(recordId);
            recordPreEvaluationDetailResponse.setRecordPreEvaluationDataList(mapList);
        }
        return recordPreEvaluationDetailResponse;
    }
}
