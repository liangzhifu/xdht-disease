package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordBuildingAerationDataMapper;
import com.xdht.disease.sys.model.RecordBuildingAerationData;
import com.xdht.disease.sys.service.RecordBuildingAerationDataService;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordBuildingAerationDataServiceImpl extends AbstractService<RecordBuildingAerationData> implements RecordBuildingAerationDataService{

    @Autowired
    private RecordBuildingAerationDataMapper recordBuildingAerationDataMapper;

    @Override
    public List<RecordBuildingAerationData> queryList(RecordBuildingAerationDataRequest recordBuildingAerationDataRequest) {
        Condition condition = new Condition(RecordBuildingAerationData.class);
        condition.createCriteria().andEqualTo("id", recordBuildingAerationDataRequest.getId())
        .andEqualTo("number",recordBuildingAerationDataRequest.getNumber());
        if (recordBuildingAerationDataRequest.getBuildingName() != null) {
            condition.getOredCriteria().get(0).andLike("buildingName","%"+recordBuildingAerationDataRequest.getBuildingName()+"%");
        }
        if (recordBuildingAerationDataRequest.getRegulationMode() != null){
            condition.getOredCriteria().get(0).andLike("regulationMode","%"+recordBuildingAerationDataRequest.getRegulationMode()+"%");
        }
        if (recordBuildingAerationDataRequest.getAdjustmentFacilities() != null){
            condition.getOredCriteria().get(0).andLike("adjustmentFacilities","%"+recordBuildingAerationDataRequest.getAdjustmentFacilities()+"%");
        }
        if (recordBuildingAerationDataRequest.getHeatingMode() != null){
            condition.getOredCriteria().get(0).andLike("heatingMode","%"+recordBuildingAerationDataRequest.getHeatingMode()+"%");
        }
        return this.recordBuildingAerationDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordBuildingAerationData> queryListPage(RecordBuildingAerationDataRequest recordBuildingAerationDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordBuildingAerationData.class);
        condition.createCriteria().andEqualTo("id", recordBuildingAerationDataRequest.getId())
                .andEqualTo("number",recordBuildingAerationDataRequest.getNumber());
        if (recordBuildingAerationDataRequest.getBuildingName() != null) {
            condition.getOredCriteria().get(0).andLike("buildingName","%"+recordBuildingAerationDataRequest.getBuildingName()+"%");
        }
        if (recordBuildingAerationDataRequest.getRegulationMode() != null){
            condition.getOredCriteria().get(0).andLike("regulationMode","%"+recordBuildingAerationDataRequest.getRegulationMode()+"%");
        }
        if (recordBuildingAerationDataRequest.getAdjustmentFacilities() != null){
            condition.getOredCriteria().get(0).andLike("adjustmentFacilities","%"+recordBuildingAerationDataRequest.getAdjustmentFacilities()+"%");
        }
        if (recordBuildingAerationDataRequest.getHeatingMode() != null){
            condition.getOredCriteria().get(0).andLike("heatingMode","%"+recordBuildingAerationDataRequest.getHeatingMode()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordBuildingAerationData> dataList = this.recordBuildingAerationDataMapper.selectByCondition(condition);
        PageResult<RecordBuildingAerationData> pageList = new  PageResult<RecordBuildingAerationData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordBuildingAerationData add(RecordBuildingAerationData recordBuildingAerationData) {
        this.recordBuildingAerationDataMapper.insertUseGeneratedKeys(recordBuildingAerationData);
        return  recordBuildingAerationData;
    }

    @Override
    public RecordBuildingAerationData delete(Long id) {
            this.recordBuildingAerationDataMapper.deleteByPrimaryKey(id);
            RecordBuildingAerationData recordBuildingAerationData = new RecordBuildingAerationData();
            recordBuildingAerationData.setId(id);
            return recordBuildingAerationData;
    }

    @Override
    public RecordBuildingAerationData update(RecordBuildingAerationData recordBuildingAerationData) {
        this.recordBuildingAerationDataMapper.updateByPrimaryKeySelective(recordBuildingAerationData);
        return  recordBuildingAerationData;
    }

    @Override
    public List<Map<String, Object>> queryRecordBuildingAerationDataByPostPersonnel(Long id) {
        return this.recordBuildingAerationDataMapper.queryRecordBuildingAerationDataByPostPersonnel(id);
    }
}
