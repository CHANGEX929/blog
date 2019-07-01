package com.changex.blog.tools;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * @Author Xie Chenxi
 * @Date 2018/7/21 16:28
 */
public class AliyunOssUtils {

    private AliyunOssUtils() {

    }

    private static final String ACCESS_KEY_ID = "LTAI8EVf6JFCeu8E";
    private static final String ACCESS_KEY_SECRET = "AibCCaYMiifyUw42RthH7xa25iWU86";
    /**
     * OSS的Region域名
     */
    private static final String END_POINT = "http://oss-cn-beijing.aliyuncs.com";
    private static final String BUCKET = "changex";

    /**
     * @param bucketName
     * @param fileName
     * @param filePath   文件路径
     */
    public static void uploadFile(String bucketName, String fileName, String filePath) {
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(bucketName, fileName, new File(filePath));
        ossClient.shutdown();
    }

    /**
     * @param fileName 文件名
     * @param bytes    文件byte[]数组
     * @return key
     */
    public static String upLoadFileByFilePath(String fileName, byte[] bytes) {
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(BUCKET, fileName, new ByteArrayInputStream(bytes));
        ossClient.shutdown();
        return fileName;
    }

    /**
     * @param fileName 文件名
     * @return
     */
    public static URL getFileUrl(String fileName) {
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        //设置URL过期时间为1小时
        URL url = ossClient.generatePresignedUrl(BUCKET, fileName, new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10));
        ossClient.shutdown();
        return url;
    }


}
