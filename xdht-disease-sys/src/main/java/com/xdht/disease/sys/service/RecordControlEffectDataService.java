package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.vo.request.RecordControlEffectDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordControlEffectDataService extends Service<RecordControlEffectData> {

    /**
     *  获取 控制效果评价 项目信息
     * @param id 控制效果评价id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByPreEvaluationId(Long id);
}
