package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEmergencyFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesDataRequest;
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
public class RecordEmergencyFacilitiesDataServiceImpl extends AbstractService<RecordEmergencyFacilitiesData> implements RecordEmergencyFacilitiesDataService{

    @Autowired
    private RecordEmergencyFacilitiesDataMapper recordEmergencyFacilitiesDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordDataByEmergency(Long id) {
        return this.recordEmergencyFacilitiesDataMapper.selectRecordDataByEmergency(id);
    }
}
