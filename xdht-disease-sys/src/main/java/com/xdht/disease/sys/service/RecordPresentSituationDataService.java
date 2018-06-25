package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.vo.request.RecordPresentSituationDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPresentSituationDataService extends Service<RecordPresentSituationData> {

    /**
     * 获取 现状评价 信息
     * @param id 现状评价 id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByPreEvaluationId(Long id);
}
