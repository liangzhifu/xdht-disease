package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordOtherProtectiveFacilitiesMapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesDataService;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordOtherProtectiveDetailResponse;
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
public class RecordOtherProtectiveFacilitiesServiceImpl extends AbstractService<RecordOtherProtectiveFacilities> implements RecordOtherProtectiveFacilitiesService{

    @Autowired
    private RecordOtherProtectiveFacilitiesMapper recordMapper;

    @Autowired
    private RecordOtherProtectiveFacilitiesDataService recordOtherProtectiveFacilitiesDataService;

    @Override
    public List<RecordOtherProtectiveFacilities> queryList(RecordOtherProtectiveFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordOtherProtectiveFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("otherProtectiveFacilitiesNo",recordRequest.getOtherProtectiveFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

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
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordOtherProtectiveFacilities> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordOtherProtectiveFacilities> pageList = new  PageResult<RecordOtherProtectiveFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordOtherProtectiveFacilities add(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {

        RecordOtherProtectiveFacilities recordOtherProtective = recordOtherProtectiveInputRequest.getRecordOtherProtective();
        recordOtherProtective.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordMapper.insertUseGeneratedKeys(recordOtherProtective);
        List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList = new LinkedList<>();
        for ( RecordOtherProtectiveFacilitiesData recordOtherProtectiveData : recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList()) {
            recordOtherProtectiveData.setRelationId(recordOtherProtective.getId());
            recordOtherProtectiveDataList.add(recordOtherProtectiveData);
        }
        if (recordOtherProtectiveDataList.size()>0){
            this.recordOtherProtectiveFacilitiesDataService.insertList(recordOtherProtectiveDataList);
        }
        return recordOtherProtective;
    }

    @Override
    public RecordOtherProtectiveFacilities delete(Long id) {
        RecordOtherProtectiveFacilities recordOtherProtectiveFacilities = this.recordMapper.selectByPrimaryKey(id);
        recordOtherProtectiveFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(recordOtherProtectiveFacilities);
        return  recordOtherProtectiveFacilities;
    }

    @Override
    public RecordOtherProtectiveFacilities update(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest) {

        RecordOtherProtectiveFacilities recordOtherProtective = recordOtherProtectiveInputRequest.getRecordOtherProtective();
        this.recordMapper.updateByPrimaryKeySelective(recordOtherProtective);
        List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList = new LinkedList<>();
        for ( RecordOtherProtectiveFacilitiesData recordOtherProtectiveData: recordOtherProtectiveInputRequest.getRecordOtherProtectiveDataList() ) {
            if (recordOtherProtectiveData.getId() == null){
                recordOtherProtectiveData.setRelationId(recordOtherProtective.getId());
                recordOtherProtectiveDataList.add(recordOtherProtectiveData);
            }
            this.recordOtherProtectiveFacilitiesDataService.updateByPrimaryKeySelective(recordOtherProtectiveData);
        }
        if (recordOtherProtectiveDataList.size()>0){
            this.recordOtherProtectiveFacilitiesDataService.insertList(recordOtherProtectiveDataList);
        }
        return recordOtherProtective;
    }

    @Override
    public RecordOtherProtectiveDetailResponse queryOtherProtetiveDetail(Long id) {
        RecordOtherProtectiveDetailResponse response = new RecordOtherProtectiveDetailResponse();
        RecordOtherProtectiveFacilities recordOtherProtective = this.recordMapper.selectByPrimaryKey(id);
        response.setRecordOtherProtective(recordOtherProtective);
        Condition condition = new Condition(RecordOtherProtectiveFacilitiesData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList = this.recordOtherProtectiveFacilitiesDataService.selectByCondition(condition);
        response.setRecordOtherProtectiveDataList(recordOtherProtectiveDataList);
        return response;
    }
}
