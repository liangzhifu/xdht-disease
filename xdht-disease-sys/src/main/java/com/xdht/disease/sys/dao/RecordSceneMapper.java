package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
import com.xdht.disease.sys.vo.response.RecordSceneResponse;

import java.util.List;
import java.util.Map;

public interface RecordSceneMapper extends Mapper<RecordScene> {

    /**
     * 获取职业卫生现场调查记录表--内容
     * @param id 主键ID
     * @return 返回结果
     */
    Map<String, Object> selectRecordSceneMapByPrimaryKey(Long id);

    /**
     * 查询列表
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    List<RecordSceneResponse> selectRecordSceneList(RecordSceneRequest recordSceneRequest);

    /**
     * 查询数量
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    Integer selectRecordSceneCount(RecordSceneRequest recordSceneRequest);

}