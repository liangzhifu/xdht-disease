package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordHazardFactorsMapper;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordHazardFactorsDataService;
import com.xdht.disease.sys.service.RecordHazardFactorsService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsInputRequest;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;
import com.xdht.disease.sys.vo.response.RecordHazardFactorsDetailResponse;
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
public class RecordHazardFactorsServiceImpl extends AbstractService<RecordHazardFactors> implements RecordHazardFactorsService{

    @Autowired
    private RecordHazardFactorsMapper recordHazardFactorsMapper;

    @Autowired
    private RecordHazardFactorsDataService recordHazardFactorsDataService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordHazardFactors> queryListPage(RecordHazardFactorsRequest recordHazardFactorsRequest) {
        Condition condition = new Condition(RecordHazardFactors.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsRequest.getId());
        if (recordHazardFactorsRequest.getHazardFactorsNo() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactorsNo","%"+recordHazardFactorsRequest.getHazardFactorsNo()+"%");
        }
        if (recordHazardFactorsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHazardFactorsRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordHazardFactorsRequest.getPageNumber(), recordHazardFactorsRequest.getPageSize());
        List<RecordHazardFactors> dataList = this.recordHazardFactorsMapper.selectByCondition(condition);
        Integer count = this.recordHazardFactorsMapper.selectCountByCondition(condition);
        PageResult<RecordHazardFactors> pageList = new  PageResult<RecordHazardFactors>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;

    }

    @Override
    public void add(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest) {
        RecordHazardFactors  recordHazardFactors =  recordHazardFactorsInputRequest.getRecordHazardFactors();
        recordHazardFactors.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordHazardFactors);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordHazardFactorsInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordHazardFactorsInputRequest.getRecordHazardFactors().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordHazardFactorsData> recordHazardFactorsDataList = new LinkedList<>();
        if (recordHazardFactorsInputRequest.getRecordHazardFactorsDataList() != null ) {
            for ( RecordHazardFactorsData recordHazardFactorsData : recordHazardFactorsInputRequest.getRecordHazardFactorsDataList()) {
                recordHazardFactorsData.setRelationId(recordHazardFactors.getId());
                recordHazardFactorsDataList.add(recordHazardFactorsData);
            }
            this.recordHazardFactorsDataService.insertList(recordHazardFactorsDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordHazardFactors recordHazardFactors = new RecordHazardFactors();
        recordHazardFactors.setId(id);
        recordHazardFactors.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordHazardFactorsMapper.updateByPrimaryKeySelective(recordHazardFactors);
    }

    @Override
    public void update(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest) {
        RecordHazardFactors recordHazardFactors = recordHazardFactorsInputRequest.getRecordHazardFactors();
        this.recordHazardFactorsMapper.updateByPrimaryKeySelective(recordHazardFactors);

        Condition condition = new Condition(RecordHazardFactorsData.class);
        condition.createCriteria().andEqualTo("relationId", recordHazardFactors.getId());
        List<RecordHazardFactorsData> recordHazardFactorsDataList = this.recordHazardFactorsDataService.selectByCondition(condition);
       if (recordHazardFactorsDataList != null && recordHazardFactorsDataList.size() > 0 ) {

           for ( RecordHazardFactorsData recordHazardFactorsData : recordHazardFactorsDataList ) {
               this.recordHazardFactorsDataService.deleteByPrimaryKey(recordHazardFactorsData.getId());
           }
       }
       recordHazardFactorsDataList = new LinkedList<>();
        if (recordHazardFactorsInputRequest.getRecordHazardFactorsDataList() != null ){
            for (RecordHazardFactorsData recordHazardFactorsData : recordHazardFactorsInputRequest.getRecordHazardFactorsDataList()) {
                recordHazardFactorsData.setRelationId(recordHazardFactors.getId());
                recordHazardFactorsDataList.add(recordHazardFactorsData);
            }
            this.recordHazardFactorsDataService.insertList(recordHazardFactorsDataList);
        }
    }

    @Override
    public RecordHazardFactorsDetailResponse queryHazardFactorsDetail(Long id) {
        RecordHazardFactorsDetailResponse response = new RecordHazardFactorsDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordHazardFactorsMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordHazardFactors(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordHazardFactorsDataService.queryRecordDataByHazardFactors(recordId);
            response.setRecordHazardFactorsDataList(mapList);
        }
        return response;
    }
}
