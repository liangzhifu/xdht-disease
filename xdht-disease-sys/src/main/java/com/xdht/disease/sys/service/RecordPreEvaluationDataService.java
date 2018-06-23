package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordPreEvaluationData;

import java.util.List;
import java.util.Map;


public interface RecordPreEvaluationDataService extends Service<RecordPreEvaluationData> {

    /**
     * 获取预评价项目信息
     * @param id 预评价ID
     * @return 返回结果
     */
    List<Map<String, Object>> queryRecordPreEvaluationDataByPreEvaluationId(Long id);

}
