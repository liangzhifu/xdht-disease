package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordOtherProtectiveFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesDataRequest;
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
public class RecordOtherProtectiveFacilitiesDataServiceImpl extends AbstractService<RecordOtherProtectiveFacilitiesData> implements RecordOtherProtectiveFacilitiesDataService{

    @Autowired
    private RecordOtherProtectiveFacilitiesDataMapper recordDataMapper;


    @Override
    public List<Map<String, Object>> queryRecordDataByOtherProtective(Long id) {
        return this.recordDataMapper.selectRecordDataByOtherProtective(id);
    }
}
