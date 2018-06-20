package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordHazardFactorsMapper;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.service.RecordHazardFactorsDataService;
import com.xdht.disease.sys.service.RecordHazardFactorsService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsInputRequest;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;
import com.xdht.disease.sys.vo.response.RecordHazardFactorsDetailResponse;
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
public class RecordHazardFactorsServiceImpl extends AbstractService<RecordHazardFactors> implements RecordHazardFactorsService{

    @Autowired
    private RecordHazardFactorsMapper recordHazardFactorsMapper;

    @Autowired
    private RecordHazardFactorsDataService recordHazardFactorsDataService;

    @Override
    public List<RecordHazardFactors> queryList(RecordHazardFactorsRequest recordHazardFactorsRequest) {
        Condition condition = new Condition(RecordHazardFactors.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsRequest.getId())
                .andEqualTo("hazardFactorsNo",recordHazardFactorsRequest.getHazardFactorsNo());
        if (recordHazardFactorsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHazardFactorsRequest.getVerificationResult()+"%");
        }
        if (recordHazardFactorsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHazardFactorsRequest.getStatus());
        }
        return this.recordHazardFactorsMapper.selectByCondition(condition);
    }

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
        if (recordHazardFactorsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHazardFactorsRequest.getStatus());
        }
        PageHelper.startPage(recordHazardFactorsRequest.getPageNumber(), recordHazardFactorsRequest.getPageSize());
        List<RecordHazardFactors> dataList = this.recordHazardFactorsMapper.selectByCondition(condition);
        Integer count = this.recordHazardFactorsMapper.selectCountByCondition(condition);
        PageResult<RecordHazardFactors> pageList = new  PageResult<RecordHazardFactors>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;

    }

    @Override
    public RecordHazardFactors add(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest) {
            RecordHazardFactors  recordHazardFactors =  new RecordHazardFactors();
            recordHazardFactors.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            recordHazardFactors.setHazardFactorsNo(recordHazardFactorsInputRequest.getRecordHazardFactors().getHazardFactorsNo());
            recordHazardFactors.setVerificationResult(recordHazardFactorsInputRequest.getRecordHazardFactors().getVerificationResult());
            this.insertUseGeneratedKeys(recordHazardFactors);
            List<RecordHazardFactorsData> recordHazardFactorsDataList = new LinkedList<>();
        for ( RecordHazardFactorsData recordHazardFactorsData : recordHazardFactorsInputRequest.getRecordHazardFactorsDataList()) {
                recordHazardFactorsData.setRelationId(recordHazardFactors.getId());
                recordHazardFactorsDataList.add(recordHazardFactorsData);
        }
            this.recordHazardFactorsDataService.insertList(recordHazardFactorsDataList);
            return recordHazardFactors;
    }

    @Override
    public RecordHazardFactors delete(Long id) {
        RecordHazardFactors recordHazardFactors =this.recordHazardFactorsMapper.selectByPrimaryKey(id);
        recordHazardFactors.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordHazardFactorsMapper.updateByPrimaryKeySelective(recordHazardFactors);
        return  recordHazardFactors;
    }

    @Override
    public RecordHazardFactors update(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest) {
        RecordHazardFactors recordHazardFactors = recordHazardFactorsInputRequest.getRecordHazardFactors();
        this.recordHazardFactorsMapper.updateByPrimaryKeySelective(recordHazardFactors);
        List<RecordHazardFactorsData> recordHazardFactorsDataList = new LinkedList<>();
        for ( RecordHazardFactorsData recordHazardFactorsData : recordHazardFactorsInputRequest.getRecordHazardFactorsDataList() ) {
            if (recordHazardFactorsData.getId() == null ){
                recordHazardFactorsData.setRelationId(recordHazardFactors.getId());
                recordHazardFactorsDataList.add(recordHazardFactorsData);
            }
            this.recordHazardFactorsDataService.updateByPrimaryKeySelective(recordHazardFactorsData);
        }
        if (recordHazardFactorsDataList.size()>0){
            this.recordHazardFactorsDataService.insertList(recordHazardFactorsDataList);
        }
        return recordHazardFactors;
    }

    @Override
    public RecordHazardFactorsDetailResponse queryHazardFactorsDetail(Long id) {
        RecordHazardFactorsDetailResponse response = new RecordHazardFactorsDetailResponse();
        RecordHazardFactors recordHazardFactors = this.selectByPrimaryKey(id);
        response.setRecordHazardFactors(recordHazardFactors);
        Condition condition = new Condition(RecordHazardFactorsData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordHazardFactorsData> recordHazardFactorsDataList = this.recordHazardFactorsDataService.selectByCondition(condition);
        response.setRecordHazardFactorsDataList(recordHazardFactorsDataList);
        return response;
    }
}
