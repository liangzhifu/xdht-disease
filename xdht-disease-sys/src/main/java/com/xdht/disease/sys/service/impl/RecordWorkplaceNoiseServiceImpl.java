package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordWorkplaceNoiseMapper;
import com.xdht.disease.sys.dao.SysCompanyOfficeMapper;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.service.RecordWorkplaceNoiseService;
import com.xdht.disease.sys.vo.request.RecordWorkplaceNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.Calendar;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/07/11.
 */
@Service
@Transactional
public class RecordWorkplaceNoiseServiceImpl extends AbstractService<RecordWorkplaceNoise> implements RecordWorkplaceNoiseService {

    @Autowired
    private RecordWorkplaceNoiseMapper recordWorkplaceNoiseMapper;

    @Autowired
    private SysCompanyOfficeMapper sysCompanyOfficeMapper;

    @Override
    public PageResult<Map<String, Object>> queryListPage(RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest) {
        Integer pageNumber = recordWorkplaceNoiseRequest.getPageNumber();
        Integer pageSize = recordWorkplaceNoiseRequest.getPageSize();
        Integer start = (pageNumber - 1) * pageSize;
        recordWorkplaceNoiseRequest.setStart(start);
        List<Map<String, Object>> dataList = this.recordWorkplaceNoiseMapper.selectRecordWorkplaceNoiseList(recordWorkplaceNoiseRequest);
        Integer count = this.recordWorkplaceNoiseMapper.selectRecordWorkplaceNoiseCount(recordWorkplaceNoiseRequest);
        PageResult<Map<String, Object>> pageList = new  PageResult<Map<String, Object>>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordWorkplaceNoise recordWorkplaceNoise) {
        long workTypeId = recordWorkplaceNoise.getWorkTypeId();
        SysCompanyOffice sysCompanyOffice =sysCompanyOfficeMapper.selectByPrimaryKey(workTypeId);
         recordWorkplaceNoise.setPostId(sysCompanyOffice.getParentId());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(recordWorkplaceNoise.getInspectDate());
        recordWorkplaceNoise.setInspectYear(calendar.get(Calendar.YEAR));
        System.err.println(calendar.get(Calendar.YEAR)+"..............");
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
