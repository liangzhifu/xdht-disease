package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.sys.service.SysQuestionnaireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class SysQuestionnaireServiceImpl extends AbstractService<SysQuestionnaire> implements SysQuestionnaireService{

    @Override
    public List<SysQuestionnaire> queryList( ) {
        Condition condition = new Condition(SysQuestionnaire.class);
        condition.createCriteria() .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }
    @Override
    public SysQuestionnaire selectOne(Long id){
      return this.selectByPrimaryKey(id);
    }
}
