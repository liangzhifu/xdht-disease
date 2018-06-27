package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHealthCareDataMapper;
import com.xdht.disease.sys.model.RecordHealthCareData;
import com.xdht.disease.sys.service.RecordHealthCareDataService;
import com.xdht.disease.sys.vo.request.RecordHealthCareDataRequest;
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
public class RecordHealthCareDataServiceImpl extends AbstractService<RecordHealthCareData> implements RecordHealthCareDataService{

    @Autowired
    private RecordHealthCareDataMapper recordHealthCareDataMapper;

    @Override
    public List<RecordHealthCareData> queryList(RecordHealthCareDataRequest recordHealthCareDataRequest) {
        Condition condition = new Condition(RecordHealthCareData.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCareDataRequest.getId())
                .andEqualTo("healthCareId",recordHealthCareDataRequest.getHealthCareId())
                .andEqualTo("healthCareProjectId",recordHealthCareDataRequest.getHealthCareProjectId());
        return this.recordHealthCareDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHealthCareData> queryListPage(RecordHealthCareDataRequest recordHealthCareDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordHealthCareData.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCareDataRequest.getId())
                .andEqualTo("healthCareId",recordHealthCareDataRequest.getHealthCareId())
                .andEqualTo("healthCareProjectId",recordHealthCareDataRequest.getHealthCareProjectId());
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHealthCareData> dataList = this.recordHealthCareDataMapper.selectByCondition(condition);
        PageResult<RecordHealthCareData> pageList = new  PageResult<RecordHealthCareData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHealthCareData add(RecordHealthCareData recordHealthCareData) {
            this.recordHealthCareDataMapper.insertUseGeneratedKeys(recordHealthCareData);
            return recordHealthCareData;
    }

    @Override
    public RecordHealthCareData delete(Long id) {
            this.recordHealthCareDataMapper.deleteByPrimaryKey(id);
            RecordHealthCareData recordHealthCareData = new RecordHealthCareData();
            recordHealthCareData.setId(id);
            return recordHealthCareData;
    }

    @Override
    public RecordHealthCareData update(RecordHealthCareData recordHealthCareData) {
        this.recordHealthCareDataMapper.updateByPrimaryKeySelective(recordHealthCareData);
        return recordHealthCareData;
    }

    @Override
    public List<Map<String, Object>> queryRecordHealthCareDataByRecordHealthCareId(Long id) {
        return  this.recordHealthCareDataMapper.queryRecordHealthCareDataByRecordHealthCareId(id);
    }

}
