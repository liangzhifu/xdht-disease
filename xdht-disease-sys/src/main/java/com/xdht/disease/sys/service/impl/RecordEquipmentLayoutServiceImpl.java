package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEquipmentLayoutMapper;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.service.RecordEquipmentLayoutDataService;
import com.xdht.disease.sys.service.RecordEquipmentLayoutService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentLayoutDetailResponse;
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
public class RecordEquipmentLayoutServiceImpl extends AbstractService<RecordEquipmentLayout> implements RecordEquipmentLayoutService{

    @Autowired
    private RecordEquipmentLayoutMapper recordEquipmentLayoutMapper;

    @Autowired
    private RecordEquipmentLayoutDataService recordEquipmentLayoutDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Override
    public List<RecordEquipmentLayout> queryList(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        Condition condition = new Condition(RecordEquipmentLayout.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutRequest.getId())
                .andEqualTo("equipmentLayoutNo",recordEquipmentLayoutRequest.getEquipmentLayoutNo());
        if (recordEquipmentLayoutRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentLayoutRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentLayoutRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentLayoutRequest.getStatus());
        }
        return this.recordEquipmentLayoutMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipmentLayout> queryListPage(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        Condition condition = new Condition(RecordEquipmentLayout.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutRequest.getId());
        if (recordEquipmentLayoutRequest.getEquipmentLayoutNo() != null) {
            condition.getOredCriteria().get(0).andLike("equipmentLayoutNo","%"+recordEquipmentLayoutRequest.getEquipmentLayoutNo()+"%");
        }
        if (recordEquipmentLayoutRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentLayoutRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentLayoutRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentLayoutRequest.getStatus());
        }
        PageHelper.startPage(recordEquipmentLayoutRequest.getPageNumber(), recordEquipmentLayoutRequest.getPageSize());
        List<RecordEquipmentLayout> dataList = this.recordEquipmentLayoutMapper.selectByCondition(condition);
        Integer count = this.recordEquipmentLayoutMapper.selectCountByCondition(condition);
        PageResult<RecordEquipmentLayout> pageList = new  PageResult<RecordEquipmentLayout>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipmentLayout add(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        RecordEquipmentLayout recordEquipmentLayout = new RecordEquipmentLayout();
        recordEquipmentLayout.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordEquipmentLayout.setEquipmentLayoutNo(recordEquipmentLayoutInputRequest.getRecordEquipmentLayout().getEquipmentLayoutNo());
        recordEquipmentLayout.setVerificationResult(recordEquipmentLayoutInputRequest.getRecordEquipmentLayout().getVerificationResult());
        this.insertUseGeneratedKeys(recordEquipmentLayout);
        List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList = new LinkedList<>();
        for (RecordEquipmentLayoutData recordEquipmentLayoutData : recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList()) {
            recordEquipmentLayoutData.setRelationId(recordEquipmentLayout.getId());
            recordEquipmentLayoutDataList.add(recordEquipmentLayoutData);
        }
        this.recordEquipmentLayoutDataService.insertList(recordEquipmentLayoutDataList);
        return recordEquipmentLayout;
    }

    @Override
    public RecordEquipmentLayout delete(Long id) {
            RecordEquipmentLayout recordEquipmentLayout = this.recordEquipmentLayoutMapper.selectByPrimaryKey(id);
            recordEquipmentLayout.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.recordEquipmentLayoutMapper.updateByPrimaryKeySelective(recordEquipmentLayout);
            return recordEquipmentLayout;

    }

    @Override
    public RecordEquipmentLayout update(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        RecordEquipmentLayout recordEquipmentLayout = recordEquipmentLayoutInputRequest.getRecordEquipmentLayout();
        for ( RecordEquipmentLayoutData recordEquipmentLayoutData : recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList() ) {
            this.recordEquipmentLayoutDataService.updateByPrimaryKeySelective(recordEquipmentLayoutData);
        }
        this.recordEquipmentLayoutMapper.updateByPrimaryKeySelective(recordEquipmentLayout);
        return recordEquipmentLayout;
    }

    @Override
    public RecordEquipmentLayoutDetailResponse queryEquipmentLayoutDetail(Long id) {
        RecordEquipmentLayoutDetailResponse response = new RecordEquipmentLayoutDetailResponse();
        RecordEquipmentLayout recordEquipmentLayout = this.recordEquipmentLayoutMapper.selectByPrimaryKey(id);
        response.setRecordEquipmentLayout(recordEquipmentLayout);
        Condition condition = new Condition(RecordEquipmentLayoutData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList = this.recordEquipmentLayoutDataService.selectByCondition(condition);
        response.setRecordEquipmentLayoutDataList(recordEquipmentLayoutDataList);
        String officeIds = "";
        for (RecordEquipmentLayoutData recordData : recordEquipmentLayoutDataList) {
            officeIds += recordData.getOfficdId()+",";
        }
        officeIds = officeIds.substring(0,officeIds.lastIndexOf(","));
        List<SysCompanyOffice> officeList = this.sysCompanyOfficeService.selectByIds(officeIds);
        response.setSysCompanyOfficeList(officeList);
        return response;
    }
}
