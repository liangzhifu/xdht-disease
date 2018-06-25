package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordTemperatureProtectionFacilitiesDataService extends Service<RecordTemperatureProtectionFacilitiesData> {

    /**
     * 查询防高温设施调查表数据
     * @param id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByTemperatureProtection(Long id);
}
