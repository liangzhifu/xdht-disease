package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordBuildingAerationMapper;
import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.sys.model.RecordBuildingAerationData;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.service.RecordBuildingAerationDataService;
import com.xdht.disease.sys.service.RecordBuildingAerationService;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationRequest;
import com.xdht.disease.sys.vo.response.RecordBuildingAerationResponse;
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
public class RecordBuildingAerationServiceImpl extends AbstractService<RecordBuildingAeration> implements RecordBuildingAerationService{

    @Autowired
    private RecordBuildingAerationMapper recordBuildingAerationMapper;
    @Autowired
    private RecordBuildingAerationDataService recordBuildingAerationDataService;

    @Override
    public List<RecordBuildingAeration> queryList(RecordBuildingAerationRequest recordBuildingAerationRequest) {
        RecordBuildingAeration recordBuildingAeration = recordBuildingAerationRequest.getRecordBuildingAeration();
        Condition condition = new Condition(RecordBuildingAeration.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingAeration.getId())
                .andEqualTo("buildingAerationNo",recordBuildingAeration.getBuildingAerationNo());
        if (recordBuildingAeration.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingAeration.getVerificationResult()+"%");
        }
        if (recordBuildingAeration.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingAeration.getStatus());
        }
        return this.recordBuildingAerationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordBuildingAeration> queryListPage(RecordBuildingAerationRequest recordBuildingAerationRequest, Integer pageNum, Integer pageSize) {
        RecordBuildingAeration recordBuildingAeration = recordBuildingAerationRequest.getRecordBuildingAeration();
        Condition condition = new Condition(RecordBuildingAeration.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingAeration.getId())
                .andEqualTo("buildingAerationNo",recordBuildingAeration.getBuildingAerationNo());
        if (recordBuildingAeration.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingAeration.getVerificationResult()+"%");
        }
        if (recordBuildingAeration.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingAeration.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordBuildingAeration> dataList = this.recordBuildingAerationMapper.selectByCondition(condition);
        PageResult<RecordBuildingAeration> pageList = new  PageResult<RecordBuildingAeration>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordBuildingAerationRequest recordBuildingAerationRequest) {
        RecordBuildingAeration recordBuildingAeration = recordBuildingAerationRequest.getRecordBuildingAeration();
        recordBuildingAeration.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordBuildingAeration);
        List<RecordBuildingAerationData> recordBuildingAerationDataList = new LinkedList<>();
        if (recordBuildingAerationRequest.getRecordBuildingAerationDataList() != null) {
            for (RecordBuildingAerationData recordBuildingAerationData : recordBuildingAerationRequest.getRecordBuildingAerationDataList()) {
                recordBuildingAerationData.setBuildingAerationId(recordBuildingAeration.getId());
                recordBuildingAerationDataList.add(recordBuildingAerationData);
            }
            this.recordBuildingAerationDataService.insertList(recordBuildingAerationDataList);
        }
    }

    @Override
    public RecordBuildingAeration delete(Long id) {
        this.recordBuildingAerationMapper.deleteByPrimaryKey(id);
        RecordBuildingAeration recordBuildingAeration = new RecordBuildingAeration();
        recordBuildingAeration.setId(id);
        return recordBuildingAeration;
    }

    @Override
    public void update(RecordBuildingAerationRequest recordBuildingAerationRequest) {
        RecordBuildingAeration recordBuildingAeration = recordBuildingAerationRequest.getRecordBuildingAeration();
        this.recordBuildingAerationMapper.updateByPrimaryKeySelective(recordBuildingAeration);
        Condition condition = new Condition(RecordBuildingAerationData.class);
        condition.createCriteria().andEqualTo("buildingAerationId", recordBuildingAeration.getId());
        List<RecordBuildingAerationData> recordBuildingAerationDatas = this.recordBuildingAerationDataService.selectByCondition(condition);
        if (recordBuildingAerationDatas != null && recordBuildingAerationDatas.size() > 0) {
            for (RecordBuildingAerationData recordBuildingAerationData : recordBuildingAerationDatas) {
                this.recordBuildingAerationDataService.deleteByPrimaryKey(recordBuildingAerationData.getId());
            }
        }
        recordBuildingAerationDatas = new LinkedList<>();
        if (recordBuildingAerationRequest.getRecordBuildingAerationDataList() != null) {
            for (RecordBuildingAerationData recordBuildingAerationData : recordBuildingAerationRequest.getRecordBuildingAerationDataList()) {
                recordBuildingAerationData.setBuildingAerationId(recordBuildingAeration.getId());
                recordBuildingAerationDatas.add(recordBuildingAerationData);
            }
            this.recordBuildingAerationDataService.insertList(recordBuildingAerationDatas);
        }
    }

    @Override
    public RecordBuildingAerationResponse queryBuildingAerationDetail(Long id) {
        RecordBuildingAerationResponse response = new RecordBuildingAerationResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordBuildingAerationMapper.selectRecordBuildingAerationBySceneId(id);
        if (map != null) {
            response.setRecordBuildingAeration(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordBuildingAerationDataService.queryRecordBuildingAerationDataByPostPersonnel(recordId);
            response.setRecordBuildingAerationDataList(mapList);
        }
        return response;
    }
}
