package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordEquipmentLayoutMapper;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordEquipmentLayoutDataService;
import com.xdht.disease.sys.service.RecordEquipmentLayoutService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentLayoutDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordEquipmentLayoutServiceImpl extends AbstractService<RecordEquipmentLayout> implements RecordEquipmentLayoutService{

    @Autowired
    private RecordEquipmentLayoutMapper recordEquipmentLayoutMapper;

    @Autowired
    private RecordEquipmentLayoutDataService recordEquipmentLayoutDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;


    @Override
    public PageResult<RecordEquipmentLayout> queryListPage(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        Condition condition = new Condition(RecordEquipmentLayout.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutRequest.getId());
        if (recordEquipmentLayoutRequest.getEquipmentLayoutNo() != null) {
            condition.getOredCriteria().get(0).andLike("equipmentLayoutNo","%"+recordEquipmentLayoutRequest.getEquipmentLayoutNo()+"%");
        }
        if (recordEquipmentLayoutRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentLayoutRequest.getVerificationResult()+"%");
        }
        condition.getOredCriteria().get(0).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        PageHelper.startPage(recordEquipmentLayoutRequest.getPageNumber(), recordEquipmentLayoutRequest.getPageSize());
        List<RecordEquipmentLayout> dataList = this.recordEquipmentLayoutMapper.selectByCondition(condition);
        Integer count = this.recordEquipmentLayoutMapper.selectCountByCondition(condition);
        PageResult<RecordEquipmentLayout> pageList = new  PageResult<RecordEquipmentLayout>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        RecordEquipmentLayout recordEquipmentLayout = recordEquipmentLayoutInputRequest.getRecordEquipmentLayout();
        recordEquipmentLayout.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordEquipmentLayout);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordEquipmentLayoutInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordEquipmentLayoutInputRequest.getRecordEquipmentLayout().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList = new LinkedList<>();
        if (recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList() != null) {
            for (RecordEquipmentLayoutData recordEquipmentLayoutData : recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList()) {
                recordEquipmentLayoutData.setRelationId(recordEquipmentLayout.getId());
                recordEquipmentLayoutDataList.add(recordEquipmentLayoutData);
            }
            this.recordEquipmentLayoutDataService.insertList(recordEquipmentLayoutDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordEquipmentLayout recordEquipmentLayout = new RecordEquipmentLayout();
        recordEquipmentLayout.setId(id);
        recordEquipmentLayout.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordEquipmentLayoutMapper.updateByPrimaryKeySelective(recordEquipmentLayout);

    }

    @Override
    public void update(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest) {
        RecordEquipmentLayout recordEquipmentLayout = recordEquipmentLayoutInputRequest.getRecordEquipmentLayout();
        this.recordEquipmentLayoutMapper.updateByPrimaryKeySelective(recordEquipmentLayout);
        Condition condition = new Condition(RecordEquipmentLayoutData.class);
        condition.createCriteria().andEqualTo("relationId", recordEquipmentLayout.getId());
        List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList = this.recordEquipmentLayoutDataService.selectByCondition(condition);
        if (recordEquipmentLayoutDataList != null && recordEquipmentLayoutDataList.size() > 0) {
            for ( RecordEquipmentLayoutData recordEquipmentLayoutData : recordEquipmentLayoutDataList ) {
                this.recordEquipmentLayoutDataService.deleteByPrimaryKey(recordEquipmentLayoutData.getId());
            }
        }
        recordEquipmentLayoutDataList = new LinkedList<>();
        if (recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList() != null) {
            for (RecordEquipmentLayoutData recordEquipmentLayoutData : recordEquipmentLayoutInputRequest.getRecordEquipmentLayoutDataList()){
                recordEquipmentLayoutData.setRelationId(recordEquipmentLayout.getId());
                recordEquipmentLayoutDataList.add(recordEquipmentLayoutData);
            }
            this.recordEquipmentLayoutDataService.insertList(recordEquipmentLayoutDataList);
        }
    }

    @Override
    public RecordEquipmentLayoutDetailResponse queryEquipmentLayoutDetail(Long id) {
        RecordEquipmentLayoutDetailResponse response = new RecordEquipmentLayoutDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordEquipmentLayoutMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordEquipmentLayout(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordEquipmentLayoutDataService.queryRecordDataByEquipmentLayout(recordId);
            response.setRecordEquipmentLayoutDataList(mapList);
        }
        return response;
    }
}
