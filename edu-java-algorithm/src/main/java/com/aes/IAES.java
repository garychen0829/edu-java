package com.aes;


import com.aes.en.AESModule;

/**
 * Created by garychen on 2018/4/26.
 */
public interface IAES {

    /**
     * 加密
     * @param plain 明文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    byte[] encData(String plain, AESModule module, String key, String iv);

    /**
     * 对数据进行加密处理
     * @param plain
     * @param module
     * @param key
     * @param i
     * @return
     */
    byte[] encData(byte[] plain, AESModule module, String key, String i);

    /**
     * 解密
     * @param encrypt 密文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    byte[] decData(byte[] encrypt, AESModule module, String key, String iv);

    /**
     * 加密
     * @param plain 明文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    String encDataBase64(String plain, AESModule module, String key, String iv);

    /**
     * 加密
     * @param encrypt 需要加密的byte
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    byte[] encDataByte(byte[] encrypt, AESModule module, byte[] key, String iv);


    /**
     * 解密
     * @param encStr Base64 Encode后的密文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    String decDataBase64(String encStr, AESModule module, String key, String iv);



    /**
     * 签名
     * @param encyData 需要签名的明文
     * @return
     */
    String signData(String encyData);

    /**
     * 验签
     * @param data 签名值明文
     * @param sign    签名数据(hashCode后再Base64)
     * @return
     */
    boolean signCheck(String data, String sign);
}
