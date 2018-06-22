package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEquipmentMapper;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.service.RecordEquipmentDataService;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.RecordEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentDetailResponse;
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
public class RecordEquipmentServiceImpl extends AbstractService<RecordEquipment> implements RecordEquipmentService{

    @Autowired
    private RecordEquipmentMapper recordEquipmentMapper;

    @Autowired
    private RecordEquipmentDataService recordEquipmentDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Override
    public List<RecordEquipment> queryList(RecordEquipmentRequest recordEquipmentRequest) {
        Condition condition = new Condition(RecordEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentRequest.getId())
                .andEqualTo("equipmentNo",recordEquipmentRequest.getEquipmentNo());
        if (recordEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentRequest.getStatus());
        }
        return this.recordEquipmentMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipment> queryListPage(RecordEquipmentRequest recordEquipmentRequest) {
        Condition condition = new Condition(RecordEquipment.class);
        if (recordEquipmentRequest.getEquipmentNo() != null) {
            condition.createCriteria().andLike("equipmentNo","%"+recordEquipmentRequest.getEquipmentNo()+"%");
        }
//        condition.createCriteria() .andEqualTo("id", recordEquipmentRequest.getId())
//                .andEqualTo("equipmentNo",recordEquipmentRequest.getEquipmentNo());
//        if (recordEquipmentRequest.getVerificationResult() != null) {
//            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentRequest.getVerificationResult()+"%");
//        }
//        if (recordEquipmentRequest.getStatus() != null){
//            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentRequest.getStatus());
//        }
        PageHelper.startPage(recordEquipmentRequest.getPageNumber(), recordEquipmentRequest.getPageSize());
        List<RecordEquipment> dataList = this.recordEquipmentMapper.selectByCondition(condition);
        Integer count = this.recordEquipmentMapper.selectCountByCondition(condition);
        PageResult<RecordEquipment> pageList = new  PageResult<RecordEquipment>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipment add(RecordEquipmentInputRequest recordEquipmentInputRequest) {
        RecordEquipment recordEquipment = new RecordEquipment();
        recordEquipment.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordEquipment.setEquipmentNo(recordEquipmentInputRequest.getRecordEquipment().getEquipmentNo());
        recordEquipment.setVerificationResult(recordEquipmentInputRequest.getRecordEquipment().getVerificationResult());
        this.insertUseGeneratedKeys(recordEquipment);
        List<RecordEquipmentData> recordEquipmentDataList = new LinkedList<>();
        for (RecordEquipmentData recordEquipmentData : recordEquipmentInputRequest.getRecordEquipmentDataList()) {
            recordEquipmentData.setRelationId(recordEquipment.getId());
            recordEquipmentDataList.add(recordEquipmentData);
        }
        this.recordEquipmentDataService.insertList(recordEquipmentDataList);
        return recordEquipment;
    }

    @Override
    public RecordEquipment delete(Long id) {

        RecordEquipment recordEquipment = this.recordEquipmentMapper.selectByPrimaryKey(id);
        recordEquipment.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEquipmentMapper.updateByPrimaryKeySelective(recordEquipment);
        return recordEquipment;
    }

    @Override
    public RecordEquipment update(RecordEquipmentInputRequest recordEquipmentInputRequest) {
//        RecordEquipment recordEquipment = new RecordEquipment();
//        recordEquipment.setId(recordEquipmentInputRequest.getRecordEquipment().getId());
        RecordEquipment recordEquipment = recordEquipmentInputRequest.getRecordEquipment();
        List<RecordEquipmentData> recordEquipmentDataList = new LinkedList<>();
        for ( RecordEquipmentData recordEquipmentData : recordEquipmentInputRequest.getRecordEquipmentDataList()) {
            this.recordEquipmentDataService.updateByPrimaryKeySelective(recordEquipmentData);
        }
        this.recordEquipmentMapper.updateByPrimaryKeySelective(recordEquipment);
        return recordEquipment;
    }

    @Override
    public RecordEquipmentDetailResponse queryEquipmentDetail(Long id) {
        RecordEquipmentDetailResponse response = new RecordEquipmentDetailResponse();
        RecordEquipment recordEquipment = new RecordEquipment();
        recordEquipment.setSceneId(id);
        recordEquipment =  this.recordEquipmentMapper.selectOne(recordEquipment);
        if (recordEquipment != null) {
            Long recordId = recordEquipment.getId();
            response.setRecordEquipment(recordEquipment);
            Condition condition = new Condition(RecordEquipmentData.class);
            condition.createCriteria() .andEqualTo("relationId", recordId);
            List<RecordEquipmentData> recordEquipmentDataList = this.recordEquipmentDataService.selectByCondition(condition);
            response.setRecordEquipmentDataList(recordEquipmentDataList);
            String officeIds = "";
            for (RecordEquipmentData recordData : recordEquipmentDataList) {
                officeIds += recordData.getOfficdId()+",";
            }
            officeIds = officeIds.substring(0,officeIds.lastIndexOf(","));
            List<SysCompanyOffice> officeList = this.sysCompanyOfficeService.selectByIds(officeIds);
            response.setSysCompanyOfficeList(officeList);
        }
        return response;
    }
}
