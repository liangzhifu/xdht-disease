package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEmployeeSummaryMapper;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.sys.service.RecordEmployeeSummaryService;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

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
    public List<RecordEmployeeSummary> queryList(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        Condition condition = new Condition(RecordEmployeeSummary.class);
        condition.createCriteria() .andEqualTo("id", recordEmployeeSummaryRequest.getId())
                .andEqualTo("empId",recordEmployeeSummaryRequest.getEmpId())
                .andEqualTo("officeId",recordEmployeeSummaryRequest.getOfficeId())
                .andEqualTo("workType",recordEmployeeSummaryRequest.getWorkType());
        if (recordEmployeeSummaryRequest.getName() != null){
            condition.getOredCriteria().get(0).andEqualTo("name",recordEmployeeSummaryRequest.getName());
        }
        return this.recordEmployeeSummaryMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEmployeeSummary> queryListPage(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        Condition condition = new Condition(RecordEmployeeSummary.class);
        condition.createCriteria() .andEqualTo("id", recordEmployeeSummaryRequest.getId())
                .andEqualTo("empId",recordEmployeeSummaryRequest.getEmpId())
                .andEqualTo("officeId",recordEmployeeSummaryRequest.getOfficeId())
                .andEqualTo("workType",recordEmployeeSummaryRequest.getWorkType());
        if (recordEmployeeSummaryRequest.getName() != null){
            condition.getOredCriteria().get(0).andLike("name","%" + recordEmployeeSummaryRequest.getName() + "%");
        }
        PageHelper.startPage(recordEmployeeSummaryRequest.getPageNumber(), recordEmployeeSummaryRequest.getPageSize());
        List<RecordEmployeeSummary> dataList = this.selectByCondition(condition);
        Integer count =  this.selectCountByCondition(condition);
        PageResult<RecordEmployeeSummary> pageList = new PageResult<>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEmployeeSummary add(RecordEmployeeSummaryResponse employeeSummaryResponse) {
        employeeSummaryResponse.getEmployeeSummary().setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        RecordEmployeeSummary employeeSummary = employeeSummaryResponse.getEmployeeSummary();
        this.insertUseGeneratedKeys(employeeSummary);
        return employeeSummary;
    }

    @Override
    public RecordEmployeeSummary delete(Long id) {
        RecordEmployeeSummary recordEmployeeSummary1 = this.recordEmployeeSummaryMapper.selectByPrimaryKey(id);
        recordEmployeeSummary1.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEmployeeSummaryMapper.updateByPrimaryKeySelective(recordEmployeeSummary1);
        RecordEmployeeSummary recordEmployeeSummary =  new RecordEmployeeSummary();
        recordEmployeeSummary.setId(id);
        return  recordEmployeeSummary;
    }

    @Override
    public RecordEmployeeSummaryResponse update(RecordEmployeeSummaryResponse recordEmployeeSummaryResponse) {
        RecordEmployeeSummary employeeSummary = recordEmployeeSummaryResponse.getEmployeeSummary();
        this.recordEmployeeSummaryMapper.updateByPrimaryKeySelective(employeeSummary);
        return  recordEmployeeSummaryResponse;
    }

    @Override
    public RecordEmployeeSummaryResponse getRecordEmployeeSummaryDetail(Long id) {
        RecordEmployeeSummary recordEmployeeSummary = this.selectByPrimaryKey(id);
        RecordEmployeeSummaryResponse recordEmployeeSummaryResponse = new RecordEmployeeSummaryResponse();
        recordEmployeeSummaryResponse.setEmployeeSummary(recordEmployeeSummary);
        return recordEmployeeSummaryResponse;
    }
}
