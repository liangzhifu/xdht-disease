package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordEquipmentDataMapper;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.service.RecordEquipmentDataService;
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
public class RecordEquipmentDataServiceImpl extends AbstractService<RecordEquipmentData> implements RecordEquipmentDataService{

    @Autowired
    private RecordEquipmentDataMapper recordEquipmentDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByEquipment(Long id) {
        return this.recordEquipmentDataMapper.selectRecordDataByEquipment(id);
    }
}
