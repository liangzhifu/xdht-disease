package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthManagementDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthManagementDataService extends Service<RecordHealthManagementData> {

    /**
     * 获取  职业卫生管理情况调查表 信息
     * @param id  职业卫生管理情况调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByHealthManagementId(Long id);
}
