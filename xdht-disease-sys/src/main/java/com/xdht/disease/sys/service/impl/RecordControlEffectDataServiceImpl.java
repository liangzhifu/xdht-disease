package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordControlEffectDataMapper;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.service.RecordControlEffectDataService;
import com.xdht.disease.sys.vo.request.RecordControlEffectDataRequest;
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
public class RecordControlEffectDataServiceImpl extends AbstractService<RecordControlEffectData> implements RecordControlEffectDataService{

    @Autowired
    private RecordControlEffectDataMapper recordControlEffectDataMapper;

    @Override
    public List<Map<String, Object>> queryRecordDataByPreEvaluationId(Long id) {
        return this.recordControlEffectDataMapper.selectRecordDataByPreEvaluationId(id);

    }
}
