package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesInputRequest;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordInformingFacilitiesDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordInformingFacilitiesService extends Service<RecordInformingFacilities> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordInformingFacilities> queryList(RecordInformingFacilitiesRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordInformingFacilities> queryListPage(RecordInformingFacilitiesRequest recordRequest);

    /**
     * 添加
     * @param recordInformingFacilitiesInputRequest 实体
     * @return 返回结果
     */
    public RecordInformingFacilities add(RecordInformingFacilitiesInputRequest recordInformingFacilitiesInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordInformingFacilities delete(Long id);

    /**
     * 修改
     * @param recordInformingFacilitiesInputRequest 实体
     * @return 返回结果
     */
    public RecordInformingFacilities update(RecordInformingFacilitiesInputRequest recordInformingFacilitiesInputRequest);

    /**
     * 获取 职业病危害告知设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordInformingFacilitiesDetailResponse queryInformingFacilitiesDetail(Long id);
}
