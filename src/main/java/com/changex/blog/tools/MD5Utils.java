package com.changex.blog.tools;

import java.security.MessageDigest;

/**
 * @author Xie Chenxi
 * @date 2018-12-22 11:01
 */
public class MD5Utils {

    // MD5加密函数
    public static String MD5LowerCaseEncode(String sourceString) {
        String resultString = null;
        try {
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    public static String MD5UpperCaseEncode(String sourceString) {
        String resultString = null;
        try {
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString.toUpperCase();
    }

    private static final String byte2hexString(byte[] bytes) {
        StringBuffer bf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                bf.append("0");
            }
            bf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return bf.toString();
    }

    /**
     * 获取加密密码
     *
     * @param passWord
     * @return
     */
    public static String getPassWord(String passWord) {

        return MD5UpperCaseEncode(passWord+"qcsaidksjau/./;'dakjhdaurfh").toLowerCase();
    }

    public static String getDefaultPass() {
        return MD5UpperCaseEncode(MD5UpperCaseEncode("123"));
    }

}
