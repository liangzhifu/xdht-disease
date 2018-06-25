package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordAntiNoiseFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordAntiNoiseFacilitiesDataServiceImpl extends AbstractService<RecordAntiNoiseFacilitiesData> implements RecordAntiNoiseFacilitiesDataService{

    @Autowired
    private RecordAntiNoiseFacilitiesDataMapper recordAntiNoiseFacilitiesDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByAntiNoise(Long id) {
        return this.recordAntiNoiseFacilitiesDataMapper.selectRecordDataByAntiNoise(id);
    }
}
