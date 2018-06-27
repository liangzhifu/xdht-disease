package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordFundsDataMapper;
import com.xdht.disease.sys.model.RecordFundsData;
import com.xdht.disease.sys.service.RecordFundsDataService;
import com.xdht.disease.sys.vo.request.RecordFundsDataRequest;
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
public class RecordFundsDataServiceImpl extends AbstractService<RecordFundsData> implements RecordFundsDataService{

    @Autowired
    private RecordFundsDataMapper recordFundsDataMapper;

    @Override
    public List<RecordFundsData> queryList(RecordFundsDataRequest recordFundsDataRequest) {
        Condition condition = new Condition(RecordFundsData.class);
        condition.createCriteria() .andEqualTo("id", recordFundsDataRequest.getId())
                .andEqualTo("fundsId",recordFundsDataRequest.getFundsId())
                .andEqualTo("fundsProjectId",recordFundsDataRequest.getFundsProjectId());
        return this.recordFundsDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordFundsData> queryListPage(RecordFundsDataRequest recordFundsDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordFundsData.class);
        condition.createCriteria() .andEqualTo("id", recordFundsDataRequest.getId())
                .andEqualTo("fundsId",recordFundsDataRequest.getFundsId())
                .andEqualTo("fundsProjectId",recordFundsDataRequest.getFundsProjectId());

        PageHelper.startPage(pageNum, pageSize);
        List<RecordFundsData> dataList = this.recordFundsDataMapper.selectByCondition(condition);
        PageResult<RecordFundsData> pageList = new  PageResult<RecordFundsData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordFundsData add(RecordFundsData recordFundsData) {
            this.recordFundsDataMapper.insertUseGeneratedKeys(recordFundsData);
            return recordFundsData;
    }

    @Override
    public RecordFundsData delete(Long id) {
            this.recordFundsDataMapper.deleteByPrimaryKey(id);
            RecordFundsData recordFundsData = new RecordFundsData();
            recordFundsData.setId(id);
            return recordFundsData;
    }

    @Override
    public RecordFundsData update(RecordFundsData recordFundsData) {

        this.recordFundsDataMapper.updateByPrimaryKeySelective(recordFundsData);
        return recordFundsData;
    }

    @Override
    public List<Map<String, Object>> queryRecordFundsDataByFundsId(Long id) {
        return this.recordFundsDataMapper.queryRecordFundsDataByFundsId(id);
    }
}
