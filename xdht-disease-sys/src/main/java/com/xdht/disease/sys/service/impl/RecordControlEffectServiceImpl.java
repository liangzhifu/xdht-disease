package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordControlEffectMapper;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.model.RecordControlEffectProject;
import com.xdht.disease.sys.service.RecordControlEffectDataService;
import com.xdht.disease.sys.service.RecordControlEffectProjectService;
import com.xdht.disease.sys.service.RecordControlEffectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectInputRequest;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;
import com.xdht.disease.sys.vo.response.RecordControlEffectDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordControlEffectServiceImpl extends AbstractService<RecordControlEffect> implements RecordControlEffectService{

    @Autowired
    private RecordControlEffectMapper recordControlEffectMapper;

    @Autowired
    private RecordControlEffectDataService recordControlEffectDataService;

    @Autowired
    private RecordControlEffectProjectService recordControlEffectProjectService;

        @Override
        public List<RecordControlEffect> queryList(RecordControlEffectRequest recordControlEffectRequest) {
            Condition condition = new Condition(RecordControlEffect.class);
            condition.createCriteria() .andEqualTo("id", recordControlEffectRequest.getId())
            .andEqualTo("preEvaluationNo",recordControlEffectRequest.getPreEvaluationNo());
            if (recordControlEffectRequest.getVerificationResult() != null) {
                condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordControlEffectRequest.getVerificationResult()+"%");
            }
            if (recordControlEffectRequest.getStatus() != null){
                condition.getOredCriteria().get(0).andEqualTo("status",recordControlEffectRequest.getStatus());
            }
            return this.recordControlEffectMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordControlEffect> queryListPage(RecordControlEffectRequest recordControlEffectRequest) {
            Condition condition = new Condition(RecordControlEffect.class);
            if (recordControlEffectRequest.getPreEvaluationNo() != null) {
                condition.createCriteria().andLike("preEvaluationNo","%"+recordControlEffectRequest.getPreEvaluationNo()+"%");
            }
            Integer count = this.selectCountByCondition(condition);
            PageHelper.startPage(recordControlEffectRequest.getPageNumber(), recordControlEffectRequest.getPageSize());
            List<RecordControlEffect> dataList = this.recordControlEffectMapper.selectByCondition(condition);
            PageResult<RecordControlEffect> pageList = new  PageResult<RecordControlEffect>();
            pageList.setTotal(count);
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public RecordControlEffect addRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest) {
             RecordControlEffect recordControlEffect = new RecordControlEffect();
             recordControlEffect.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
             recordControlEffect.setPreEvaluationNo(recordControlEffectInputRequest.getRecordControlEffect().getPreEvaluationNo());
             recordControlEffect.setVerificationResult(recordControlEffectInputRequest.getRecordControlEffect().getVerificationResult());
            this.insertUseGeneratedKeys(recordControlEffect);
            List<RecordControlEffectData> recordControlEffectDataList = new LinkedList<>();
            for (RecordControlEffectData recordControlEffectData : recordControlEffectInputRequest.getRecordControlEffectDataList()) {
                recordControlEffectData.setPreEvaluationId(recordControlEffect.getId());
                recordControlEffectDataList.add(recordControlEffectData);
            }
            this.recordControlEffectDataService.insertList(recordControlEffectDataList);
            return  recordControlEffect;
        }

        @Override
        public RecordControlEffect deleteRecordControlEffect(Long id) {
            RecordControlEffect recordControlEffect = this.recordControlEffectMapper.selectByPrimaryKey(id);
            recordControlEffect.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.recordControlEffectMapper.updateByPrimaryKeySelective(recordControlEffect);
            return  recordControlEffect;
        }

        @Override
        public RecordControlEffect updateRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest) {
            RecordControlEffect recordControlEffect = new RecordControlEffect();
            recordControlEffect.setId(recordControlEffectInputRequest.getRecordControlEffect().getId());
            recordControlEffect.setPreEvaluationNo(recordControlEffectInputRequest.getRecordControlEffect().getPreEvaluationNo());
            recordControlEffect.setVerificationResult(recordControlEffectInputRequest.getRecordControlEffect().getVerificationResult());

            List<RecordControlEffectData> recordControlEffectDataList = new LinkedList<>();
            for (RecordControlEffectData recordPreEvaluationData : recordControlEffectInputRequest.getRecordControlEffectDataList() ) {
                this.recordControlEffectDataService.updateByPrimaryKeySelective(recordPreEvaluationData);
            }
            return recordControlEffect;
        }

    @Override
    public RecordControlEffectDetailResponse queryRecordControlEffectDetail(Long id) {
        RecordControlEffectDetailResponse recordControlEffectDetailResponse = new RecordControlEffectDetailResponse();
        RecordControlEffect recordControlEffect = this.recordControlEffectMapper.selectByPrimaryKey(id);
        recordControlEffectDetailResponse.setRecordControlEffect(recordControlEffect);
        Condition condition = new Condition(RecordControlEffectData.class);
        condition.createCriteria() .andEqualTo("preEvaluationId", id);
        List<RecordControlEffectData> recordControlEffectDataList = this.recordControlEffectDataService.selectByCondition(condition);
        recordControlEffectDetailResponse.setRecordControlEffectDataList(recordControlEffectDataList);
        String projectIds = "";
        for (RecordControlEffectData recordData : recordControlEffectDataList) {
            projectIds += recordData.getPreEvaluationProjectId()+",";
        }
        projectIds = projectIds.substring(0,projectIds.lastIndexOf(","));
        List<RecordControlEffectProject> projectList = this.recordControlEffectProjectService.selectByIds(projectIds);
        System.out.println("projectList:"+projectList.size());
        recordControlEffectDetailResponse.setRecordControlEffectProjectList(projectList);
        return recordControlEffectDetailResponse;
    }

}
