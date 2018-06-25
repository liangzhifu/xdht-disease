package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;

import java.util.Map;

public interface RecordIndividualProtectiveEquipmentMapper extends Mapper<RecordIndividualProtectiveEquipment> {

    /**
     * 查询个体防护用品调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}