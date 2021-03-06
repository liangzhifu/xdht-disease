package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordWorkLogDataMapper;
import com.xdht.disease.sys.model.RecordWorkLogData;
import com.xdht.disease.sys.service.RecordWorkLogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class RecordWorkLogDataServiceImpl extends AbstractService<RecordWorkLogData> implements RecordWorkLogDataService{

    @Autowired
    private RecordWorkLogDataMapper recordWorkLogDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByorkLog(Long id) {
        return this.recordWorkLogDataMapper.selectRecordDataByWorkLog(id);
    }
}
