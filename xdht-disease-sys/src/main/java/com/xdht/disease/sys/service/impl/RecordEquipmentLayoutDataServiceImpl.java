package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEquipmentLayoutDataMapper;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.service.RecordEquipmentLayoutDataService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutDataRequest;
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
public class RecordEquipmentLayoutDataServiceImpl extends AbstractService<RecordEquipmentLayoutData> implements RecordEquipmentLayoutDataService{

    @Autowired
    private RecordEquipmentLayoutDataMapper recordEquipmentLayoutDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByEquipmentLayout(Long id) {
        return this.recordEquipmentLayoutDataMapper.selectRecordDataByEquipmentLayout(id);
    }
}
