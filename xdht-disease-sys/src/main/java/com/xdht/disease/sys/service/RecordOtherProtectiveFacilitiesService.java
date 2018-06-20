package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveInputRequest;
import com.xdht.disease.sys.vo.response.RecordOtherProtectiveDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordOtherProtectiveFacilitiesService extends Service<RecordOtherProtectiveFacilities> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordOtherProtectiveFacilities> queryList(RecordOtherProtectiveFacilitiesRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordOtherProtectiveFacilities> queryListPage(RecordOtherProtectiveFacilitiesRequest recordRequest);

    /**
     * 添加
     * @param recordOtherProtectiveInputRequest   实体
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities add(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities delete(Long id);

    /**
     * 修改
     * @param recordOtherProtectiveInputRequest 实体
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities update(RecordOtherProtectiveInputRequest recordOtherProtectiveInputRequest);

    /**
     * 获取 其他防护设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordOtherProtectiveDetailResponse queryOtherProtetiveDetail(Long id);
}
