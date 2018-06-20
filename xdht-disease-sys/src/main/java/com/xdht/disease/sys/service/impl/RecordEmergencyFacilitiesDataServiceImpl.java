package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEmergencyFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordEmergencyFacilitiesDataServiceImpl extends AbstractService<RecordEmergencyFacilitiesData> implements RecordEmergencyFacilitiesDataService{

    @Autowired
    private RecordEmergencyFacilitiesDataMapper recordEmergencyFacilitiesDataMapper;

    @Override
    public List<RecordEmergencyFacilitiesData> queryList(RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest) {
        Condition condition = new Condition(RecordEmergencyFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesDataRequest.getId())
                .andEqualTo("officeId",recordEmergencyFacilitiesDataRequest.getOfficeId());
        if (recordEmergencyFacilitiesDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordEmergencyFacilitiesDataRequest.getWorkPlace()+"%");
        }
        return this.recordEmergencyFacilitiesDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEmergencyFacilitiesData> queryListPage(RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest) {
        Condition condition = new Condition(RecordEmergencyFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesDataRequest.getId())
                .andEqualTo("officeId",recordEmergencyFacilitiesDataRequest.getOfficeId());
        if (recordEmergencyFacilitiesDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordEmergencyFacilitiesDataRequest.getWorkPlace()+"%");
        }
        PageHelper.startPage(recordEmergencyFacilitiesDataRequest.getPageNumber(), recordEmergencyFacilitiesDataRequest.getPageSize());
        List<RecordEmergencyFacilitiesData> dataList = this.recordEmergencyFacilitiesDataMapper.selectByCondition(condition);
        Integer count = this.recordEmergencyFacilitiesDataMapper.selectCountByCondition(condition);
        PageResult<RecordEmergencyFacilitiesData> pageList = new  PageResult<RecordEmergencyFacilitiesData>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEmergencyFacilitiesData add(RecordEmergencyFacilitiesData recordEmergencyFacilitiesData) {
            this.recordEmergencyFacilitiesDataMapper.insertUseGeneratedKeys(recordEmergencyFacilitiesData);
            return recordEmergencyFacilitiesData;
    }

    @Override
    public RecordEmergencyFacilitiesData delete(Long id) {
            this.recordEmergencyFacilitiesDataMapper.deleteByPrimaryKey(id);
            RecordEmergencyFacilitiesData recordEmergencyFacilitiesData = new RecordEmergencyFacilitiesData();
            recordEmergencyFacilitiesData.setId(id);
            return   recordEmergencyFacilitiesData;
    }

    @Override
    public RecordEmergencyFacilitiesData update(RecordEmergencyFacilitiesData recordEmergencyFacilitiesData) {
        this.recordEmergencyFacilitiesDataMapper.updateByPrimaryKeySelective(recordEmergencyFacilitiesData);
        return recordEmergencyFacilitiesData;
    }
}
