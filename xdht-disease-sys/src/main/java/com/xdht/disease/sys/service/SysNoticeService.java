package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysNotice;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysNoticeRequest;


/**
 * Created by lzf on 2018/06/25.
 */
public interface SysNoticeService extends Service<SysNotice> {

    /**
     * 查询公告列表--分页
     * @param sysNoticeRequest 请求条件
     * @return 返回结果
     */
    PageResult<SysNotice> querySysNoticePage(SysNoticeRequest sysNoticeRequest);

    /**
     * 添加公告
     * @param sysNotice 公告实体
     */
    void addNotice(SysNotice sysNotice);

    /**
     * 删除公告
     * @param id 主键ID
     */
    void deleteNotice(Long id);

    /**
     * 更新公告
     * @param sysNotice 公告实体
     */
    void updateNotice(SysNotice sysNotice);
}
