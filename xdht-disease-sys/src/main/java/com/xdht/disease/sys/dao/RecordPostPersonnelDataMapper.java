package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPostPersonnelData;

import java.util.List;
import java.util.Map;

public interface RecordPostPersonnelDataMapper extends Mapper<RecordPostPersonnelData> {

    /**
     * 查询岗位定员及工作制度调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    public List<Map<String, Object>> selectRecordPostPersonnelDataByPostPersonnel(Long id);

}