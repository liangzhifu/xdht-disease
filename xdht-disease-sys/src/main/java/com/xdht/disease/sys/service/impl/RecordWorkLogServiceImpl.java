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
import java.util.Map;


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
        condition.getOredCriteria().get(0).andEqualTo("status",recordWorkLogRequest.getStatus());
        PageHelper.startPage(recordWorkLogRequest.getPageNumber(), recordWorkLogRequest.getPageSize());
        List<RecordWorkLog> dataList = this.recordWorkLogMapper.selectByCondition(condition);
        Integer count = this.recordWorkLogMapper.selectCountByCondition(condition);
        PageResult<RecordWorkLog> pageList = new  PageResult<RecordWorkLog>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordWorkLogInputRequest recordWorkLogInputRequest) {
            RecordWorkLog recordWorkLog = new RecordWorkLog();
            recordWorkLog.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            this.insertUseGeneratedKeys(recordWorkLog);
            List<RecordWorkLogData> recordWorkLogDataList = new LinkedList<>();
            for ( RecordWorkLogData recordWorkLogData : recordWorkLogInputRequest.getRecordWorkLogDataList() ) {
                recordWorkLogData.setRelationId(recordWorkLog.getId());
                recordWorkLogDataList.add(recordWorkLogData);
            }
            this.recordWorkLogDataService.insertList(recordWorkLogDataList);
    }

    @Override
    public void delete(Long id) {
        RecordWorkLog recordWorkLog = new RecordWorkLog();
        recordWorkLog.setId(id);
        recordWorkLog.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordWorkLogMapper.updateByPrimaryKeySelective(recordWorkLog);
    }

    @Override
    public void update(RecordWorkLogInputRequest recordWorkLogInputRequest) {
        RecordWorkLog recordWorkLog = recordWorkLogInputRequest.getRecordWorkLog();
        this.updateByPrimaryKeySelective(recordWorkLog);
        for ( RecordWorkLogData recordWorkLogData : recordWorkLogInputRequest.getRecordWorkLogDataList() ) {
            this.recordWorkLogDataService.updateByPrimaryKeySelective(recordWorkLogData);
        }
    }

    @Override
    public RecordWorkLogDetailResponse queryWorkLogDetail(Long id) {
        RecordWorkLogDetailResponse response = new RecordWorkLogDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordWorkLogMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordWorkLog(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordWorkLogDataService.queryRecordDataByorkLog(recordId);
            response.setRecordWorkLogDataList(mapList);
        }
        return response;
    }
}
