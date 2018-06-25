package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordEquipmentData;

import java.util.List;
import java.util.Map;

public interface RecordEquipmentDataMapper extends Mapper<RecordEquipmentData> {

    /**
     * 查询 设备设施调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByEquipment(Long id);
}