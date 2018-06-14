package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;
import com.xdht.disease.sys.vo.request.RecordSceneInputRequest;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
import com.xdht.disease.sys.vo.response.RecordSceneDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordSceneService extends Service<RecordScene> {

    /**
     * 查询列表
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    List<RecordScene> queryList(RecordSceneRequest recordSceneRequest);

    /**
     * 分页查询
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordScene> queryListPage(RecordSceneRequest recordSceneRequest);
    PageResult<RecordScene> queryListPage(RecordSceneRequest recordSceneRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordScene 实体
     * @return 返回结果
     */
    RecordScene addRecordScene(RecordScene recordScene);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    RecordScene deleteRecordScene(Long id);

    /**
     * 修改
     * @param recordScene 实体
     * @return 返回结果
     */
    RecordScene updateRecordScene(RecordScene recordScene);

    /**
     * 添加调查表和调查表是否填写的状态
     * @param recordSceneInputRequest
     * @return 返回结果
     */
    RecordScene addAll(RecordSceneInputRequest recordSceneInputRequest);

    /**
     * 获取职业卫生现场调查记录表--详细内容
     * @param id 记录表ID
     * @return 返回结果
     */
    RecordSceneDetailResponse queryRecordSceneDetail(Long id);
}
