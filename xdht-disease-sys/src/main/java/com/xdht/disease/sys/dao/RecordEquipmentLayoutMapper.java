package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordEquipmentLayout;

import java.util.Map;

public interface RecordEquipmentLayoutMapper extends Mapper<RecordEquipmentLayout> {

    /**
     * 查询设备设施布局调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}