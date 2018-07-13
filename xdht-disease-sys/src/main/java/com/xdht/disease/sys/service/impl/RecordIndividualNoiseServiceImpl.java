package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordIndividualNoiseMapper;
import com.xdht.disease.sys.model.RecordIndividualNoise;
import com.xdht.disease.sys.service.RecordIndividualNoiseService;
import com.xdht.disease.sys.vo.request.RecordIndividualNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualNoiseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/07/11.
 */
@Service
@Transactional
public class RecordIndividualNoiseServiceImpl extends AbstractService<RecordIndividualNoise> implements RecordIndividualNoiseService {

    @Autowired
    private RecordIndividualNoiseMapper recordIndividualNoiseMapper;

    @Override
    public void add(RecordIndividualNoise recordIndividualNoise) {
        recordIndividualNoise.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordIndividualNoise);
    }

    @Override
    public void delete(Long id) {
        RecordIndividualNoise recordIndividualNoise = new RecordIndividualNoise();
        recordIndividualNoise.setId(id);
        recordIndividualNoise.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordIndividualNoiseMapper.updateByPrimaryKeySelective(recordIndividualNoise);
    }

    @Override
    public void update(RecordIndividualNoise recordIndividualNoise) {
        this.updateByPrimaryKeySelective(recordIndividualNoise);
    }

    @Override
    public RecordIndividualNoise queryNoiseDetail(Long id) {
        RecordIndividualNoise recordIndividualNoise = this.selectByPrimaryKey(id);
        return recordIndividualNoise;
    }

    @Override
    public PageResult<RecordIndividualNoise> queryListPage(RecordIndividualNoiseRequest recordIndividualNoiseRequest) {
        Condition condition =  new Condition(RecordIndividualNoise.class);
        condition.createCriteria() .andEqualTo("id", recordIndividualNoiseRequest.getId())
                                    .andEqualTo("postId",recordIndividualNoiseRequest.getPostId());
        if (recordIndividualNoiseRequest.getStopPlace() != null && !"".equals(recordIndividualNoiseRequest.getStopPlace())){
            condition.getOredCriteria().get(0).andLike("stopPlace","%"+ recordIndividualNoiseRequest.getStopPlace()+ "%");
        }
        if (recordIndividualNoiseRequest.getWorkshop() != null && !"".equals(recordIndividualNoiseRequest.getWorkshop())) {
            condition.getOredCriteria().get(0).andLike("workshop","%"+ recordIndividualNoiseRequest.getWorkshop()+ "%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        condition.orderBy("id").desc();
        PageHelper.startPage(recordIndividualNoiseRequest.getPageNumber(), recordIndividualNoiseRequest.getPageSize());
        List<RecordIndividualNoise> dataList = this.recordIndividualNoiseMapper.selectByCondition(condition);
        Integer count = this.recordIndividualNoiseMapper.selectCountByCondition(condition);
        PageResult<RecordIndividualNoise> pageList = new  PageResult<RecordIndividualNoise>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public List<RecordIndividualNoiseResponse> queryNoiseEchartsDetail() {
        List<RecordIndividualNoiseResponse> list = this.recordIndividualNoiseMapper.selectRecordIndividualNoiseEcharsDetail();
        return list;
    }
}
