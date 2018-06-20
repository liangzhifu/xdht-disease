package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordAntiNoiseFacilitiesMapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesDataService;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseInputRequest;
import com.xdht.disease.sys.vo.response.RecordAntiNoiseDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


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

    @Override
    public List<RecordAntiNoiseFacilities> queryList(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        Condition condition =  new Condition(RecordAntiNoiseFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesRequest.getId())
                .andEqualTo("antiNoiseFacilitiesNo",recordAntiNoiseFacilitiesRequest.getAntiNoiseFacilitiesNo());
        if (recordAntiNoiseFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAntiNoiseFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordAntiNoiseFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAntiNoiseFacilitiesRequest.getStatus());
        }
        return this.recordAntiNoiseFacilitiesMapper.selectByCondition(condition);
    }

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
        if (recordAntiNoiseFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAntiNoiseFacilitiesRequest.getStatus());
        }
        PageHelper.startPage(recordAntiNoiseFacilitiesRequest.getPageNumber(), recordAntiNoiseFacilitiesRequest.getPageSize());
        List<RecordAntiNoiseFacilities> dataList = this.recordAntiNoiseFacilitiesMapper.selectByCondition(condition);
        Integer count = this.recordAntiNoiseFacilitiesMapper.selectCountByCondition(condition);
        PageResult<RecordAntiNoiseFacilities> pageList = new  PageResult<RecordAntiNoiseFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordAntiNoiseFacilities addRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {
            RecordAntiNoiseFacilities recordAntiNoiseFacilities = recordAntiNoiseInputRequest.getRecordAntiNoiseFacilities();
            recordAntiNoiseFacilities.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            this.insertUseGeneratedKeys(recordAntiNoiseFacilities);
            List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList = new LinkedList<>();
        for ( RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData : recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList()) {
            recordAntiNoiseFacilitiesData.setRelationId(recordAntiNoiseFacilities.getId());
            recordAntiNoiseFacilitiesDataList.add(recordAntiNoiseFacilitiesData);
        }
        this.recordAntiNoiseFacilitiesDataService.insertList(recordAntiNoiseFacilitiesDataList);
        return recordAntiNoiseFacilities;
    }

    @Override
    public RecordAntiNoiseFacilities deleteRecordAntiNoiseFacilities(Long id) {
            RecordAntiNoiseFacilities recordAntiNoiseFacilities = this.recordAntiNoiseFacilitiesMapper.selectByPrimaryKey(id);
            recordAntiNoiseFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.recordAntiNoiseFacilitiesMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilities);
            return recordAntiNoiseFacilities;
    }

    @Override
    public RecordAntiNoiseFacilities updateRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest) {

        RecordAntiNoiseFacilities recordAntiNoiseFacilities = recordAntiNoiseInputRequest.getRecordAntiNoiseFacilities();
        this.recordAntiNoiseFacilitiesMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilities);
        List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList = new LinkedList<>();
        for ( RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData : recordAntiNoiseInputRequest.getRecordAntiNoiseFacilitiesDataList() ) {
            if (recordAntiNoiseFacilitiesData.getId() == null ){
                recordAntiNoiseFacilitiesData.setRelationId(recordAntiNoiseFacilities.getId());
                recordAntiNoiseFacilitiesDataList.add(recordAntiNoiseFacilitiesData);
            }
            this.recordAntiNoiseFacilitiesDataService.updateByPrimaryKeySelective(recordAntiNoiseFacilitiesData);
        }
        if (recordAntiNoiseFacilitiesDataList.size()>0){
            this.recordAntiNoiseFacilitiesDataService.insertList(recordAntiNoiseFacilitiesDataList);
        }
        return recordAntiNoiseFacilities;
    }

    @Override
    public RecordAntiNoiseDetailResponse queryAntiNoiseDetail(Long id) {
        RecordAntiNoiseDetailResponse response = new RecordAntiNoiseDetailResponse();
        RecordAntiNoiseFacilities recordAntiNoiseFacilities = this.selectByPrimaryKey(id);
        response.setRecordAntiNoiseFacilities(recordAntiNoiseFacilities);
        Condition condition = new Condition(RecordAntiNoiseFacilitiesData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList = this.recordAntiNoiseFacilitiesDataService.selectByCondition(condition);
        response.setRecordAntiNoiseFacilitiesDataList(recordAntiNoiseFacilitiesDataList);
        return response;
    }
}
