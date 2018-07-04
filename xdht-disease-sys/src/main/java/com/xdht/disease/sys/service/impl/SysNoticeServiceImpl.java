package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysNotice;
import com.xdht.disease.sys.service.SysNoticeService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysNoticeRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Created by lzf on 2018/06/25.
 */
@Service
@Transactional
public class SysNoticeServiceImpl extends AbstractService<SysNotice> implements SysNoticeService {

    @Override
    public PageResult<SysNotice> querySysNoticePage(SysNoticeRequest sysNoticeRequest) {
        Condition condition = new Condition(SysNotice.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        String noticeTitle = sysNoticeRequest.getNoticeTitle();
        if (noticeTitle != null && !"".equals(noticeTitle)){
            condition.getOredCriteria().get(0).andLike("noticeTitle", "%" + noticeTitle + "%");
        }
        condition.orderBy("noticeReleaseDate").desc();
        PageHelper.startPage(sysNoticeRequest.getPageNumber(), sysNoticeRequest.getPageSize());
        List<SysNotice> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysNotice> pageList = new PageResult<SysNotice>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public void addNotice(SysNotice sysNotice) {
        sysNotice.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysNotice);
    }

    @Override
    public void deleteNotice(Long id) {
        SysNotice sysNotice =  new SysNotice();
        sysNotice.setId(id);
        sysNotice.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysNotice);
    }

    @Override
    public void updateNotice(SysNotice sysNotice) {
        this.updateByPrimaryKeySelective(sysNotice);
    }
}
