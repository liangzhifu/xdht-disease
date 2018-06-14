package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.common.core.Service;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface SysQuestionnaireService extends Service<SysQuestionnaire> {

    /**
     * 查询
     * @return 返回结果
     */
    public List<SysQuestionnaire> queryList();
}
