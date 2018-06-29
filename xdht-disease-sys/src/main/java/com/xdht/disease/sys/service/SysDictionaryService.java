package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysDictionary;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysDictionaryRequest;
import com.xdht.disease.sys.vo.response.SysDictionaryResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/21.
 */
public interface SysDictionaryService extends Service<SysDictionary> {

    /**
     * 查询字典列表
     * @param sysDictionaryRequest 查询条件
     * @return 返回结果
     */
    List<SysDictionary> querySysDictionaryList(SysDictionaryRequest sysDictionaryRequest);

    /**
     * 查询字典列表
     * @param sysDictionaryRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysDictionaryResponse> querySysDictionaryPage(SysDictionaryRequest sysDictionaryRequest);

    /**
     * 添加字典
     * @param sysDictionary 字典实体
     */
    void addDictionary(SysDictionary sysDictionary);

    /**
     * 删除字典
     * @param id 字典主键id
     */
    void deleteDictionary(Long id);

    /**
     * 修改字典
     * @param sysDictionary 字典实体
     */
    void updateDictionary(SysDictionary sysDictionary);

}
