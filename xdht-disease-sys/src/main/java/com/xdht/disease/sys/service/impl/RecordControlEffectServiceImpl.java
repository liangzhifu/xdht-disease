package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordControlEffectMapper;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.service.RecordControlEffectDataService;
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
import java.util.Map;


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


        @Override
        public List<RecordControlEffect> queryList(RecordControlEffectRequest recordControlEffectRequest) {
            Condition condition = new Condition(RecordControlEffect.class);
            condition.createCriteria() .andEqualTo("id", recordControlEffectRequest.getId())
            .andEqualTo("preEvaluationNo",recordControlEffectRequest.getPreEvaluationNo());
            if (recordControlEffectRequest.getVerificationResult() != null) {
                condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordControlEffectRequest.getVerificationResult()+"%");
            }
            condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            return this.recordControlEffectMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordControlEffect> queryListPage(RecordControlEffectRequest recordControlEffectRequest) {
            Condition condition = new Condition(RecordControlEffect.class);
            if (recordControlEffectRequest.getPreEvaluationNo() != null) {
                condition.createCriteria().andLike("preEvaluationNo","%"+recordControlEffectRequest.getPreEvaluationNo()+"%");
            }
            condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            Integer count = this.selectCountByCondition(condition);
            PageHelper.startPage(recordControlEffectRequest.getPageNumber(), recordControlEffectRequest.getPageSize());
            List<RecordControlEffect> dataList = this.recordControlEffectMapper.selectByCondition(condition);
            PageResult<RecordControlEffect> pageList = new  PageResult<RecordControlEffect>();
            pageList.setTotal(count);
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public void addRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest) {
            RecordControlEffect recordControlEffect = new RecordControlEffect();
            recordControlEffect.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            this.insertUseGeneratedKeys(recordControlEffect);
            List<RecordControlEffectData> recordControlEffectDataList = new LinkedList<>();
            for (RecordControlEffectData recordControlEffectData : recordControlEffectInputRequest.getRecordControlEffectDataList()) {
                recordControlEffectData.setPreEvaluationId(recordControlEffect.getId());
                recordControlEffectDataList.add(recordControlEffectData);
            }
            this.recordControlEffectDataService.insertList(recordControlEffectDataList);
        }

        @Override
        public void deleteRecordControlEffect(Long id) {
            RecordControlEffect recordControlEffect = new RecordControlEffect();
            recordControlEffect.setId(id);
            recordControlEffect.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.recordControlEffectMapper.updateByPrimaryKeySelective(recordControlEffect);
        }

        @Override
        public void updateRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest) {
            RecordControlEffect recordControlEffect = recordControlEffectInputRequest.getRecordControlEffect();
            this.updateByPrimaryKeySelective(recordControlEffect);

            List<RecordControlEffectData> recordControlEffectDataList = recordControlEffectInputRequest.getRecordControlEffectDataList();
            for (RecordControlEffectData recordPreEvaluationData : recordControlEffectDataList ) {
                this.recordControlEffectDataService.updateByPrimaryKeySelective(recordPreEvaluationData);
            }
        }

    @Override
    public RecordControlEffectDetailResponse queryRecordControlEffectDetail(Long id) {
        RecordControlEffectDetailResponse recordControlEffectDetailResponse = new RecordControlEffectDetailResponse();
        Map<String, Object> map = this.recordControlEffectMapper.selectRecordBySceneId(id);
        if (map != null){
            recordControlEffectDetailResponse.setRecordControlEffect(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordControlEffectDataService.queryRecordDataByPreEvaluationId(recordId);
            recordControlEffectDetailResponse.setRecordControlEffectDataList(mapList);
        }
        return recordControlEffectDetailResponse;
    }

}
