package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPresentSituationDataMapper;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.service.RecordPresentSituationDataService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationDataRequest;
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
public class RecordPresentSituationDataServiceImpl extends AbstractService<RecordPresentSituationData> implements RecordPresentSituationDataService{

    @Autowired
    private RecordPresentSituationDataMapper recordPresentSituationDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordDataByPreEvaluationId(Long id) {
        return this.recordPresentSituationDataMapper.selectRecordDataByPreEvaluationId(id);
    }
}
