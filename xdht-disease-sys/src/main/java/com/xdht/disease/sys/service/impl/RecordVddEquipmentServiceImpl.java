package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordVddEquipmentMapper;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.model.RecordVddEquipmentData;
import com.xdht.disease.sys.service.RecordVddEquipmentDataService;
import com.xdht.disease.sys.service.RecordVddEquipmentService;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordVddEquipmentDetailResponse;
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
public class RecordVddEquipmentServiceImpl extends AbstractService<RecordVddEquipment> implements RecordVddEquipmentService{

    @Autowired
    private RecordVddEquipmentMapper recordVddEquipmentMapper;

    @Autowired
    private RecordVddEquipmentDataService recordVddEquipmentDataService;


    @Override
    public PageResult<RecordVddEquipment> queryListPage(RecordVddEquipmentRequest recordVddEquipmentRequest) {
        Condition condition = new Condition(RecordVddEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordVddEquipmentRequest.getId());
        if (recordVddEquipmentRequest.getVddEquipmentNo() != null) {
            condition.getOredCriteria().get(0).andLike("vddEquipmentNo","%"+recordVddEquipmentRequest.getVddEquipmentNo()+"%");
        }
        if (recordVddEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordVddEquipmentRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordVddEquipmentRequest.getPageNumber(), recordVddEquipmentRequest.getPageSize());
        List<RecordVddEquipment> dataList = this.recordVddEquipmentMapper.selectByCondition(condition);
        Integer count = this.recordVddEquipmentMapper.selectCountByCondition(condition);
        PageResult<RecordVddEquipment> pageList = new  PageResult<RecordVddEquipment>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordVddEquipmentInputRequest recordVddEquipmentInputRequest) {
        RecordVddEquipment recordVddEquipment = recordVddEquipmentInputRequest.getRecordVddEquipment();
        recordVddEquipment.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordVddEquipment);
        List<RecordVddEquipmentData> recordVddEquipmentDataList = new LinkedList<>();
        if (recordVddEquipmentInputRequest.getRecordVddEquipmentDataList() != null ) {
            for ( RecordVddEquipmentData recordVddEquipmentData : recordVddEquipmentInputRequest.getRecordVddEquipmentDataList()) {
                recordVddEquipmentData.setRelationId(recordVddEquipment.getId());
                recordVddEquipmentDataList.add(recordVddEquipmentData);
            }
            this.recordVddEquipmentDataService.insertList(recordVddEquipmentDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordVddEquipment recordVddEquipment = new RecordVddEquipment();
        recordVddEquipment.setId(id);
        recordVddEquipment.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordVddEquipmentMapper.updateByPrimaryKeySelective(recordVddEquipment);
    }

    @Override
    public void update(RecordVddEquipmentInputRequest recordVddEquipmentInputRequest) {
        RecordVddEquipment recordVddEquipment = recordVddEquipmentInputRequest.getRecordVddEquipment();
        this.recordVddEquipmentMapper.updateByPrimaryKeySelective(recordVddEquipment);

        Condition condition = new Condition(RecordVddEquipmentData.class);
        condition.createCriteria().andEqualTo("relationId", recordVddEquipment.getId());
        List<RecordVddEquipmentData> recordVddEquipmentDataList = this.recordVddEquipmentDataService.selectByCondition(condition);
        if (recordVddEquipmentDataList != null && recordVddEquipmentDataList.size() > 0) {
            for ( RecordVddEquipmentData recordVddEquipmentData : recordVddEquipmentDataList) {
                this.recordVddEquipmentDataService.deleteByPrimaryKey(recordVddEquipmentData.getId());
            }
        }
        recordVddEquipmentDataList = new LinkedList<>();
        if (recordVddEquipmentInputRequest.getRecordVddEquipmentDataList() != null) {
            for (RecordVddEquipmentData recordVddEquipmentData : recordVddEquipmentInputRequest.getRecordVddEquipmentDataList()) {
                 recordVddEquipmentData.setRelationId(recordVddEquipment.getId());
                 recordVddEquipmentDataList.add(recordVddEquipmentData);
            }
        this.recordVddEquipmentDataService.insertList(recordVddEquipmentDataList);
        }
    }

    @Override
    public RecordVddEquipmentDetailResponse queryVddEquipmentDetail(Long id) {
        RecordVddEquipmentDetailResponse response = new RecordVddEquipmentDetailResponse();
        Map<String, Object> map = this.recordVddEquipmentMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordVddEquipment(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordVddEquipmentDataService.queryRecordDataByVddEquipment(recordId);
            response.setRecordVddEquipmentDataList(mapList);
        }
        return response;
    }
}
