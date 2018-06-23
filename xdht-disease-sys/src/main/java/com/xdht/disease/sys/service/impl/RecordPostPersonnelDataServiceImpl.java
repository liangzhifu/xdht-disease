package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordPostPersonnelDataMapper;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import com.xdht.disease.sys.service.RecordPostPersonnelDataService;
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
public class RecordPostPersonnelDataServiceImpl extends AbstractService<RecordPostPersonnelData> implements RecordPostPersonnelDataService{

    @Autowired
    private RecordPostPersonnelDataMapper recordDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordPostPersonnelDataByPostPersonnel(Long id) {
        return this.recordDataMapper.selectRecordPostPersonnelDataByPostPersonnel(id);
    }
}
