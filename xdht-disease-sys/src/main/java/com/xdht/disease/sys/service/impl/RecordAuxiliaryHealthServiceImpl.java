package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordAuxiliaryHealthMapper;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthDataService;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
import com.xdht.disease.sys.vo.response.RecordAuxiliaryHealthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordAuxiliaryHealthServiceImpl extends AbstractService<RecordAuxiliaryHealth> implements RecordAuxiliaryHealthService{

    @Autowired
    private RecordAuxiliaryHealthMapper recordAuxiliaryHealthMapper;
    @Autowired
    private RecordAuxiliaryHealthDataService recordAuxiliaryHealthDataService;

    @Override
    public List<RecordAuxiliaryHealth> queryList(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        RecordAuxiliaryHealth recordAuxiliaryHealth = recordAuxiliaryHealthRequest.getRecordAuxiliaryHealth();
        Condition condition = new Condition(RecordAuxiliaryHealth.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealth.getId())
                .andEqualTo("auxiliaryHealthNo",recordAuxiliaryHealth.getAuxiliaryHealthNo());
        if (recordAuxiliaryHealth.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAuxiliaryHealth.getVerificationResult()+"%");
        }
        if (recordAuxiliaryHealth.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAuxiliaryHealth.getStatus());
        }
        return this.recordAuxiliaryHealthMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordAuxiliaryHealth> queryListPage(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest, Integer pageNum, Integer pageSize) {
        RecordAuxiliaryHealth recordAuxiliaryHealth = recordAuxiliaryHealthRequest.getRecordAuxiliaryHealth();
        Condition condition = new Condition(RecordAuxiliaryHealth.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealth.getId())
                .andEqualTo("auxiliaryHealthNo",recordAuxiliaryHealth.getAuxiliaryHealthNo());
        if (recordAuxiliaryHealth.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAuxiliaryHealth.getVerificationResult()+"%");
        }
        if (recordAuxiliaryHealth.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAuxiliaryHealth.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAuxiliaryHealth> dataList = this.recordAuxiliaryHealthMapper.selectByCondition(condition);
        PageResult<RecordAuxiliaryHealth> pageList = new  PageResult<RecordAuxiliaryHealth>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        RecordAuxiliaryHealth recordAuxiliaryHealth = recordAuxiliaryHealthRequest.getRecordAuxiliaryHealth();
        recordAuxiliaryHealth.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordAuxiliaryHealth);
        List<RecordAuxiliaryHealthData> recordAuxiliaryHealthDataList = new LinkedList<>();
        if (recordAuxiliaryHealthRequest.getRecordAuxiliaryHealthDataList() != null) {
            for (RecordAuxiliaryHealthData recordAuxiliaryHealthData : recordAuxiliaryHealthRequest.getRecordAuxiliaryHealthDataList()) {
                recordAuxiliaryHealthData.setAuxiliaryHealthId(recordAuxiliaryHealth.getId());
                recordAuxiliaryHealthDataList.add(recordAuxiliaryHealthData);
            }
            this.recordAuxiliaryHealthDataService.insertList(recordAuxiliaryHealthDataList);
        }
    }

    @Override
    public RecordAuxiliaryHealth delete(Long id) {
            this.recordAuxiliaryHealthMapper.deleteByPrimaryKey(id);
            RecordAuxiliaryHealth recordAuxiliaryHealth = new RecordAuxiliaryHealth();
            recordAuxiliaryHealth.setId(id);
            return recordAuxiliaryHealth;
    }

    @Override
    public void update(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        RecordAuxiliaryHealth recordAuxiliaryHealth = recordAuxiliaryHealthRequest.getRecordAuxiliaryHealth();
        this.recordAuxiliaryHealthMapper.updateByPrimaryKeySelective(recordAuxiliaryHealth);
        Condition condition = new Condition(RecordAuxiliaryHealthData.class);
        condition.createCriteria().andEqualTo("auxiliaryHealthId", recordAuxiliaryHealth.getId());
        List<RecordAuxiliaryHealthData> recordAuxiliaryHealthDatas = this.recordAuxiliaryHealthDataService.selectByCondition(condition);
        if (recordAuxiliaryHealthDatas != null && recordAuxiliaryHealthDatas.size() > 0) {
            for (RecordAuxiliaryHealthData recordAuxiliaryHealthData : recordAuxiliaryHealthDatas) {
                this.recordAuxiliaryHealthDataService.deleteByPrimaryKey(recordAuxiliaryHealthData.getId());
            }
        }
        recordAuxiliaryHealthDatas = new LinkedList<>();
        if (recordAuxiliaryHealthRequest.getRecordAuxiliaryHealthDataList() != null) {
            for (RecordAuxiliaryHealthData recordAuxiliaryHealthData : recordAuxiliaryHealthRequest.getRecordAuxiliaryHealthDataList()) {
                recordAuxiliaryHealthData.setAuxiliaryHealthId(recordAuxiliaryHealth.getId());
                recordAuxiliaryHealthDatas.add(recordAuxiliaryHealthData);
            }
            this.recordAuxiliaryHealthDataService.insertList(recordAuxiliaryHealthDatas);
        }
    }

    @Override
    public RecordAuxiliaryHealthResponse queryAuxiliaryHealthDetail(Long id) {
        RecordAuxiliaryHealthResponse response = new RecordAuxiliaryHealthResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordAuxiliaryHealthMapper.selectAuxiliaryHealthBySceneId(id);
        if (map != null) {
            response.setRecordAuxiliaryHealth(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordAuxiliaryHealthDataService.queryRecordAuxiliaryHealthDataByAuxiliaryHealth(recordId);
            response.setRecordAuxiliaryHealthDataList(mapList);
        }
        return response;
    }
}
