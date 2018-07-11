package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordHealthManagementMapper;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordHealthManagementDataService;
import com.xdht.disease.sys.service.RecordHealthManagementService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementInputRequest;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;
import com.xdht.disease.sys.vo.response.RecordHealthManagementDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordHealthManagementServiceImpl extends AbstractService<RecordHealthManagement> implements RecordHealthManagementService{

    @Autowired
    private RecordHealthManagementMapper recordHealthManagementMapper;

    @Autowired
    private RecordHealthManagementDataService recordHealthManagementDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public List<RecordHealthManagement> queryList(RecordHealthManagementRequest recordHealthManagementRequest) {

        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId())
                .andEqualTo("healthManagementNo",recordHealthManagementRequest.getHealthManagementNo());
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
        if (recordHealthManagementRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthManagementRequest.getStatus());
        }
        return this.recordHealthManagementMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHealthManagement> queryListPage(RecordHealthManagementRequest recordHealthManagementRequest) {
        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId());
        if (recordHealthManagementRequest.getHealthManagementNo() != null) {
            condition.getOredCriteria().get(0).andLike("healthManagementNo","%"+recordHealthManagementRequest.getHealthManagementNo()+"%");
        }
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
            condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordHealthManagementRequest.getPageNumber(), recordHealthManagementRequest.getPageSize());
        List<RecordHealthManagement> dataList = this.recordHealthManagementMapper.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<RecordHealthManagement> pageList = new  PageResult<RecordHealthManagement>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordHealthManagementInputRequest recordHealthManagementInputRequest) {
        RecordHealthManagement recordHealthManagement = recordHealthManagementInputRequest.getRecordHealthManagement();
        recordHealthManagement.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordHealthManagement);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordHealthManagementInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordHealthManagementInputRequest.getRecordHealthManagement().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordHealthManagementData> recordHealthManagementDataList = new LinkedList<>();
        for ( RecordHealthManagementData recordHealthManagementData :  recordHealthManagementInputRequest.getRecordHealthManagementDataList()) {
            recordHealthManagementData.setHealthManagementId(recordHealthManagement.getId());
            recordHealthManagementDataList.add(recordHealthManagementData);
        }
        if (recordHealthManagementDataList.size()>0){
            this.recordHealthManagementDataService.insertList(recordHealthManagementDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordHealthManagement recordHealthManagement = new RecordHealthManagement();
        recordHealthManagement.setId(id);
        recordHealthManagement.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(recordHealthManagement);
    }

    @Override
    public void update(RecordHealthManagementInputRequest recordHealthManagementInputRequest) {

        RecordHealthManagement recordHealthManagement = recordHealthManagementInputRequest.getRecordHealthManagement();
        this.updateByPrimaryKeySelective(recordHealthManagement);

        List<RecordHealthManagementData> recordHealthManagementDataList = new LinkedList<>();
        for (RecordHealthManagementData recordHealthManagementData : recordHealthManagementInputRequest.getRecordHealthManagementDataList() ) {
            if (recordHealthManagementData.getId() == null){
                recordHealthManagementData.setHealthManagementId(recordHealthManagement.getId());
                recordHealthManagementDataList.add(recordHealthManagementData);
            }
            this.recordHealthManagementDataService.updateByPrimaryKeySelective(recordHealthManagementData);
        }
        if (recordHealthManagementDataList.size()>0){
            this.recordHealthManagementDataService.insertList(recordHealthManagementDataList);
        }
    }

    @Override
    public RecordHealthManagementDetailResponse queryRecordHealthManagementDetail(Long id) {
        RecordHealthManagementDetailResponse recordHealthManagementDetailResponse = new RecordHealthManagementDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordHealthManagementMapper.selectRecordBySceneId(id);
        if (map != null){
            recordHealthManagementDetailResponse.setRecordHealthManagement(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordHealthManagementDataService.queryRecordDataByHealthManagementId(recordId);
            recordHealthManagementDetailResponse.setRecordHealthManagementDataList(mapList);
        }
        return recordHealthManagementDetailResponse;
    }

}
