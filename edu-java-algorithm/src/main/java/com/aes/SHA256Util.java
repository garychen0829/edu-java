package com.aes;

import com.aes.codec.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import org.apache.commons.codec.binary.Base64;

/**
 * Sha256
 * Created by garychen on 2017/12/12.
 * @author admin
 */
public class SHA256Util {


    public static byte[] getServerHash_C(String encDataStr) {
        return encryption(encDataStr);
    }

    /**
     * SHA256加密算法
     * @param data
     * @return
     */
    public static byte[] encryption(String data){
        byte[] plainText = data.getBytes();

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(plainText);
        return messageDigest.digest();
    }

    /**
     * Hash后Base64转化
     * @param data  待加密字符串
     * @return
     */
    public static String encrypt(String data){
        return Base64.encodeBase64String(encryption(data));
    }
}
