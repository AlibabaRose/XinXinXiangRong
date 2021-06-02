package com.xxxr.oss.boot.service;

import java.io.InputStream;

/**
 * 文件系统
 */
public interface FileService {

    /**
     *
     * @param inputStream
     * @param module：上传至的文件目录
     * @param fileName：文件名称
     * @return
     */
    String upload(InputStream inputStream,String module,String fileName);

    void remove(String url);
}
