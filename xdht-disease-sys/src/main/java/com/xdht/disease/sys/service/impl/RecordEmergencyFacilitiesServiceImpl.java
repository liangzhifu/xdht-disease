package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEmergencyFacilitiesMapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesDataService;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesInputRequest;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordEmergencyFacilitiesDetailResponse;
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
public class RecordEmergencyFacilitiesServiceImpl extends AbstractService<RecordEmergencyFacilities> implements RecordEmergencyFacilitiesService{

    @Autowired
    private RecordEmergencyFacilitiesMapper recordEmergencyFacilitiesMapper;
    @Autowired
    private RecordEmergencyFacilitiesDataService recordEmergencyFacilitiesDataService;
    @Override
    public List<RecordEmergencyFacilities> queryList(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        Condition condition = new Condition(RecordEmergencyFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesRequest.getId())
                .andEqualTo("emergencyFacilitiesNo",recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo());
        if (recordEmergencyFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEmergencyFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEmergencyFacilitiesRequest.getStatus());
        }
        return this.recordEmergencyFacilitiesMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEmergencyFacilities> queryListPage(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        Condition condition = new Condition(RecordEmergencyFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesRequest.getId());
        if (recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("emergencyFacilitiesNo","%"+recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEmergencyFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEmergencyFacilitiesRequest.getStatus());
        }
        PageHelper.startPage(recordEmergencyFacilitiesRequest.getPageNumber(), recordEmergencyFacilitiesRequest.getPageSize());
        List<RecordEmergencyFacilities> dataList = this.recordEmergencyFacilitiesMapper.selectByCondition(condition);
        Integer count = this.recordEmergencyFacilitiesMapper.selectCountByCondition(condition);
        PageResult<RecordEmergencyFacilities> pageList = new  PageResult<RecordEmergencyFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEmergencyFacilities add(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest) {
        RecordEmergencyFacilities recordEmergencyFacilities = recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilities();
        recordEmergencyFacilities.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordEmergencyFacilities);
        List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList = new LinkedList<>();
        for ( RecordEmergencyFacilitiesData recordEmergencyFacilitiesData : recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList()) {
            recordEmergencyFacilitiesData.setRelationId(recordEmergencyFacilities.getId());
            recordEmergencyFacilitiesDataList.add(recordEmergencyFacilitiesData);
        }
        if (recordEmergencyFacilitiesDataList.size()>0){
            this.recordEmergencyFacilitiesDataService.insertList(recordEmergencyFacilitiesDataList);
        }
        return recordEmergencyFacilities;
    }

    @Override
    public RecordEmergencyFacilities delete(Long id) {
        RecordEmergencyFacilities recordEmergencyFacilities = this.recordEmergencyFacilitiesMapper.selectByPrimaryKey(id);
        recordEmergencyFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEmergencyFacilitiesMapper.updateByPrimaryKeySelective(recordEmergencyFacilities);
        return  recordEmergencyFacilities;
    }

    @Override
    public RecordEmergencyFacilities update(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest) {
        RecordEmergencyFacilities recordEmergencyFacilities = recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilities();
        this.recordEmergencyFacilitiesMapper.updateByPrimaryKeySelective(recordEmergencyFacilities);
        List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList = new LinkedList<>();
        for ( RecordEmergencyFacilitiesData recordEmergencyFacilitiesData: recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList() ) {
            if (recordEmergencyFacilitiesData.getId() == null){
                recordEmergencyFacilitiesData.setRelationId(recordEmergencyFacilities.getId());
                recordEmergencyFacilitiesDataList.add(recordEmergencyFacilitiesData);
            }
            this.recordEmergencyFacilitiesDataService.updateByPrimaryKeySelective(recordEmergencyFacilitiesData);
        }
        if (recordEmergencyFacilitiesDataList.size()>0){
            this.recordEmergencyFacilitiesDataService.insertList(recordEmergencyFacilitiesDataList);
        }
        return recordEmergencyFacilities;
    }

    @Override
    public RecordEmergencyFacilitiesDetailResponse queryEmergencyFacilitiesDetail(Long id) {
        RecordEmergencyFacilitiesDetailResponse response = new RecordEmergencyFacilitiesDetailResponse();
        RecordEmergencyFacilities recordEmergencyFacilities = this.recordEmergencyFacilitiesMapper.selectByPrimaryKey(id);
        response.setRecordEmergencyFacilities(recordEmergencyFacilities);
        Condition condition = new Condition(RecordEmergencyFacilitiesData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList = this.recordEmergencyFacilitiesDataService.selectByCondition(condition);
        response.setRecordEmergencyFacilitiesDataList(recordEmergencyFacilitiesDataList);
        return response;
    }
}
