package com.xdht.disease.common.util;

import sun.misc.BASE64Encoder;
import java.security.MessageDigest;

/**
 * @author lzf
 * MD5验证
 */
public class Md5Utils {

    public static String md5(String input) {

        String output = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            output = base64en.encode(md5.digest(input.getBytes("utf-8")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return output;
    }
}
