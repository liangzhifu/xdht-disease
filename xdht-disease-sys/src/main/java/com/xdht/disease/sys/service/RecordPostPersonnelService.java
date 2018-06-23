package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelInputRequest;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;
import com.xdht.disease.sys.vo.response.RecordPostPersonnelDetailResponse;

public interface RecordPostPersonnelService extends Service<RecordPostPersonnel> {

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordPostPersonnel> queryListPage(RecordPostPersonnelRequest recordRequest);

    /**
     * 添加
     * @param recordPostPersonnelInputRequest 实体
     */
    void add(RecordPostPersonnelInputRequest recordPostPersonnelInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改
     * @param recordPostPersonnelInputRequest 实体
     */
    void update(RecordPostPersonnelInputRequest recordPostPersonnelInputRequest);

    /**
     * 获取 岗位定员及工作制度调查表 信息
     * @param id 关联id
     * @return 返回结果
     */
    RecordPostPersonnelDetailResponse queryPostPersonnelDetail(Long id);
}
