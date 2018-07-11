package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordOtherProtectiveFacilitiesMapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesDataService;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordOtherProtectiveDetailResponse;
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
public class RecordOtherProtectiveFacilitiesServiceImpl extends AbstractService<RecordOtherProtectiveFacilities> implements RecordOtherProtectiveFacilitiesService{

    @Autowired
    private RecordOtherProtectiveFacilitiesMapper recordMapper;

    @Autowired
    private RecordOtherProtectiveFacilitiesDataService recordOtherProtectiveFacilitiesDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordOtherProtectiveFacilities> queryListPage(RecordOtherProtectiveFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordOtherProtectiveFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());
        if (recordRequest.getOtherProtectiveFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("otherProtectiveFacilitiesNo","%"+recordRequest.getOtherProtectiveFacilitiesNo()+"%");
        }
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordOtherProtectiveFacilities> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordOtherProtectiveFacilities> pageList = new  PageResult<RecordOtherProtectiveFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {

        RecordOtherProtectiveFacilities recordOtherProtective = recordOtherProtectiveInputRequest.getRecordOtherProtective();
        recordOtherProtective.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordMapper.insertUseGeneratedKeys(recordOtherProtective);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordOtherProtectiveInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordOtherProtectiveInputRequest.getRecordOtherProtective().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList = new LinkedList<>();
        if (recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList() != null ) {
            for ( RecordOtherProtectiveFacilitiesData recordOtherProtectiveData : recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList()) {
                recordOtherProtectiveData.setRelationId(recordOtherProtective.getId());
                recordOtherProtectiveDataList.add(recordOtherProtectiveData);
            }
            this.recordOtherProtectiveFacilitiesDataService.insertList(recordOtherProtectiveDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordOtherProtectiveFacilities recordOtherProtectiveFacilities = new RecordOtherProtectiveFacilities();
        recordOtherProtectiveFacilities.setId(id);
        recordOtherProtectiveFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(recordOtherProtectiveFacilities);
    }

    @Override
    public void update(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {

        RecordOtherProtectiveFacilities recordOtherProtective = recordOtherProtectiveInputRequest.getRecordOtherProtective();
        this.recordMapper.updateByPrimaryKeySelective(recordOtherProtective);

        Condition condition = new Condition(RecordOtherProtectiveFacilitiesData.class);
        condition.createCriteria().andEqualTo("relationId", recordOtherProtective.getId());
        List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList = this.recordOtherProtectiveFacilitiesDataService.selectByCondition(condition);
        if (recordOtherProtectiveDataList != null && recordOtherProtectiveDataList.size() > 0 ) {
            for ( RecordOtherProtectiveFacilitiesData recordOtherProtectiveData: recordOtherProtectiveDataList) {
                this.recordOtherProtectiveFacilitiesDataService.deleteByPrimaryKey(recordOtherProtectiveData.getId());
            }
        }
        recordOtherProtectiveDataList = new LinkedList<>();
        if (recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList() != null){
            for (RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData : recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList()) {
                recordOtherProtectiveFacilitiesData.setRelationId(recordOtherProtective.getId());
                recordOtherProtectiveDataList.add(recordOtherProtectiveFacilitiesData);
            }
            this.recordOtherProtectiveFacilitiesDataService.insertList(recordOtherProtectiveDataList);
        }
    }

    @Override
    public RecordOtherProtectiveDetailResponse queryOtherProtetiveDetail(Long id) {
        RecordOtherProtectiveDetailResponse response = new RecordOtherProtectiveDetailResponse();
        Map<String, Object> map = this.recordMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordOtherProtective(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordOtherProtectiveFacilitiesDataService.queryRecordDataByOtherProtective(recordId);
            response.setRecordOtherProtectiveDataList(mapList);
        }
        return response;
    }
}
