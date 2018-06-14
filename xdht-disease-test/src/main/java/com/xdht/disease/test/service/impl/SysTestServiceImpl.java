package com.xdht.disease.test.service.impl;

import com.xdht.disease.test.dao.SysTestMapper;
import com.xdht.disease.test.model.SysTest;
import com.xdht.disease.test.service.SysTestService;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lzf on 2018/06/12.
 */
@Service
@Transactional
public class SysTestServiceImpl extends AbstractService<SysTest> implements SysTestService {

    @Autowired
    private SysTestMapper sysTestMapper;

}
