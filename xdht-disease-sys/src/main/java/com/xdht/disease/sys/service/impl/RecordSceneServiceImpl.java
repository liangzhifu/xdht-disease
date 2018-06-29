package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordSceneMapper;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.service.RecordSceneService;
import com.xdht.disease.sys.vo.request.RecordSceneInputRequest;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
import com.xdht.disease.sys.vo.response.RecordSceneDetailResponse;
import com.xdht.disease.sys.vo.response.RecordSceneResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordSceneServiceImpl extends AbstractService<RecordScene> implements RecordSceneService{

    @Autowired
    private RecordSceneMapper recordSceneMapper;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordSceneResponse> queryListPage(RecordSceneRequest recordSceneRequest) {
        Integer start = (recordSceneRequest.getPageNumber() - 1) * recordSceneRequest.getPageSize();
        recordSceneRequest.setStart(start);
        List<RecordSceneResponse> recordSceneResponseList = this.recordSceneMapper.selectRecordSceneList(recordSceneRequest);
        Integer count = this.recordSceneMapper.selectRecordSceneCount(recordSceneRequest);
        PageResult<RecordSceneResponse> pageList = new  PageResult<RecordSceneResponse>();
        pageList.setTotal(count);
        pageList.setDataList(recordSceneResponseList);
        return pageList;
    }

    @Override
    public void deleteRecordScene(Long id) {
        RecordScene recordScene = new RecordScene();
        recordScene.setId(id);
        recordScene.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(recordScene);
    }

    @Override
    public void updateRecordScene(RecordSceneInputRequest recordSceneInputRequest) {
        RecordScene recordScene = recordSceneInputRequest.getRecordScene();
        Date inquiryDate = recordScene.getInquiryDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inquiryDate);
        recordScene.setInquiryYear(cal.get(Calendar.YEAR));
        this.updateByPrimaryKeySelective(recordScene);
        List<RecordScenQuestionnaire> recordScenQuestionnaireList = recordSceneInputRequest.getRecordScenQuestionnaireList();
        if (recordScenQuestionnaireList != null && recordScenQuestionnaireList.size() > 0) {
            for (RecordScenQuestionnaire recordScenQuestionnaire : recordScenQuestionnaireList) {
                this.recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
            }
        }
    }

    @Override
    public void addRecordScene(RecordSceneInputRequest recordSceneInputRequest) {
        RecordScene recordScene = recordSceneInputRequest.getRecordScene();
        Date inquiryDate = recordScene.getInquiryDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inquiryDate);
        recordScene.setInquiryYear(cal.get(Calendar.YEAR));
        recordScene.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordScene);

        List<RecordScenQuestionnaire> recordScenQuestionnaireList = new LinkedList<>();
        if (recordSceneInputRequest.getRecordScenQuestionnaireList() != null && recordSceneInputRequest.getRecordScenQuestionnaireList().size() > 0 ) {
            for (RecordScenQuestionnaire recordScenQuestionnaire : recordSceneInputRequest.getRecordScenQuestionnaireList()) {
                recordScenQuestionnaire.setSceneId(recordScene.getId());
                recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                recordScenQuestionnaireList.add(recordScenQuestionnaire);
            }
            this.recordScenQuestionnaireService.insertList(recordScenQuestionnaireList);
        }
    }

    @Override
    public RecordSceneDetailResponse queryRecordSceneDetail(Long id) {
        RecordSceneDetailResponse recordSceneDetailResponse = new RecordSceneDetailResponse();
        recordSceneDetailResponse.setRecordScene(this.recordSceneMapper.selectRecordSceneMapByPrimaryKey(id));
        recordSceneDetailResponse.setRecordScenQuestionnaireList(this.recordScenQuestionnaireService.queryRecordScenQuestionnaireMapListByRecordScen(id));
        return recordSceneDetailResponse;
    }
}
