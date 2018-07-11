package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEquipmentMapper;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordEquipmentDataService;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.RecordEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentDetailResponse;
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
public class RecordEquipmentServiceImpl extends AbstractService<RecordEquipment> implements RecordEquipmentService{

    @Autowired
    private RecordEquipmentMapper recordEquipmentMapper;

    @Autowired
    private RecordEquipmentDataService recordEquipmentDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;


    @Override
    public PageResult<RecordEquipment> queryListPage(RecordEquipmentRequest recordEquipmentRequest) {
        Condition condition = new Condition(RecordEquipment.class);
        if (recordEquipmentRequest.getEquipmentNo() != null) {
            condition.createCriteria().andLike("equipmentNo","%"+recordEquipmentRequest.getEquipmentNo()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentRequest.getStatus());
        PageHelper.startPage(recordEquipmentRequest.getPageNumber(), recordEquipmentRequest.getPageSize());
        List<RecordEquipment> dataList = this.recordEquipmentMapper.selectByCondition(condition);
        Integer count = this.recordEquipmentMapper.selectCountByCondition(condition);
        PageResult<RecordEquipment> pageList = new  PageResult<RecordEquipment>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordEquipmentInputRequest recordEquipmentInputRequest) {
        RecordEquipment recordEquipment = recordEquipmentInputRequest.getRecordEquipment();
        recordEquipment.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordEquipment);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordEquipmentInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordEquipmentInputRequest.getRecordEquipment().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordEquipmentData> recordEquipmentDataList = new LinkedList<>();
        if (recordEquipmentInputRequest.getRecordEquipmentDataList() != null){
            for (RecordEquipmentData recordEquipmentData : recordEquipmentInputRequest.getRecordEquipmentDataList()) {
                recordEquipmentData.setRelationId(recordEquipment.getId());
                recordEquipmentDataList.add(recordEquipmentData);
            }
            this.recordEquipmentDataService.insertList(recordEquipmentDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordEquipment recordEquipment = new RecordEquipment();
        recordEquipment.setId(id);
        recordEquipment.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEquipmentMapper.updateByPrimaryKeySelective(recordEquipment);
    }

    @Override
    public void update(RecordEquipmentInputRequest recordEquipmentInputRequest) {
        RecordEquipment recordEquipment = recordEquipmentInputRequest.getRecordEquipment();
        this.recordEquipmentMapper.updateByPrimaryKeySelective(recordEquipment);

        Condition condition = new Condition(RecordEquipmentData.class);
        condition.createCriteria().andEqualTo("relationId", recordEquipment.getId());
        List<RecordEquipmentData> recordEquipmentDataList = this.recordEquipmentDataService.selectByCondition(condition);
        if (recordEquipmentDataList != null && recordEquipmentDataList.size() > 0) {
            for ( RecordEquipmentData recordEquipmentData :  recordEquipmentDataList ){
                this.recordEquipmentDataService.deleteByPrimaryKey(recordEquipmentData.getId());
            }
        }
        recordEquipmentDataList = new LinkedList<>();
        if (recordEquipmentInputRequest.getRecordEquipmentDataList() != null) {
            for (RecordEquipmentData recordEquipmentData : recordEquipmentInputRequest.getRecordEquipmentDataList()) {
                recordEquipmentData.setRelationId(recordEquipment.getId());
                recordEquipmentDataList.add(recordEquipmentData);
            }
            this.recordEquipmentDataService.insertList(recordEquipmentDataList);
        }
    }

    @Override
    public RecordEquipmentDetailResponse queryEquipmentDetail(Long id) {
        RecordEquipmentDetailResponse response = new RecordEquipmentDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordEquipmentMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordEquipment(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordEquipmentDataService.queryRecordDataByEquipment(recordId);
            response.setRecordEquipmentDataList(mapList);
        }
        return response;
    }
}
