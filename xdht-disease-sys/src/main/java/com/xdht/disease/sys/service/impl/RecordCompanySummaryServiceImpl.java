package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordCompanySummaryMapper;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.service.RecordCompanySummaryService;
import com.xdht.disease.sys.vo.request.DateRequest;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryEchartsResponse;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryResponse;
import com.xdht.disease.sys.vo.response.YearResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.Calendar;
import java.util.Date;
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
    public PageResult<RecordCompanySummaryResponse> queryListPage(RecordCompanySummaryRequest recordCompanySummaryRequest) {
        Integer start = (recordCompanySummaryRequest.getPageNumber() - 1) * recordCompanySummaryRequest.getPageSize();
        recordCompanySummaryRequest.setStart(start);
        List<RecordCompanySummaryResponse> recordCompanySummaryResponseList = this.recordCompanySummaryMapper.setRecordCompanySummaryList(recordCompanySummaryRequest);
        Integer count = this.recordCompanySummaryMapper.setRecordCompanySummaryCount(recordCompanySummaryRequest);
        PageResult<RecordCompanySummaryResponse> pageList = new  PageResult<>();
        pageList.setTotal(count);
        pageList.setDataList(recordCompanySummaryResponseList);
        return pageList;
    }

    @Override
    public void add(RecordCompanySummary recordCompanySummary)throws Exception {
        Date inspectionDate = recordCompanySummary.getInspectionDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inspectionDate);
        recordCompanySummary.setInspectionYear(cal.get(Calendar.YEAR));
        Condition condition =new Condition(RecordCompanySummary.class);
        condition.createCriteria().andEqualTo("companyId",recordCompanySummary.getCompanyId()).
      andEqualTo("inspectionYear",recordCompanySummary.getInspectionYear()).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());

        List<RecordCompanySummary> list =this.selectByCondition(condition);
        if(list.size()>0){
           throw new Exception("该企业在该年份已经进行了体检，不可重复提交");
        }

        recordCompanySummary.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordCompanySummary);
    }

    @Override
    public void delete(Long id) {
        RecordCompanySummary recordCompanySummary = new RecordCompanySummary();
        recordCompanySummary.setId(id);
        recordCompanySummary.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(recordCompanySummary);
    }

    @Override
    public void update(RecordCompanySummary recordCompanySummary) {
        Date inspectionDate = recordCompanySummary.getInspectionDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inspectionDate);
        recordCompanySummary.setInspectionYear(cal.get(Calendar.YEAR));
        this.updateByPrimaryKeySelective(recordCompanySummary);
    }

    @Override
    public List<RecordCompanySummaryEchartsResponse> selectCompanySummaryEcharts(DateRequest dateRequest) {
        List<RecordCompanySummaryEchartsResponse> list = this.recordCompanySummaryMapper.selectCompanySummaryEcharts(dateRequest);
        return list;
    }

    @Override
    public List<RecordCompanySummaryEchartsResponse> selectCompanySummaryPercentEcharts(DateRequest dateRequest) {
        List<RecordCompanySummaryEchartsResponse> list = this.recordCompanySummaryMapper.selectCompanySummaryPercentEcharts(dateRequest);
        return list;
    }

    @Override
    public List<YearResponse> selectCompanySummaryYear() {
        List<YearResponse> list = this.recordCompanySummaryMapper.selectCompanySummarYear();
        return list;
    }

}
