package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;

import java.util.List;
import java.util.Map;

public interface RecordIndividualProtectiveEquipmentDataMapper extends Mapper<RecordIndividualProtectiveEquipmentData> {

    /**
     * 查询个体防护用品调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByIndividualProtective(Long id);
}