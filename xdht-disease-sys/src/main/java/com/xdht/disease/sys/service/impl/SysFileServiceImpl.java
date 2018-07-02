package com.xdht.disease.sys.service.impl;

import com.xdht.disease.sys.model.SysFile;
import com.xdht.disease.sys.service.SysFileService;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * Created by lzf on 2018/06/26.
 */
@Service
@Transactional
public class SysFileServiceImpl extends AbstractService<SysFile> implements SysFileService {

    @Override
    public String addFile(MultipartFile file) throws IOException {
        SysFile sysFile = new SysFile();
        String fileName = file.getOriginalFilename();
        int index = fileName.lastIndexOf(".");
        String fileSuffix = fileName.substring(index);
        String fileAlias = UUID.randomUUID().toString() + fileSuffix;
        String filePath = fileAlias;
        sysFile.setFileName(fileName);
        sysFile.setFileSuffix(fileSuffix);
        sysFile.setFileAlias(fileAlias);
        sysFile.setFilePath(filePath);
        String localFilePath = "D:/Program Files/apache-tomcat-7.0.67/webapps/testCom/img/" + fileAlias;
        file.transferTo(new File(localFilePath));
        this.insertUseGeneratedKeys(sysFile);
        return filePath;
    }
}
