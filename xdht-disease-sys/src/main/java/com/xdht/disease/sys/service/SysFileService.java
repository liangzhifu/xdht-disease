package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysFile;
import com.xdht.disease.common.core.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * Created by lzf on 2018/06/26.
 */
public interface SysFileService extends Service<SysFile> {

    /**
     * 上传文件
     * @param file 文件
     * @return 返回文件路径
     */
    String addFile(MultipartFile file) throws IOException;

}
