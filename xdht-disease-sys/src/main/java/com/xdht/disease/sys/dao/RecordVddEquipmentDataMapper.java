package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordVddEquipmentData;

import java.util.List;
import java.util.Map;

public interface RecordVddEquipmentDataMapper extends Mapper<RecordVddEquipmentData> {

    /**
     * 查询 通风排毒除尘设施调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByVddEquipment(Long id);
}