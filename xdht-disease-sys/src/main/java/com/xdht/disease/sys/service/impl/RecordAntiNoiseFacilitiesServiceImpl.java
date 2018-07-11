package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordAntiNoiseFacilitiesMapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesDataService;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseInputRequest;
import com.xdht.disease.sys.vo.response.RecordAntiNoiseDetailResponse;
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
public class RecordAntiNoiseFacilitiesServiceImpl extends AbstractService<RecordAntiNoiseFacilities> implements RecordAntiNoiseFacilitiesService{

    @Autowired
    private RecordAntiNoiseFacilitiesMapper recordAntiNoiseFacilitiesMapper;

    @Autowired
    private RecordAntiNoiseFacilitiesDataService recordAntiNoiseFacilitiesDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordAntiNoiseFacilities> queryListPage(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        Condition condition =  new Condition(RecordAntiNoiseFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesRequest.getId());
        if (recordAntiNoiseFacilitiesRequest.getAntiNoiseFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("antiNoiseFacilitiesNo","%"+recordAntiNoiseFacilitiesRequest.getAntiNoiseFacilitiesNo()+"%");
        }
        if (recordAntiNoiseFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAntiNoiseFacilitiesRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordAntiNoiseFacilitiesRequest.getPageNumber(), recordAntiNoiseFacilitiesRequest.getPageSize());
        List<RecordAntiNoiseFacilities> dataList = this.recordAntiNoiseFacilitiesMapper.selectByCondition(condition);
        Integer count = this.recordAntiNoiseFacilitiesMapper.selectCountByCondition(condition);
        PageResult<RecordAntiNoiseFacilities> pageList = new  PageResult<RecordAntiNoiseFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void addRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {
        RecordAntiNoiseFacilities recordAntiNoiseFacilities = recordAntiNoiseInputRequest.getRecordAntiNoiseFacilities();
        recordAntiNoiseFacilities.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordAntiNoiseFacilities);
        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordAntiNoiseInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordAntiNoiseInputRequest.getRecordAntiNoiseFacilities().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }
        List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList = new LinkedList<>();
        if (recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList() != null) {
            for ( RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData : recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList()) {
                recordAntiNoiseFacilitiesData.setRelationId(recordAntiNoiseFacilities.getId());
                recordAntiNoiseFacilitiesDataList.add(recordAntiNoiseFacilitiesData);
            }
            this.recordAntiNoiseFacilitiesDataService.insertList(recordAntiNoiseFacilitiesDataList);
        }
    }

    @Override
    public void deleteRecordAntiNoiseFacilities(Long id) {
        RecordAntiNoiseFacilities recordAntiNoiseFacilities = new RecordAntiNoiseFacilities();
        recordAntiNoiseFacilities.setId(id);
        recordAntiNoiseFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordAntiNoiseFacilitiesMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilities);
    }

    @Override
    public void updateRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {
        RecordAntiNoiseFacilities recordAntiNoiseFacilities = recordAntiNoiseInputRequest.getRecordAntiNoiseFacilities();
        this.recordAntiNoiseFacilitiesMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilities);

        Condition condition = new Condition(RecordAntiNoiseFacilitiesData.class);
        condition.createCriteria().andEqualTo("relationId", recordAntiNoiseFacilities.getId());
        List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList = this.recordAntiNoiseFacilitiesDataService.selectByCondition(condition);
        if (recordAntiNoiseFacilitiesDataList != null && recordAntiNoiseFacilitiesDataList.size() > 0 ) {
            for ( RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData : recordAntiNoiseFacilitiesDataList) {
                this.recordAntiNoiseFacilitiesDataService.deleteByPrimaryKey(recordAntiNoiseFacilitiesData.getId());
            }
        }
        recordAntiNoiseFacilitiesDataList = new LinkedList<>();
        if (recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList() != null){
            for (RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData : recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList()) {
                recordAntiNoiseFacilitiesData.setRelationId(recordAntiNoiseFacilities.getId());
                recordAntiNoiseFacilitiesDataList.add(recordAntiNoiseFacilitiesData);
            }
            this.recordAntiNoiseFacilitiesDataService.insertList(recordAntiNoiseFacilitiesDataList);
        }
    }

    @Override
    public RecordAntiNoiseDetailResponse queryAntiNoiseDetail(Long id) {
        RecordAntiNoiseDetailResponse response = new RecordAntiNoiseDetailResponse();
        Map<String, Object> map = this.recordAntiNoiseFacilitiesMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordAntiNoiseFacilities(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordAntiNoiseFacilitiesDataService.queryRecordDataByAntiNoise(recordId);
            response.setRecordAntiNoiseFacilitiesDataList(mapList);
        }
        return response;
    }
}
