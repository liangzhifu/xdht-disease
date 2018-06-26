package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEmergencyFacilitiesMapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
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
import java.util.Map;


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
    public PageResult<RecordEmergencyFacilities> queryListPage(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        Condition condition = new Condition(RecordEmergencyFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesRequest.getId());
        if (recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("emergencyFacilitiesNo","%"+recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEmergencyFacilitiesRequest.getVerificationResult()+"%");
        }
       condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordEmergencyFacilitiesRequest.getPageNumber(), recordEmergencyFacilitiesRequest.getPageSize());
        List<RecordEmergencyFacilities> dataList = this.recordEmergencyFacilitiesMapper.selectByCondition(condition);
        Integer count = this.recordEmergencyFacilitiesMapper.selectCountByCondition(condition);
        PageResult<RecordEmergencyFacilities> pageList = new  PageResult<RecordEmergencyFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest) {
        RecordEmergencyFacilities recordEmergencyFacilities = recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilities();
        recordEmergencyFacilities.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordEmergencyFacilities);
        List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList = new LinkedList<>();
        if (recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList() != null) {
            for ( RecordEmergencyFacilitiesData recordEmergencyFacilitiesData : recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList()) {
                recordEmergencyFacilitiesData.setRelationId(recordEmergencyFacilities.getId());
                recordEmergencyFacilitiesDataList.add(recordEmergencyFacilitiesData);
            }
            this.recordEmergencyFacilitiesDataService.insertList(recordEmergencyFacilitiesDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordEmergencyFacilities recordEmergencyFacilities = new RecordEmergencyFacilities();
        recordEmergencyFacilities.setId(id);
        recordEmergencyFacilities.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEmergencyFacilitiesMapper.updateByPrimaryKeySelective(recordEmergencyFacilities);
    }

    @Override
    public void update(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest) {
        RecordEmergencyFacilities recordEmergencyFacilities = recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilities();
        this.recordEmergencyFacilitiesMapper.updateByPrimaryKeySelective(recordEmergencyFacilities);

        Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
        condition.createCriteria().andEqualTo("relationId", recordEmergencyFacilities.getId());
        List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList = this.recordEmergencyFacilitiesDataService.selectByCondition(condition);
        if (recordEmergencyFacilitiesDataList != null && recordEmergencyFacilitiesDataList.size() > 0 ) {
            for ( RecordEmergencyFacilitiesData recordEmergencyFacilitiesData: recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList() ) {
                this.recordEmergencyFacilitiesDataService.deleteByPrimaryKey(recordEmergencyFacilitiesData.getId());
            }
        }
        recordEmergencyFacilitiesDataList = new LinkedList<>();
        if (recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList() != null){
            for (RecordEmergencyFacilitiesData recordEmergencyFacilitiesData : recordEmergencyFacilitiesInputRequest.getRecordEmergencyFacilitiesDataList()) {
                recordEmergencyFacilitiesData.setRelationId(recordEmergencyFacilities.getId());
                recordEmergencyFacilitiesDataList.add(recordEmergencyFacilitiesData);
            }
            this.recordEmergencyFacilitiesDataService.insertList(recordEmergencyFacilitiesDataList);
        }
    }

    @Override
    public RecordEmergencyFacilitiesDetailResponse queryEmergencyFacilitiesDetail(Long id) {
        RecordEmergencyFacilitiesDetailResponse response = new RecordEmergencyFacilitiesDetailResponse();
        Map<String, Object> map = this.recordEmergencyFacilitiesMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordEmergencyFacilities(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordEmergencyFacilitiesDataService.queryRecordDataByEmergency(recordId);
            response.setRecordEmergencyFacilitiesDataList(mapList);
        }
        return response;
    }
}
