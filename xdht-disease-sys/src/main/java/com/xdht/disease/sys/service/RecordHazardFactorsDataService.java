package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHazardFactorsDataService extends Service<RecordHazardFactorsData> {


    /**
     * 查询 职业病危害因素调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByHazardFactors(Long id);
}
