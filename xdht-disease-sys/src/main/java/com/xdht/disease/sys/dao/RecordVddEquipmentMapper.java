package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordVddEquipment;

import java.util.Map;

public interface RecordVddEquipmentMapper extends Mapper<RecordVddEquipment> {

    /**
     * 查询通风排毒除尘设施调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}