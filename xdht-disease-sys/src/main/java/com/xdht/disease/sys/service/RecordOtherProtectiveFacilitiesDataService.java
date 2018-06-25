package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordOtherProtectiveFacilitiesDataService extends Service<RecordOtherProtectiveFacilitiesData> {

    /**
     * 查询其他防护设施调查表数据
     * @param id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByOtherProtective(Long id);
}
