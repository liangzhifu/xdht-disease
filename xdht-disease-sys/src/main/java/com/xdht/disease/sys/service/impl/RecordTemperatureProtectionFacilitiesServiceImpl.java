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
import java.util.Map;


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
    public PageResult<RecordTemperatureProtectionFacilities> queryListPage(RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordTemperatureProtectionFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());

        if (recordRequest.getTemperatureProtectionFacilitiesNo() != null) {
            condition.getOredCriteria().get(0).andLike("temperatureProtectionFacilitiesNo","%"+recordRequest.getTemperatureProtectionFacilitiesNo()+"%");
        }
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordRequest.getPageNumber(), recordRequest.getPageSize());
        List<RecordTemperatureProtectionFacilities> dataList = this.recordMapper.selectByCondition(condition);
        Integer count = this.recordMapper.selectCountByCondition(condition);
        PageResult<RecordTemperatureProtectionFacilities> pageList = new  PageResult<RecordTemperatureProtectionFacilities>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordTemperatureInputRequest recordTemperatureInputRequest) {
        RecordTemperatureProtectionFacilities recordTemperature = recordTemperatureInputRequest.getRecordTemperature();
        recordTemperature.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordMapper.insertUseGeneratedKeys(recordTemperature);
        List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList = new LinkedList<>();
       if (recordTemperatureInputRequest.getRecordTemperatureDataList() != null) {
           for ( RecordTemperatureProtectionFacilitiesData recordTemperatureData : recordTemperatureInputRequest.getRecordTemperatureDataList()) {
               recordTemperatureData.setRelationId(recordTemperature.getId());
               recordTemperatureDataList.add(recordTemperatureData);
           }
           this.recordTemperatureDataService.insertList(recordTemperatureDataList);
       }
    }

    @Override
    public void delete(Long id) {
        RecordTemperatureProtectionFacilities record = new RecordTemperatureProtectionFacilities();
        record.setId(id);
        record.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void update(RecordTemperatureInputRequest recordTemperatureInputRequest) {

        RecordTemperatureProtectionFacilities recordTemperature = recordTemperatureInputRequest.getRecordTemperature();
        this.recordMapper.updateByPrimaryKeySelective(recordTemperature);

        Condition condition = new Condition(RecordTemperatureProtectionFacilitiesData.class);
        condition.createCriteria().andEqualTo("relationId", recordTemperature.getId());
        List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList = this.recordTemperatureDataService.selectByCondition(condition);
        if (recordTemperatureDataList != null && recordTemperatureDataList.size() > 0 ) {
            for ( RecordTemperatureProtectionFacilitiesData recordTemperatureData: recordTemperatureDataList) {
                this.recordTemperatureDataService.deleteByPrimaryKey(recordTemperatureData.getId());
            }
        }
        recordTemperatureDataList = new LinkedList<>();
        if (recordTemperatureInputRequest.getRecordTemperatureDataList() != null){
            for (RecordTemperatureProtectionFacilitiesData recordTemperatureProtectionFacilitiesData : recordTemperatureInputRequest.getRecordTemperatureDataList()) {
                recordTemperatureProtectionFacilitiesData.setRelationId(recordTemperature.getId());
                recordTemperatureDataList.add(recordTemperatureProtectionFacilitiesData);
            }
            this.recordTemperatureDataService.insertList(recordTemperatureDataList);
        }
    }

    @Override
    public RecordTemperatureDetailResponse queryTemperatureDetail(Long id) {
        RecordTemperatureDetailResponse response = new RecordTemperatureDetailResponse();
        Map<String, Object> map = this.recordMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordTemperature(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordTemperatureDataService.queryRecordDataByTemperatureProtection(recordId);
            response.setRecordTemperatureDataList(mapList);
        }
        return response;
    }
}
