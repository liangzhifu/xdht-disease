package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordTemperatureProtectionFacilitiesMapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesDataService;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordTemperatureInputRequest;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordTemperatureDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class RecordTemperatureProtectionFacilitiesServiceImpl extends AbstractService<RecordTemperatureProtectionFacilities> implements RecordTemperatureProtectionFacilitiesService{

    @Autowired
    private RecordTemperatureProtectionFacilitiesMapper recordMapper;

    @Autowired
    private RecordTemperatureProtectionFacilitiesDataService recordTemperatureDataService;

    @Override
    public List<RecordTemperatureProtectionFacilities> queryList(RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordTemperatureProtectionFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("temperatureProtectionFacilitiesNo",recordRequest.getTemperatureProtectionFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordTemperatureProtectionFacilities> queryListPage(RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordTemperatureProtectionFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());

        if (recordRequest.getTemperatureProtectionFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("temperatureProtectionFacilitiesNo","%"+recordRequest.getTemperatureProtectionFacilitiesNo()+"%");
        }
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordTemperatureProtectionFacilities> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordTemperatureProtectionFacilities> pageList = new  PageResult<RecordTemperatureProtectionFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordTemperatureProtectionFacilities add(RecordTemperatureInputRequest recordTemperatureInputRequest) {
        RecordTemperatureProtectionFacilities recordTemperature = recordTemperatureInputRequest.getRecordTemperature();
        recordTemperature.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordMapper.insertUseGeneratedKeys(recordTemperature);
        List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList = new LinkedList<>();
        for ( RecordTemperatureProtectionFacilitiesData recordTemperatureData : recordTemperatureInputRequest.getRecordTemperatureDataList()) {
            recordTemperatureData.setRelationId(recordTemperature.getId());
            recordTemperatureDataList.add(recordTemperatureData);
        }
        if (recordTemperatureDataList.size()>0){
            this.recordTemperatureDataService.insertList(recordTemperatureDataList);
        }
        return recordTemperature;
    }

    @Override
    public RecordTemperatureProtectionFacilities delete(Long id) {
        RecordTemperatureProtectionFacilities record = this.recordMapper.selectByPrimaryKey(id);
        record.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(record);
        return  record;
    }

    @Override
    public RecordTemperatureProtectionFacilities update(RecordTemperatureInputRequest recordTemperatureInputRequest) {

        RecordTemperatureProtectionFacilities recordTemperature = recordTemperatureInputRequest.getRecordTemperature();
        this.recordMapper.updateByPrimaryKeySelective(recordTemperature);
        List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList = new LinkedList<>();
        for ( RecordTemperatureProtectionFacilitiesData recordTemperatureData: recordTemperatureInputRequest.getRecordTemperatureDataList() ) {
            if (recordTemperatureData.getId() == null){
                recordTemperatureData.setRelationId(recordTemperature.getId());
                recordTemperatureDataList.add(recordTemperatureData);
            }
            this.recordTemperatureDataService.updateByPrimaryKeySelective(recordTemperatureData);
        }
        if (recordTemperatureDataList.size()>0){
            this.recordTemperatureDataService.insertList(recordTemperatureDataList);
        }
        return recordTemperature;

    }

    @Override
    public RecordTemperatureDetailResponse queryTemperatureDetail(Long id) {
        RecordTemperatureDetailResponse response = new RecordTemperatureDetailResponse();
        RecordTemperatureProtectionFacilities recordTemperature = this.selectByPrimaryKey(id);
        response.setRecordTemperature(recordTemperature);
        Condition condition = new Condition(RecordTemperatureProtectionFacilitiesData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList = this.recordTemperatureDataService.selectByCondition(condition);
        response.setRecordTemperatureDataList(recordTemperatureDataList);
        return response;
    }
}
