package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPostPersonnelMapper;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.service.RecordPostPersonnelService;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;
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
public class RecordPostPersonnelServiceImpl extends AbstractService<RecordPostPersonnel> implements RecordPostPersonnelService{

    @Autowired
    private RecordPostPersonnelMapper recordPostPersonnelMapper;

//    @Override
//    public List<RecordPostPersonnel> queryList(RecordPostPersonnelRequest recordRequest) {
//        Condition condition = new Condition(RecordPostPersonnel.class);
//        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
//                .andEqualTo("postPersonnelNo",recordRequest.getPostPersonnelNo());
//        if (recordRequest.getVerificationResult() != null) {
//            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
//        }
//        if (recordRequest.getStatus() != null){
//            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
//        }
//        return this.recordPostPersonnelMapper.selectByCondition(condition);
//    }
//
//    @Override
//    public PageResult<RecordPostPersonnel> queryListPage(RecordPostPersonnelRequest recordRequest, Integer pageNum, Integer pageSize) {
//        Condition condition = new Condition(RecordPostPersonnel.class);
//        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
//                .andEqualTo("postPersonnelNo",recordRequest.getPostPersonnelNo());
//        if (recordRequest.getVerificationResult() != null) {
//            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
//        }
//        if (recordRequest.getStatus() != null){
//            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
//        }
//        PageHelper.startPage(pageNum, pageSize);
//        List<RecordPostPersonnel> dataList = this.recordPostPersonnelMapper.selectByCondition(condition);
//        PageResult<RecordPostPersonnel> pageList = new  PageResult<RecordPostPersonnel>();
//        pageList.setTotal(dataList.size());
//        pageList.setDataList(dataList);
//        return pageList;
//    }

    @Override
    public RecordPostPersonnel add(RecordPostPersonnel recordPostPersonnel) {
            this.recordPostPersonnelMapper.insertUseGeneratedKeys(recordPostPersonnel);
            return recordPostPersonnel;
    }

    @Override
    public RecordPostPersonnel delete(Long id) {
        this.recordPostPersonnelMapper.deleteByPrimaryKey(id);
        RecordPostPersonnel recordPostPersonnel = new RecordPostPersonnel();
        recordPostPersonnel.setId(id);
        return recordPostPersonnel;
    }

    @Override
    public RecordPostPersonnel update(RecordPostPersonnel recordPostPersonnel) {
        this.recordPostPersonnelMapper.updateByPrimaryKeySelective(recordPostPersonnel);
        return recordPostPersonnel;
    }
}
