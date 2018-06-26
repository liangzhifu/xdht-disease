package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordAuxiliaryHealthDataMapper;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthDataService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthDataRequest;
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
public class RecordAuxiliaryHealthDataServiceImpl extends AbstractService<RecordAuxiliaryHealthData> implements RecordAuxiliaryHealthDataService{

    @Autowired
    private RecordAuxiliaryHealthDataMapper recordAuxiliaryHealthDataMapper;

    @Override
    public List<RecordAuxiliaryHealthData> queryList(RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest) {
        Condition condition = new Condition(RecordAuxiliaryHealthData.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealthDataRequest.getId())
                .andEqualTo("officeId",recordAuxiliaryHealthDataRequest.getOfficeId());
        if (recordAuxiliaryHealthDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordAuxiliaryHealthDataRequest.getWorkPlace()+"%");
        }
        if (recordAuxiliaryHealthDataRequest.getHygienicRoom() != null) {
            condition.getOredCriteria().get(0).andLike("hygienicRoom","%"+recordAuxiliaryHealthDataRequest.getHygienicRoom()+"%");
        }
        if (recordAuxiliaryHealthDataRequest.getLivingRoom() != null){
            condition.getOredCriteria().get(0).andEqualTo("livingRoom",recordAuxiliaryHealthDataRequest.getLivingRoom());
        }
        return this.recordAuxiliaryHealthDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordAuxiliaryHealthData> queryListPage(RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(RecordAuxiliaryHealthData.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealthDataRequest.getId())
                .andEqualTo("officeId",recordAuxiliaryHealthDataRequest.getOfficeId());
        if (recordAuxiliaryHealthDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordAuxiliaryHealthDataRequest.getWorkPlace()+"%");
        }
        if (recordAuxiliaryHealthDataRequest.getHygienicRoom() != null) {
            condition.getOredCriteria().get(0).andLike("hygienicRoom","%"+recordAuxiliaryHealthDataRequest.getHygienicRoom()+"%");
        }
        if (recordAuxiliaryHealthDataRequest.getLivingRoom() != null){
            condition.getOredCriteria().get(0).andEqualTo("livingRoom",recordAuxiliaryHealthDataRequest.getLivingRoom());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAuxiliaryHealthData> dataList = this.recordAuxiliaryHealthDataMapper.selectByCondition(condition);
        PageResult<RecordAuxiliaryHealthData> pageList = new  PageResult<RecordAuxiliaryHealthData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordAuxiliaryHealthData add(RecordAuxiliaryHealthData recordAuxiliaryHealthData) {
            this.recordAuxiliaryHealthDataMapper.insertUseGeneratedKeys(recordAuxiliaryHealthData);
            return recordAuxiliaryHealthData;
    }

    @Override
    public RecordAuxiliaryHealthData delete(Long id) {
            this.recordAuxiliaryHealthDataMapper.deleteByPrimaryKey(id);
            RecordAuxiliaryHealthData recordAuxiliaryHealthData = new RecordAuxiliaryHealthData();
            recordAuxiliaryHealthData.setId(id);
            return recordAuxiliaryHealthData;
    }

    @Override
    public RecordAuxiliaryHealthData update(RecordAuxiliaryHealthData recordAuxiliaryHealthData) {
        this.recordAuxiliaryHealthDataMapper.updateByPrimaryKeySelective(recordAuxiliaryHealthData);
        return recordAuxiliaryHealthData;
    }

    @Override
    public List<Map<String, Object>> queryRecordAuxiliaryHealthDataByAuxiliaryHealth(Long id) {
        return this.recordAuxiliaryHealthDataMapper.queryAuxiliaryHealthDataByAuxiliary(id);
    }

}
