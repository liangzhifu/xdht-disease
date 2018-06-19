package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordWorkLogMapper;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.sys.model.RecordWorkLogData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.model.SysPost;
import com.xdht.disease.sys.service.RecordWorkLogDataService;
import com.xdht.disease.sys.service.RecordWorkLogService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.service.SysPostService;
import com.xdht.disease.sys.vo.request.RecordWorkLogInputRequest;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;
import com.xdht.disease.sys.vo.response.RecordWorkLogDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class RecordWorkLogServiceImpl extends AbstractService<RecordWorkLog> implements RecordWorkLogService{

    @Autowired
    private RecordWorkLogMapper recordWorkLogMapper;
    @Autowired
    private RecordWorkLogDataService recordWorkLogDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Autowired
    private SysPostService sysPostService;

    @Override
    public List<RecordWorkLog> queryList(RecordWorkLogRequest recordWorkLogRequest) {

        Condition condition = new Condition(RecordWorkLog.class);
        condition.createCriteria() .andEqualTo("id", recordWorkLogRequest.getId())
                .andEqualTo("workLogNo",recordWorkLogRequest.getWorkLogNo());
        if (recordWorkLogRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordWorkLogRequest.getVerificationResult()+"%");
        }
        if (recordWorkLogRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordWorkLogRequest.getStatus());
        }
        return this.recordWorkLogMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordWorkLog> queryListPage(RecordWorkLogRequest recordWorkLogRequest) {

        Condition condition = new Condition(RecordWorkLog.class);
        condition.createCriteria() .andEqualTo("id", recordWorkLogRequest.getId());
        if (recordWorkLogRequest.getWorkLogNo() != null) {
            condition.getOredCriteria().get(0).andLike("workLogNo","%"+recordWorkLogRequest.getWorkLogNo()+"%");
        }
        if (recordWorkLogRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordWorkLogRequest.getVerificationResult()+"%");
        }
        if (recordWorkLogRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordWorkLogRequest.getStatus());
        }
        PageHelper.startPage(recordWorkLogRequest.getPageNumber(), recordWorkLogRequest.getPageSize());
        List<RecordWorkLog> dataList = this.recordWorkLogMapper.selectByCondition(condition);
        Integer count = this.recordWorkLogMapper.selectCountByCondition(condition);
        PageResult<RecordWorkLog> pageList = new  PageResult<RecordWorkLog>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordWorkLog add(RecordWorkLogInputRequest recordWorkLogInputRequest) {
            RecordWorkLog recordWorkLog = new RecordWorkLog();
            recordWorkLog.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            recordWorkLog.setWorkLogNo(recordWorkLogInputRequest.getRecordWorkLog().getWorkLogNo());
            recordWorkLog.setVerificationResult(recordWorkLogInputRequest.getRecordWorkLog().getVerificationResult());
            this.insertUseGeneratedKeys(recordWorkLog);
            List<RecordWorkLogData> recordWorkLogDataList = new LinkedList<>();
            for ( RecordWorkLogData recordWorkLogData : recordWorkLogInputRequest.getRecordWorkLogDataList() ) {
                recordWorkLogData.setRelationId(recordWorkLog.getId());
                recordWorkLogDataList.add(recordWorkLogData);
            }
            this.recordWorkLogDataService.insertList(recordWorkLogDataList);
            return recordWorkLog;
    }

    @Override
    public RecordWorkLog delete(Long id) {
        RecordWorkLog recordWorkLog = this.recordWorkLogMapper.selectByPrimaryKey(id);
        recordWorkLog.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordWorkLogMapper.updateByPrimaryKeySelective(recordWorkLog);
        return recordWorkLog;
    }

    @Override
    public RecordWorkLog update(RecordWorkLogInputRequest recordWorkLogInputRequest) {
            RecordWorkLog recordWorkLog = recordWorkLogInputRequest.getRecordWorkLog();
            this.recordWorkLogMapper.updateByPrimaryKeySelective(recordWorkLog);
        for ( RecordWorkLogData recordWorkLogData : recordWorkLogInputRequest.getRecordWorkLogDataList() ) {
            this.recordWorkLogDataService.updateByPrimaryKeySelective(recordWorkLogData);
        }
            return recordWorkLog;
    }

    @Override
    public RecordWorkLogDetailResponse queryWorkLogDetail(Long id) {
        RecordWorkLogDetailResponse response = new RecordWorkLogDetailResponse();
        RecordWorkLog recordWorkLog = this.recordWorkLogMapper.selectByPrimaryKey(id);
        response.setRecordWorkLog(recordWorkLog);
        Condition condition = new Condition(RecordWorkLogData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordWorkLogData> recordWorkLogDataList = this.recordWorkLogDataService.selectByCondition(condition);
        response.setRecordWorkLogDataList(recordWorkLogDataList);
        String officeIds = "";
        String postIds = "";
        for (RecordWorkLogData recordData : recordWorkLogDataList) {
            officeIds += recordData.getCompanyOfficeId() + ",";
            postIds += recordData.getPostId() + ",";
        }
        officeIds = officeIds.substring(0,officeIds.lastIndexOf(","));
        postIds = postIds.substring(0,postIds.lastIndexOf(","));
        List<SysCompanyOffice> officeList = this.sysCompanyOfficeService.selectByIds(officeIds);
        response.setSysCompanyOfficeList(officeList);
        List<SysPost> postList = this.sysPostService.selectByIds(postIds);
        response.setSysPostList(postList);
        return response;
    }
}
