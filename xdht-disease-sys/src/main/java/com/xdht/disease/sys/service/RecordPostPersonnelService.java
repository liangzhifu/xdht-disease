package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelInputRequest;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;
import com.xdht.disease.sys.vo.response.RecordPostPersonnelDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPostPersonnelService extends Service<RecordPostPersonnel> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPostPersonnel> queryList(RecordPostPersonnelRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordPostPersonnel> queryListPage(RecordPostPersonnelRequest recordRequest);

    /**
     * 添加
     * @param recordPostPersonnelInputRequest 实体
     * @return 返回结果
     */
    public RecordPostPersonnel add(RecordPostPersonnelInputRequest recordPostPersonnelInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPostPersonnel delete(Long id);

    /**
     * 修改
     * @param recordPostPersonnelInputRequest 实体
     * @return 返回结果
     */
    public RecordPostPersonnel update(RecordPostPersonnelInputRequest recordPostPersonnelInputRequest);

    /**
     * 获取 岗位定员及工作制度调查表 信息
     * @param sceneId 关联id
     * @return 返回结果
     */
    RecordPostPersonnelDetailResponse queryPostPersonnelDetail(Long sceneId);
}
