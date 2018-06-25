package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordAntiNoiseFacilitiesDataService extends Service<RecordAntiNoiseFacilitiesData> {

    /**
     * 查询防噪声设施调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByAntiNoise(Long id);
}
