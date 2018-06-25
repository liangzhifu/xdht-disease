package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordIndividualProtectiveEquipmentDataService extends Service<RecordIndividualProtectiveEquipmentData> {

    /**
     * 查询个体防护用品调查表数据
     * @param id 调查表主键id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByIndividualProtective(Long id);
}
