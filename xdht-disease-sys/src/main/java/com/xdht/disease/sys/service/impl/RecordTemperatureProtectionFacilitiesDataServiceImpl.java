package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordTemperatureProtectionFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class RecordTemperatureProtectionFacilitiesDataServiceImpl extends AbstractService<RecordTemperatureProtectionFacilitiesData> implements RecordTemperatureProtectionFacilitiesDataService{

    @Autowired
    private RecordTemperatureProtectionFacilitiesDataMapper recordDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByTemperatureProtection(Long id) {
        return this.recordDataMapper.selectRecordDataByTemperatureProtection(id);
    }
}

