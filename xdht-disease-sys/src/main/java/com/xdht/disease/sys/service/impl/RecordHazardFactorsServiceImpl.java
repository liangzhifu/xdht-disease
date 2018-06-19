package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHazardFactorsMapper;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.service.RecordHazardFactorsService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;
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
public class RecordHazardFactorsServiceImpl extends AbstractService<RecordHazardFactors> implements RecordHazardFactorsService{

    @Autowired
    private RecordHazardFactorsMapper recordHazardFactorsMapper;

    @Override
    public List<RecordHazardFactors> queryList(RecordHazardFactorsRequest recordHazardFactorsRequest) {
        Condition condition = new Condition(RecordHazardFactors.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsRequest.getId())
                .andEqualTo("hazardFactorsNo",recordHazardFactorsRequest.getHazardFactorsNo());
        if (recordHazardFactorsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHazardFactorsRequest.getVerificationResult()+"%");
        }
        if (recordHazardFactorsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHazardFactorsRequest.getStatus());
        }
        return this.recordHazardFactorsMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHazardFactors> queryListPage(RecordHazardFactorsRequest recordHazardFactorsRequest) {
        Condition condition = new Condition(RecordHazardFactors.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsRequest.getId())
                .andEqualTo("hazardFactorsNo",recordHazardFactorsRequest.getHazardFactorsNo());
        if (recordHazardFactorsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHazardFactorsRequest.getVerificationResult()+"%");
        }
        if (recordHazardFactorsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHazardFactorsRequest.getStatus());
        }
        PageHelper.startPage(recordHazardFactorsRequest.getPageNumber(), recordHazardFactorsRequest.getPageSize());
        List<RecordHazardFactors> dataList = this.recordHazardFactorsMapper.selectByCondition(condition);
        Integer count = this.recordHazardFactorsMapper.selectCountByCondition(condition);
        PageResult<RecordHazardFactors> pageList = new  PageResult<RecordHazardFactors>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;

    }

    @Override
    public RecordHazardFactors add(RecordHazardFactors recordHazardFactors) {
            this.recordHazardFactorsMapper.insertUseGeneratedKeys(recordHazardFactors);
            return recordHazardFactors;
    }

    @Override
    public RecordHazardFactors delete(Long id) {
            this.recordHazardFactorsMapper.deleteByPrimaryKey(id);
            RecordHazardFactors recordHazardFactors = new RecordHazardFactors();
            recordHazardFactors.setId(id);
            return  recordHazardFactors;
    }

    @Override
    public RecordHazardFactors update(RecordHazardFactors recordHazardFactors) {
        this.recordHazardFactorsMapper.updateByPrimaryKeySelective(recordHazardFactors);
        return recordHazardFactors;
    }
}
