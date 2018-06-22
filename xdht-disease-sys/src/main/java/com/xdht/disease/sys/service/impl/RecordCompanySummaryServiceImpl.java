package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordCompanySummaryMapper;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.service.RecordCompanySummaryService;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordCompanySummaryServiceImpl extends AbstractService<RecordCompanySummary> implements RecordCompanySummaryService{

    @Autowired
    private RecordCompanySummaryMapper recordCompanySummaryMapper;

    @Override
    public List<RecordCompanySummary> queryList(RecordCompanySummaryRequest recordCompanySummaryRequest) {
        Condition condition = new Condition(RecordCompanySummary.class);
        condition.createCriteria() .andEqualTo("id", recordCompanySummaryRequest.getId())
                .andEqualTo("companyId",recordCompanySummaryRequest.getCompanyId())
                .andEqualTo("inspectionDate",recordCompanySummaryRequest.getInspectionDate())
                .andEqualTo("inspectedNumber",recordCompanySummaryRequest.getInspectedNumber())
                .andEqualTo("actualInspectdNumber",recordCompanySummaryRequest.getActualInspectdNumber())
                .andEqualTo("noAbnormality",recordCompanySummaryRequest.getNoAbnormality())
                .andEqualTo("reviewNumber",recordCompanySummaryRequest.getReviewNumber())
                .andEqualTo("doubtfulNumber",recordCompanySummaryRequest.getDoubtfulNumber());
        if (recordCompanySummaryRequest.getInspectionAgency() != null) {
            condition.getOredCriteria().get(0).andLike("inspectionAgency","%"+recordCompanySummaryRequest.getInspectionAgency()+"%");
        }
        if (recordCompanySummaryRequest.getPhysicalExaminationType() != null){
            condition.getOredCriteria().get(0).andEqualTo("physicalExaminationType",recordCompanySummaryRequest.getPhysicalExaminationType());
        }
        return this.recordCompanySummaryMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordCompanySummary> queryListPage(RecordCompanySummaryRequest recordCompanySummaryRequest) {

        Condition condition = new Condition(RecordCompanySummary.class);
        condition.createCriteria() .andEqualTo("id", recordCompanySummaryRequest.getId())
                .andEqualTo("companyId",recordCompanySummaryRequest.getCompanyId())
                .andEqualTo("inspectionDate",recordCompanySummaryRequest.getInspectionDate())
                .andEqualTo("inspectedNumber",recordCompanySummaryRequest.getInspectedNumber())
                .andEqualTo("actualInspectdNumber",recordCompanySummaryRequest.getActualInspectdNumber())
                .andEqualTo("noAbnormality",recordCompanySummaryRequest.getNoAbnormality())
                .andEqualTo("reviewNumber",recordCompanySummaryRequest.getReviewNumber())
                .andEqualTo("doubtfulNumber",recordCompanySummaryRequest.getDoubtfulNumber());
        if (recordCompanySummaryRequest.getInspectionAgency() != null) {
            condition.getOredCriteria().get(0).andLike("inspectionAgency","%"+recordCompanySummaryRequest.getInspectionAgency()+"%");
        }
        if (recordCompanySummaryRequest.getPhysicalExaminationType() != null){
            condition.getOredCriteria().get(0).andEqualTo("physicalExaminationType",recordCompanySummaryRequest.getPhysicalExaminationType());
        }
        PageHelper.startPage(recordCompanySummaryRequest.getPageNumber(), recordCompanySummaryRequest.getPageSize());
        List<RecordCompanySummary> dataList = this.recordCompanySummaryMapper.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<RecordCompanySummary> pageList = new  PageResult<>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordCompanySummary add(RecordCompanySummary recordCompanySummary) {
        recordCompanySummary.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.recordCompanySummaryMapper.insertUseGeneratedKeys(recordCompanySummary);
            return recordCompanySummary;
    }

    @Override
    public RecordCompanySummary delete(Long id) {
        RecordCompanySummary recordCompanySummary1 = this.recordCompanySummaryMapper.selectByPrimaryKey(id);
        recordCompanySummary1.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordCompanySummaryMapper.updateByPrimaryKeySelective(recordCompanySummary1);
        RecordCompanySummary recordCompanySummary =  new RecordCompanySummary();
        recordCompanySummary.setId(id);
        return  recordCompanySummary;
    }

    @Override
    public RecordCompanySummary update(RecordCompanySummary recordCompanySummary) {
        this.recordCompanySummaryMapper.updateByPrimaryKeySelective(recordCompanySummary);
        return  recordCompanySummary;
    }
}
