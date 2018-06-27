package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordHealthCareMapper;
import com.xdht.disease.sys.model.RecordHealthCare;
import com.xdht.disease.sys.model.RecordHealthCareData;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.service.RecordHealthCareDataService;
import com.xdht.disease.sys.service.RecordHealthCareService;
import com.xdht.disease.sys.vo.request.RecordHealthCareRequest;
import com.xdht.disease.sys.vo.response.RecordHealthCareResponse;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
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
public class RecordHealthCareServiceImpl extends AbstractService<RecordHealthCare> implements RecordHealthCareService{

    @Autowired
    private RecordHealthCareMapper recordHealthCareMapper;
    @Autowired
    private RecordHealthCareDataService recordHealthCareDataService;

    @Override
    public List<RecordHealthCare> queryList(RecordHealthCareRequest recordHealthCareRequest) {
        RecordHealthCare recordHealthCare = recordHealthCareRequest.getRecordHealthCare();
        Condition condition = new Condition(RecordHealthCare.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCare.getId())
                .andEqualTo("healthCareNo",recordHealthCare.getHealthCareNo());
        if (recordHealthCare.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthCare.getVerificationResult()+"%");
        }
        if (recordHealthCare.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthCare.getStatus());
        }
        return this.recordHealthCareMapper.selectByCondition(condition);

    }

    @Override
    public PageResult<RecordHealthCare> queryListPage(RecordHealthCareRequest recordHealthCareRequest, Integer pageNum, Integer pageSize) {
        RecordHealthCare recordHealthCare = recordHealthCareRequest.getRecordHealthCare();
        Condition condition = new Condition(RecordHealthCare.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCare.getId())
                .andEqualTo("healthCareNo",recordHealthCare.getHealthCareNo());
        if (recordHealthCare.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthCare.getVerificationResult()+"%");
        }
        if (recordHealthCare.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthCare.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHealthCare> dataList = this.recordHealthCareMapper.selectByCondition(condition);
        PageResult<RecordHealthCare> pageList = new  PageResult<RecordHealthCare>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordHealthCareRequest recordHealthCareRequest) {
        RecordHealthCare recordHealthCare = recordHealthCareRequest.getRecordHealthCare();
        recordHealthCare.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordHealthCare);
        List<RecordHealthCareData> recordRecordHealthCareDataList = new LinkedList<>();
        for (RecordHealthCareData recordHealthCareData : recordHealthCareRequest.getRecordHealthCareDataList() ) {
            recordHealthCareData.setHealthCareId(recordHealthCare.getId());
            recordRecordHealthCareDataList.add(recordHealthCareData);
        }
        this.recordHealthCareDataService.insertList(recordRecordHealthCareDataList);
    }

    @Override
    public RecordHealthCare delete(Long id) {
            this.recordHealthCareMapper.deleteByPrimaryKey(id);
            RecordHealthCare recordHealthCare = new RecordHealthCare();
            recordHealthCare.setId(id);
            return recordHealthCare;
    }

    @Override
    public void update(RecordHealthCareRequest recordHealthCareRequest) {
        RecordHealthCare recordHealthCare = recordHealthCareRequest.getRecordHealthCare();
        this.updateByPrimaryKeySelective(recordHealthCare);
        List<RecordHealthCareData> recordHealthCareDataList = recordHealthCareRequest.getRecordHealthCareDataList();
        for (RecordHealthCareData recordHealthCareData : recordHealthCareDataList) {
            this.recordHealthCareDataService.updateByPrimaryKeySelective(recordHealthCareData);
        }
    }

    @Override
    public RecordHealthCareResponse queryRecordHealthCareDetail(Long id) {
        RecordHealthCareResponse recordHealthCareResponse = new RecordHealthCareResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordHealthCareMapper.selectRecordHealthCareBySceneId(id);
        if (map != null){
            recordHealthCareResponse.setRecordHealthCare(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordHealthCareDataService.queryRecordHealthCareDataByRecordHealthCareId(recordId);
            recordHealthCareResponse.setRecordHealthCareDataList(mapList);
        }
        return recordHealthCareResponse;
    }

}
