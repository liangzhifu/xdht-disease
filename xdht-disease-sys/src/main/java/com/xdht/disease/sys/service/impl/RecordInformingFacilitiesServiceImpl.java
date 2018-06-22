package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordInformingFacilitiesMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.sys.service.RecordInformingFacilitiesDataService;
import com.xdht.disease.sys.service.RecordInformingFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesInputRequest;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualProtectiveDetailResponse;
import com.xdht.disease.sys.vo.response.RecordInformingFacilitiesDetailResponse;
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
public class RecordInformingFacilitiesServiceImpl extends AbstractService<RecordInformingFacilities> implements RecordInformingFacilitiesService{

    @Autowired
    private RecordInformingFacilitiesMapper recordMapper;

    @Autowired
    private RecordInformingFacilitiesDataService recordInformingFacilitiesDataService;

    @Override
    public List<RecordInformingFacilities> queryList(RecordInformingFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordInformingFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("informingFacilitiesNo",recordRequest.getInformingFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordInformingFacilities> queryListPage(RecordInformingFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordInformingFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());
        if (recordRequest.getInformingFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("informingFacilitiesNo","%"+recordRequest.getInformingFacilitiesNo()+"%");
        }
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordInformingFacilities> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordInformingFacilities> pageList = new  PageResult<RecordInformingFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordInformingFacilities add(RecordInformingFacilitiesInputRequest recordInformingFacilitiesInputRequest) {
        RecordInformingFacilities recordInformingFacilities = recordInformingFacilitiesInputRequest.getRecordInformingFacilities();
        recordInformingFacilities.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordInformingFacilities);
        List<RecordInformingFacilitiesData> recordInformingFacilitiesDataList = new LinkedList<>();
        for ( RecordInformingFacilitiesData recordInformingFacilitiesData :  recordInformingFacilitiesInputRequest.getRecordInformingFacilitiesDataList()) {
            recordInformingFacilitiesData.setRelationId(recordInformingFacilities.getId());
            recordInformingFacilitiesDataList.add(recordInformingFacilitiesData);
        }
        if (recordInformingFacilitiesDataList.size()>0){
            this.recordInformingFacilitiesDataService.insertList(recordInformingFacilitiesDataList);
        }
        return recordInformingFacilities;
    }

    @Override
    public RecordInformingFacilities delete(Long id) {
        RecordInformingFacilities recordInformingFacilities = this.recordMapper.selectByPrimaryKey(id);
        recordInformingFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(recordInformingFacilities);
        return recordInformingFacilities;
    }

    @Override
    public RecordInformingFacilities update(RecordInformingFacilitiesInputRequest recordInformingFacilitiesInputRequest) {
        RecordInformingFacilities recordInformingFacilities = recordInformingFacilitiesInputRequest.getRecordInformingFacilities();
        this.recordMapper.updateByPrimaryKeySelective(recordInformingFacilities);
        List<RecordInformingFacilitiesData> recordInformingFacilitiesDataList = new LinkedList<>();
        for ( RecordInformingFacilitiesData recordInformingFacilitiesData: recordInformingFacilitiesInputRequest.getRecordInformingFacilitiesDataList() ) {
            if (recordInformingFacilitiesData.getId() == null){
                recordInformingFacilitiesData.setRelationId(recordInformingFacilities.getId());
                recordInformingFacilitiesDataList.add(recordInformingFacilitiesData);
            }
            this.recordInformingFacilitiesDataService.updateByPrimaryKeySelective(recordInformingFacilitiesData);
        }
        if (recordInformingFacilitiesDataList.size()>0){
            this.recordInformingFacilitiesDataService.insertList(recordInformingFacilitiesDataList);
        }
        return recordInformingFacilities;
    }

    @Override
    public RecordInformingFacilitiesDetailResponse queryInformingFacilitiesDetail(Long id) {
        RecordInformingFacilitiesDetailResponse response = new RecordInformingFacilitiesDetailResponse();
        RecordInformingFacilities recordInformingFacilities = new RecordInformingFacilities();
        recordInformingFacilities.setSceneId(id);
        recordInformingFacilities = this.recordMapper.selectOne(recordInformingFacilities);
        if (recordInformingFacilities != null) {
            Long recordId = recordInformingFacilities.getId();
            response.setRecordInformingFacilities(recordInformingFacilities);
            Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
            condition.createCriteria() .andEqualTo("relationId", recordId);
            List<RecordInformingFacilitiesData> recordInformingFacilitiesDataList = this.recordInformingFacilitiesDataService.selectByCondition(condition);
            response.setRecordInformingFacilitiesDataList(recordInformingFacilitiesDataList);
        }
        return response;
    }
}
