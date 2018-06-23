package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordIndividualProtectiveEquipmentMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentDataService;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentRequest;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualProtectiveDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


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

    @Override
    public List<RecordIndividualProtectiveEquipment> queryList(RecordIndividualProtectiveEquipmentRequest recordRequest) {
        Condition condition = new Condition(RecordIndividualProtectiveEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("individualProtectiveEquipmentNo",recordRequest.getIndividualProtectiveEquipmentNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

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
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordIndividualProtectiveEquipment> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordIndividualProtectiveEquipment> pageList = new  PageResult<RecordIndividualProtectiveEquipment>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordIndividualProtectiveEquipment add(RecordIndividualProtectiveInputRequest recordIndividualProtectiveInputRequest) {
        RecordIndividualProtectiveEquipment recordIndividualProtective = recordIndividualProtectiveInputRequest.getRecordIndividualProtective();
        recordIndividualProtective.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordIndividualProtective);
        List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList = new LinkedList<>();
        for ( RecordIndividualProtectiveEquipmentData recordIndividualProtectiveData :  recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList()) {
            recordIndividualProtectiveData.setRelationId(recordIndividualProtective.getId());
            recordIndividualProtectiveDataList.add(recordIndividualProtectiveData);
        }
        if (recordIndividualProtectiveDataList.size()>0){
            this.recordIndividualProtectiveEquipmentDataService.insertList(recordIndividualProtectiveDataList);
        }
        return  recordIndividualProtective;
    }

    @Override
    public RecordIndividualProtectiveEquipment delete(Long id) {
        RecordIndividualProtectiveEquipment recordIndividualProtectiveEquipment = this.recordMapper.selectByPrimaryKey(id);
        recordIndividualProtectiveEquipment.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        return recordIndividualProtectiveEquipment;
    }

    @Override
    public RecordIndividualProtectiveEquipment update(RecordIndividualProtectiveInputRequest recordIndividualProtectiveInputRequest) {
        RecordIndividualProtectiveEquipment recordIndividualProtective = recordIndividualProtectiveInputRequest.getRecordIndividualProtective();
        this.recordMapper.updateByPrimaryKeySelective(recordIndividualProtective);
        List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList = new LinkedList<>();
        for ( RecordIndividualProtectiveEquipmentData recordIndividualProtectiveData: recordIndividualProtectiveInputRequest.getRecordIndividualProtectiveDataList() ) {
            if (recordIndividualProtectiveData.getId() == null){
                recordIndividualProtectiveData.setRelationId(recordIndividualProtective.getId());
                recordIndividualProtectiveDataList.add(recordIndividualProtectiveData);
            }
            this.recordIndividualProtectiveEquipmentDataService.updateByPrimaryKeySelective(recordIndividualProtectiveData);
        }
        if (recordIndividualProtectiveDataList.size()>0){
            this.recordIndividualProtectiveEquipmentDataService.insertList(recordIndividualProtectiveDataList);
        }
        return recordIndividualProtective;
    }

    @Override
    public RecordIndividualProtectiveDetailResponse queryIndividualProtetiveDetail(Long id) {
        RecordIndividualProtectiveDetailResponse response = new RecordIndividualProtectiveDetailResponse();
        RecordIndividualProtectiveEquipment recordIndividualProtective = new RecordIndividualProtectiveEquipment();
        recordIndividualProtective.setSceneId(id);
        recordIndividualProtective = this.recordMapper.selectOne(recordIndividualProtective);
        if (recordIndividualProtective != null){
            Long recordId = recordIndividualProtective.getId();
            response.setRecordIndividualProtective(recordIndividualProtective);
            Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
            condition.createCriteria() .andEqualTo("relationId", recordId);
            List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList = this.recordIndividualProtectiveEquipmentDataService.selectByCondition(condition);
            response.setRecordIndividualProtectiveDataList(recordIndividualProtectiveDataList);
        }
        return response;
    }
}
