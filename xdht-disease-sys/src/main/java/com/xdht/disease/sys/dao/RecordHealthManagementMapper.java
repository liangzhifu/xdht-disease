package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHealthManagement;

import java.util.Map;

public interface RecordHealthManagementMapper extends Mapper<RecordHealthManagement> {

    /**
     * 获取 职业卫生管理情况调查表 数据
     * @param id 调查记录表id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}