package com.xdht.disease.third.service.impl;

import com.xdht.disease.third.dao.SysThirdMapper;
import com.xdht.disease.third.model.SysThird;
import com.xdht.disease.third.service.SysThirdService;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lzf on 2018/06/12.
 */
@Service
@Transactional
public class SysThirdServiceImpl extends AbstractService<SysThird> implements SysThirdService {

    @Autowired
    private SysThirdMapper sysThirdMapper;

}
