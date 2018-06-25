package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;

import java.util.List;
import java.util.Map;

public interface RecordEquipmentLayoutDataMapper extends Mapper<RecordEquipmentLayoutData> {

    /**
     * 查询设备设施布局调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByEquipmentLayout(Long id);
}