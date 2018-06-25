package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordInformingFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.sys.service.RecordInformingFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordInformingFacilitiesDataServiceImpl extends AbstractService<RecordInformingFacilitiesData> implements RecordInformingFacilitiesDataService{

    @Autowired
    private RecordInformingFacilitiesDataMapper recordDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByInformingFacilities(Long id) {
        return this.recordDataMapper.selectRecordDataByInformingFacilities(id);
    }
}
