package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordIndividualProtectiveEquipmentMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentDataService;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentRequest;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualProtectiveDetailResponse;
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
public class RecordIndividualProtectiveEquipmentServiceImpl extends AbstractService<RecordIndividualProtectiveEquipment> implements RecordIndividualProtectiveEquipmentService{

    @Autowired
    private RecordIndividualProtectiveEquipmentMapper recordMapper;
    @Autowired
    private RecordIndividualProtectiveEquipmentDataService recordIndividualProtectiveEquipmentDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordIndividualProtectiveEquipment> queryListPage(RecordIndividualProtectiveEquipmentRequest recordRequest) {

        Condition condition = new Condition(RecordIndividualProtectiveEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());
        if (recordRequest.getIndividualProtectiveEquipmentNo() != null) {
            condition.getOredCriteria().get(0).andLike("individualProtectiveEquipmentNo","%"+recordRequest.getIndividualProtectiveEquipmentNo()+"%");
        }
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordIndividualProtectiveEquipment> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordIndividualProtectiveEquipment> pageList = new  PageResult<RecordIndividualProtectiveEquipment>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordIndividualProtectiveInputRequest recordIndividualProtectiveInputRequest) {
        RecordIndividualProtectiveEquipment recordIndividualProtective = recordIndividualProtectiveInputRequest.getRecordIndividualProtective();
        recordIndividualProtective.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordIndividualProtective);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordIndividualProtectiveInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordIndividualProtectiveInputRequest.getRecordIndividualProtective().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList = new LinkedList<>();
        if (recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList() != null) {
            for ( RecordIndividualProtectiveEquipmentData recordIndividualProtectiveData :  recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList()) {
                recordIndividualProtectiveData.setRelationId(recordIndividualProtective.getId());
                recordIndividualProtectiveDataList.add(recordIndividualProtectiveData);
            }
                this.recordIndividualProtectiveEquipmentDataService.insertList(recordIndividualProtectiveDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordIndividualProtectiveEquipment recordIndividualProtectiveEquipment = new RecordIndividualProtectiveEquipment();
        recordIndividualProtectiveEquipment.setId(id);
        recordIndividualProtectiveEquipment.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(recordIndividualProtectiveEquipment);
    }

    @Override
    public void update(RecordIndividualProtectiveInputRequest recordIndividualProtectiveInputRequest) {
        RecordIndividualProtectiveEquipment recordIndividualProtective = recordIndividualProtectiveInputRequest.getRecordIndividualProtective();
        this.recordMapper.updateByPrimaryKeySelective(recordIndividualProtective);

        Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
        condition.createCriteria().andEqualTo("relationId", recordIndividualProtective.getId());
        List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList = this.recordIndividualProtectiveEquipmentDataService.selectByCondition(condition);
        if (recordIndividualProtectiveDataList != null && recordIndividualProtectiveDataList.size() > 0 ) {
            for ( RecordIndividualProtectiveEquipmentData recordIndividualProtectiveData : recordIndividualProtectiveDataList ) {
                this.recordIndividualProtectiveEquipmentDataService.deleteByPrimaryKey(recordIndividualProtectiveData.getId());
            }
        }
        recordIndividualProtectiveDataList = new LinkedList<>();
        if (recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList() != null){
            for (RecordIndividualProtectiveEquipmentData recordIndividualProtectiveEquipmentData : recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList()) {
                recordIndividualProtectiveEquipmentData.setRelationId(recordIndividualProtective.getId());
                recordIndividualProtectiveDataList.add(recordIndividualProtectiveEquipmentData);
            }
            this.recordIndividualProtectiveEquipmentDataService.insertList(recordIndividualProtectiveDataList);
        }
    }

    @Override
    public RecordIndividualProtectiveDetailResponse queryIndividualProtetiveDetail(Long id) {
        RecordIndividualProtectiveDetailResponse response = new RecordIndividualProtectiveDetailResponse();
        Map<String, Object> map = this.recordMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordIndividualProtective(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordIndividualProtectiveEquipmentDataService.queryRecordDataByIndividualProtective(recordId);
            response.setRecordIndividualProtectiveDataList(mapList);
        }
        return response;
    }
}
