package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;

import java.util.List;
import java.util.Map;

public interface RecordOtherProtectiveFacilitiesDataMapper extends Mapper<RecordOtherProtectiveFacilitiesData> {

    /**
     * 查询其他防护设施调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByOtherProtective(Long id);
}