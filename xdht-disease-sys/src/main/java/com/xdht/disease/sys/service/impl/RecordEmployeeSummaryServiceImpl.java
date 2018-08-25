package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEmployeeSummaryMapper;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.sys.service.RecordEmployeeSummaryService;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.Calendar;
import java.util.List;


/**
 * Created by lzf on 2018/06/21.
 */
@Service
@Transactional
public class RecordEmployeeSummaryServiceImpl extends AbstractService<RecordEmployeeSummary> implements RecordEmployeeSummaryService {

    @Autowired
    private RecordEmployeeSummaryMapper recordEmployeeSummaryMapper;

    @Override
    public PageResult<RecordEmployeeSummaryResponse> queryListPage(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        Integer start = (recordEmployeeSummaryRequest.getPageNumber() - 1) * recordEmployeeSummaryRequest.getPageSize();
        recordEmployeeSummaryRequest.setStart(start);
        List<RecordEmployeeSummaryResponse> dataList = this.recordEmployeeSummaryMapper.selectRecordEmployeeSummaryList(recordEmployeeSummaryRequest);
        Integer count = this.recordEmployeeSummaryMapper.selectRecordEmployeeSummaryCount(recordEmployeeSummaryRequest);
        PageResult<RecordEmployeeSummaryResponse> pageList = new PageResult<>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordEmployeeSummary recordEmployeeSummary) throws  Exception{
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(recordEmployeeSummary.getInspectDate());
        recordEmployeeSummary.setInspectYear(calendar.get(calendar.YEAR));
        Condition condition=new Condition(RecordEmployeeSummary.class);
        condition.createCriteria().andEqualTo("empId",recordEmployeeSummary.getEmpId())
                .andEqualTo("inspectYear",recordEmployeeSummary.getInspectYear()).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<RecordEmployeeSummary> list = this.selectByCondition(condition);
        if(list.size()>0){
         throw new Exception("企业员工在该年份已经体检完毕，请勿重复提交");
        }


        recordEmployeeSummary.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordEmployeeSummary);
    }

    @Override
    public void delete(Long id) {
        RecordEmployeeSummary recordEmployeeSummary = new RecordEmployeeSummary();
        recordEmployeeSummary.setId(id);
        recordEmployeeSummary.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEmployeeSummaryMapper.updateByPrimaryKeySelective(recordEmployeeSummary);
    }

    @Override
    public void update(RecordEmployeeSummary recordEmployeeSummary) {
        this.recordEmployeeSummaryMapper.updateByPrimaryKeySelective(recordEmployeeSummary);
    }

    @Override
    public RecordEmployeeSummaryResponse getRecordEmployeeSummaryDetail(Long id) {
        return this.recordEmployeeSummaryMapper.selectRecordEmployeeSummaryDetail(id);
    }

    @Override
    public List<RecordEmployeeSummaryResponse> getRecordEmployeeSummaryEcharsDetail(Long id) {
        List<RecordEmployeeSummaryResponse> list = this.recordEmployeeSummaryMapper.selectRecordEmployeeSummaryEcharsDetail(id);
        return list;
    }
}
