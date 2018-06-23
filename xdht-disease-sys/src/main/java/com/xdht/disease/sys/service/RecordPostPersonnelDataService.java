package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import com.xdht.disease.common.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPostPersonnelDataService extends Service<RecordPostPersonnelData> {

    /**
     * 查询岗位定员及工作制度调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String, Object>> queryRecordPostPersonnelDataByPostPersonnel(Long id);

}
