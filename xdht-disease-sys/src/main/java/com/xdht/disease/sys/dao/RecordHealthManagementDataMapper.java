package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHealthManagementData;

import java.util.List;
import java.util.Map;

public interface RecordHealthManagementDataMapper extends Mapper<RecordHealthManagementData> {

    /**
     * 列表数据
     * @param id 职业卫生管理情况调查表 id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByHealthManagementId(Long id);
}