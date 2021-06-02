package com.xxxr.oss.boot;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.xxxr.oss.boot.service.FileService;
import com.xxxr.oss.boot.utils.OssProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OSSTest {

    @Resource
    private FileService service;

    @Test
    public void test(){
        OSS oss = new OSSClientBuilder().build(OssProperties.END_POINT, OssProperties.ACCESS_KEY_ID, OssProperties.ACCESS_KEY_SECRET);
        String content = "Hello OSS";
        oss.putObject("xxxr-oss", "hello.txt", new ByteArrayInputStream(content.getBytes()));
        boolean b = oss.doesBucketExist("xxxr-oss");
        System.out.println(b);
        oss.shutdown();
    }

    @Test
    public void test2(){
        String host="https://"+OssProperties.BUCKET_NAME+"."+OssProperties.END_POINT+"/";
        String substring = "https://xxxr-oss.oss-cn-beijing.aliyuncs.com/xxxr/oss/2021/5/15/4cb60e19-a3e8-4c9a-bd96-a119aed607ed.docx".substring(host.length());
        System.out.println(substring);
    }

    @Test
    public void delete(){
        OSS oss = new OSSClientBuilder().build(OssProperties.END_POINT, OssProperties.ACCESS_KEY_ID, OssProperties.ACCESS_KEY_SECRET);
        oss.deleteObject("xxxr-oss","/xxxr/core/2021/5/15/4cb60e19-a3e8-4c9a-bd96-a119aed607ed.docx");
        oss.shutdown();
    }
    @Test
    public void uploadTest(){
        try {
            FileInputStream stream = new FileInputStream("C:\\Users\\1\\Desktop\\service.jpg");
            String upload = service.upload(stream, "/xxxr/log", "error.log");
            System.out.println(upload);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void downloadTest(){
        OSS oss = new OSSClientBuilder().build(OssProperties.END_POINT, OssProperties.ACCESS_KEY_ID, OssProperties.ACCESS_KEY_SECRET);
        oss.getObject(new GetObjectRequest(OssProperties.BUCKET_NAME,"xxxr/database/head_image/logo.jpg"),new File("C:\\Users\\1\\Desktop\\head.jpg"));
        oss.shutdown();
    }
}
