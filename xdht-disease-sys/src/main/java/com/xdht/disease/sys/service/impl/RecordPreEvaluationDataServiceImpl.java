package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordPreEvaluationDataMapper;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.service.RecordPreEvaluationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordPreEvaluationDataServiceImpl extends AbstractService<RecordPreEvaluationData> implements RecordPreEvaluationDataService{

    @Autowired
    private RecordPreEvaluationDataMapper recordPreEvaluationDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordPreEvaluationDataByPreEvaluationId(Long id) {
        return this.recordPreEvaluationDataMapper.selectRecordPreEvaluationDataByPreEvaluationId(id);
    }

}
