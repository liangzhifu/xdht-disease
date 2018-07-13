package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordWorkplaceNoiseMapper;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.service.RecordWorkplaceNoiseService;
import com.xdht.disease.sys.vo.request.RecordWorkplaceNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;
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
public class RecordWorkplaceNoiseServiceImpl extends AbstractService<RecordWorkplaceNoise> implements RecordWorkplaceNoiseService {

    @Autowired
    private RecordWorkplaceNoiseMapper recordWorkplaceNoiseMapper;

    @Override
    public PageResult<RecordWorkplaceNoise> queryListPage(RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest) {
        Condition condition =  new Condition(RecordWorkplaceNoise.class);
        condition.createCriteria() .andEqualTo("id", recordWorkplaceNoiseRequest.getId())
                .andEqualTo("postId",recordWorkplaceNoiseRequest.getPostId());
        if (recordWorkplaceNoiseRequest.getStopPlace() != null) {
            condition.getOredCriteria().get(0).andLike("stopPlace","%"+ recordWorkplaceNoiseRequest.getStopPlace()+ "%");
        }
        if (recordWorkplaceNoiseRequest.getWorkshop() != null) {
            condition.getOredCriteria().get(0).andLike("workshop","%"+ recordWorkplaceNoiseRequest.getWorkshop()+ "%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        condition.orderBy("id").desc();
        PageHelper.startPage(recordWorkplaceNoiseRequest.getPageNumber(), recordWorkplaceNoiseRequest.getPageSize());
        List<RecordWorkplaceNoise> dataList = this.recordWorkplaceNoiseMapper.selectByCondition(condition);
        Integer count = this.recordWorkplaceNoiseMapper.selectCountByCondition(condition);
        PageResult<RecordWorkplaceNoise> pageList = new  PageResult<RecordWorkplaceNoise>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordWorkplaceNoise recordWorkplaceNoise) {
        recordWorkplaceNoise.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordWorkplaceNoise);
    }

    @Override
    public void delete(Long id) {
        RecordWorkplaceNoise recordWorkplaceNoise = new RecordWorkplaceNoise();
        recordWorkplaceNoise.setId(id);
        recordWorkplaceNoise.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordWorkplaceNoiseMapper.updateByPrimaryKeySelective(recordWorkplaceNoise);
    }

    @Override
    public void update(RecordWorkplaceNoise recordWorkplaceNoise) {
        this.updateByPrimaryKeySelective(recordWorkplaceNoise);
    }

    @Override
    public RecordWorkplaceNoise queryNoiseDetail(Long id) {
        RecordWorkplaceNoise recordWorkplaceNoise = this.selectByPrimaryKey(id);
        return recordWorkplaceNoise;
    }

    @Override
    public List<RecordWorkplaceNoiseResponse> queryNoiseEchartsDetail() {
        List<RecordWorkplaceNoiseResponse> list = this.recordWorkplaceNoiseMapper.selectRecordWorkplaceNoiseEcharsDetail();
        return list;
    }
}
