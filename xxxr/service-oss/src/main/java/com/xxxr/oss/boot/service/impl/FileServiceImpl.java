package com.xxxr.oss.boot.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.xxxr.oss.boot.service.FileService;
import com.xxxr.oss.boot.utils.OssProperties;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String upload(InputStream inputStream, String model, String fileName) {
        OSS oss = new OSSClientBuilder().build(OssProperties.END_POINT,
                OssProperties.ACCESS_KEY_ID,
                OssProperties.ACCESS_KEY_SECRET);
        String folderName = new DateTime().toString("/yyyy/MM/dd");
        String suffix = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        String key=model+folderName+"/"+suffix;
        System.out.println(key);
        oss.putObject(OssProperties.BUCKET_NAME,key,inputStream);
        oss.shutdown();
        return "https://"+OssProperties.BUCKET_NAME+'.'+OssProperties.END_POINT+"/"+key;
    }


    @Override
    public void remove(String url) {
        System.out.println(url);
        OSS oss = new OSSClientBuilder().build(OssProperties.END_POINT,
                OssProperties.ACCESS_KEY_ID,
                OssProperties.ACCESS_KEY_SECRET);
        String host="https://"+OssProperties.BUCKET_NAME+"."+OssProperties.END_POINT+"/";
        String substring = url.substring(host.length());
        System.out.println(substring);
        oss.deleteObject(OssProperties.BUCKET_NAME,substring);
        oss.shutdown();
    }
}
