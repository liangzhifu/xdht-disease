package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordHealthManagementMapper;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.sys.model.RecordHealthManagementProject;
import com.xdht.disease.sys.service.RecordHealthManagementDataService;
import com.xdht.disease.sys.service.RecordHealthManagementProjectService;
import com.xdht.disease.sys.service.RecordHealthManagementService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementInputRequest;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;
import com.xdht.disease.sys.vo.response.RecordHealthManagementDetailResponse;
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
public class RecordHealthManagementServiceImpl extends AbstractService<RecordHealthManagement> implements RecordHealthManagementService{

    @Autowired
    private RecordHealthManagementMapper recordHealthManagementMapper;

    @Autowired
    private RecordHealthManagementDataService recordHealthManagementDataService;

    @Autowired
    private RecordHealthManagementProjectService recordHealthManagementProjectService;
    @Override
    public List<RecordHealthManagement> queryList(RecordHealthManagementRequest recordHealthManagementRequest) {

        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId())
                .andEqualTo("healthManagementNo",recordHealthManagementRequest.getHealthManagementNo());
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
        if (recordHealthManagementRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthManagementRequest.getStatus());
        }
        return this.recordHealthManagementMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHealthManagement> queryListPage(RecordHealthManagementRequest recordHealthManagementRequest) {
        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId());
        if (recordHealthManagementRequest.getHealthManagementNo() != null) {
            condition.getOredCriteria().get(0).andLike("healthManagementNo","%"+recordHealthManagementRequest.getHealthManagementNo()+"%");
        }
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
            condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordHealthManagementRequest.getPageNumber(), recordHealthManagementRequest.getPageSize());
        List<RecordHealthManagement> dataList = this.recordHealthManagementMapper.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<RecordHealthManagement> pageList = new  PageResult<RecordHealthManagement>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHealthManagement add(RecordHealthManagementInputRequest recordHealthManagementInputRequest) {
        RecordHealthManagement recordHealthManagement = recordHealthManagementInputRequest.getRecordHealthManagement();
        recordHealthManagement.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordHealthManagementMapper.insertUseGeneratedKeys(recordHealthManagement);
        List<RecordHealthManagementData> recordHealthManagementDataList = new LinkedList<>();
        for ( RecordHealthManagementData recordHealthManagementData :  recordHealthManagementInputRequest.getRecordHealthManagementDataList()) {
            recordHealthManagementData.setHealthManagementId(recordHealthManagement.getId());
            recordHealthManagementDataList.add(recordHealthManagementData);
        }
        if (recordHealthManagementDataList.size()>0){
            this.recordHealthManagementDataService.insertList(recordHealthManagementDataList);
        }
        return recordHealthManagement;
    }

    @Override
    public RecordHealthManagement delete(Long id) {
        RecordHealthManagement recordHealthManagement = this.recordHealthManagementMapper.selectByPrimaryKey(id);
        recordHealthManagement.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordHealthManagementMapper.updateByPrimaryKeySelective(recordHealthManagement);
        return  recordHealthManagement;
    }

    @Override
    public RecordHealthManagement update(RecordHealthManagementInputRequest recordHealthManagementInputRequest) {

        RecordHealthManagement recordHealthManagement = recordHealthManagementInputRequest.getRecordHealthManagement();
        this.recordHealthManagementMapper.updateByPrimaryKeySelective(recordHealthManagement);

        List<RecordHealthManagementData> recordHealthManagementDataList = new LinkedList<>();
        for (RecordHealthManagementData recordHealthManagementData : recordHealthManagementInputRequest.getRecordHealthManagementDataList() ) {
            if (recordHealthManagementData.getId() == null){
                recordHealthManagementData.setHealthManagementId(recordHealthManagement.getId());
                recordHealthManagementDataList.add(recordHealthManagementData);
            }
            this.recordHealthManagementDataService.updateByPrimaryKeySelective(recordHealthManagementData);
        }
        if (recordHealthManagementDataList.size()>0){
            this.recordHealthManagementDataService.insertList(recordHealthManagementDataList);
        }
        return recordHealthManagement;
    }

    @Override
    public RecordHealthManagementDetailResponse queryRecordHealthManagementDetail(Long id) {
        RecordHealthManagementDetailResponse recordHealthManagementDetailResponse = new RecordHealthManagementDetailResponse();
        RecordHealthManagement recordHealthManagement = new RecordHealthManagement();
        recordHealthManagement.setSceneId(id);
        recordHealthManagement =  this.recordHealthManagementMapper.selectOne(recordHealthManagement);
        if (recordHealthManagement != null) {
            Long recordId = recordHealthManagement.getId();
            recordHealthManagementDetailResponse.setRecordHealthManagement(recordHealthManagement);
            Condition condition = new Condition(RecordHealthManagementData.class);
            condition.createCriteria() .andEqualTo("healthManagementId", recordId);
            List<RecordHealthManagementData> recordHealthManagementDataList = this.recordHealthManagementDataService.selectByCondition(condition);
            recordHealthManagementDetailResponse.setRecordHealthManagementDataList(recordHealthManagementDataList);
            String projectIds = "";
            for (RecordHealthManagementData recordData : recordHealthManagementDataList) {
                projectIds += recordData.getHealthManagementProjectId()+",";
            }
            projectIds = projectIds.substring(0,projectIds.lastIndexOf(","));
            List<RecordHealthManagementProject> projectList = this.recordHealthManagementProjectService.selectByIds(projectIds);
            recordHealthManagementDetailResponse.setRecordHealthManagementProjectList(projectList);
        }
        return recordHealthManagementDetailResponse;
    }

}
