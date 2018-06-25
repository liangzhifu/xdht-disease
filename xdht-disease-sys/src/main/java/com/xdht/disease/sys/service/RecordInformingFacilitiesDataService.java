package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordInformingFacilitiesDataService extends Service<RecordInformingFacilitiesData> {

    /**
     * 查询职业病危害告知设施调查表数据
     * @param id 调查表主键id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByInformingFacilities(Long id);
}
