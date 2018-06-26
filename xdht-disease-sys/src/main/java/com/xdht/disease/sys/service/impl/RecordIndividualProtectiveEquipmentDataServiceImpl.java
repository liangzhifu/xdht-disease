package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordIndividualProtectiveEquipmentDataMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentDataService;
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
public class RecordIndividualProtectiveEquipmentDataServiceImpl extends AbstractService<RecordIndividualProtectiveEquipmentData> implements RecordIndividualProtectiveEquipmentDataService{

    @Autowired
    private RecordIndividualProtectiveEquipmentDataMapper recordDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordDataByIndividualProtective(Long id) {
        return this.recordDataMapper.selectRecordDataByIndividualProtective(id);
    }
}
