package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordFundsMapper;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.model.RecordFundsData;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.service.RecordFundsDataService;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
import com.xdht.disease.sys.vo.response.RecordFundsDetailResponse;
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
public class RecordFundsServiceImpl extends AbstractService<RecordFunds> implements RecordFundsService{

    @Autowired
    private RecordFundsMapper recordFundsMapper;
    @Autowired
    private RecordFundsDataService recordFundsDataService;

    @Override
    public List<RecordFunds> queryList(RecordFundsRequest recordFundsRequest) {
        RecordFunds recordFunds = recordFundsRequest.getRecordFunds();
        Condition condition = new Condition(RecordFunds.class);
        condition.createCriteria() .andEqualTo("id", recordFunds.getId())
                .andEqualTo("fundsNo",recordFunds.getFundsNo());
        if (recordFunds.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordFunds.getVerificationResult()+"%");
        }
        if (recordFunds.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordFunds.getStatus());
        }
        return this.recordFundsMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordFunds> queryListPage(RecordFundsRequest recordFundsRequest, Integer pageNum, Integer pageSize) {
        RecordFunds recordFunds = recordFundsRequest.getRecordFunds();
        Condition condition = new Condition(RecordFunds.class);
        condition.createCriteria() .andEqualTo("id", recordFunds.getId())
                .andEqualTo("fundsNo",recordFunds.getFundsNo());
        if (recordFunds.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordFunds.getVerificationResult()+"%");
        }
        if (recordFunds.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordFunds.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordFunds> dataList = this.recordFundsMapper.selectByCondition(condition);
        PageResult<RecordFunds> pageList = new  PageResult<RecordFunds>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordFundsRequest recordFundsRequest) {
        RecordFunds recordFunds = recordFundsRequest.getRecordFunds();
        recordFunds.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordFunds);
        List<RecordFundsData> recordFundsDataList = new LinkedList<>();
        for (RecordFundsData recordFundsData : recordFundsRequest.getRecordFundsDataList() ) {
            recordFundsData.setFundsId(recordFunds.getId());
            recordFundsDataList.add(recordFundsData);
        }
        this.recordFundsDataService.insertList(recordFundsDataList);
    }

    @Override
    public RecordFunds delete(Long id) {
            this.recordFundsMapper.deleteByPrimaryKey(id);
            RecordFunds recordFunds = new RecordFunds();
            recordFunds.setId(id);
            return recordFunds;
    }

    @Override
    public void update(RecordFundsRequest recordFundsRequest) {
        RecordFunds recordFunds = recordFundsRequest.getRecordFunds();
        this.updateByPrimaryKeySelective(recordFunds);
        List<RecordFundsData> recordFundsDataList = recordFundsRequest.getRecordFundsDataList();
        for (RecordFundsData recordFundsData : recordFundsDataList) {
            this.recordFundsDataService.updateByPrimaryKeySelective(recordFundsData);
        }
    }

    @Override
    public RecordFundsDetailResponse queryRecordFundsDetail(Long id) {
        RecordFundsDetailResponse recordFundsDetailResponse = new RecordFundsDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordFundsMapper.selectRecordFundsBySceneId(id);
        if (map != null){
            recordFundsDetailResponse.setRecordFunds(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordFundsDataService.queryRecordFundsDataByFundsId(recordId);
            recordFundsDetailResponse.setRecordFundsDataList(mapList);
        }
        return recordFundsDetailResponse;
    }
}
