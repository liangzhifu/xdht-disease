package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordHazardFactorsDataMapper;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.service.RecordHazardFactorsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordHazardFactorsDataServiceImpl extends AbstractService<RecordHazardFactorsData> implements RecordHazardFactorsDataService{

    @Autowired
    private RecordHazardFactorsDataMapper recordHazardFactorsDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordDataByHazardFactors(Long id) {
        return this.recordHazardFactorsDataMapper.selectRecordDataByHazardFactors(id);
    }
}
