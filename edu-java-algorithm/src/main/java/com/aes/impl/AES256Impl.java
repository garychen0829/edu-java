package com.aes.impl;

import com.aes.IAES;
import com.aes.dto.CipherDTO;
import com.aes.en.AESModule;

/**
 * Created by garychen on 2018/4/26.
 */
public class AES256Impl extends AESParent implements IAES {

    /**
     * 加密
     * @param plain 明文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    @Override
    public byte[] encData(String plain, AESModule module, String key, String iv) {
        try {
            CipherDTO cipherDTO = super.init(module.getModule(), module.getAlg(), key, iv);
            return super.encrypt(plain, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 对数据进行加密处理
     *
     * @param plain
     * @param module
     * @param key
     * @param iv
     * @return
     */
    @Override
    public byte[] encData(byte[] plain, AESModule module, String key, String iv) {
        try {
            CipherDTO cipherDTO = super.init(module.getModule(), module.getAlg(), key, iv);
            return super.encryptByte(plain, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param encrypt 密文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    @Override
    public byte[] decData(byte[] encrypt, AESModule module, String key, String iv) {
        try {
            CipherDTO cipherDTO = super.init(module.getModule(), module.getAlg(), key, iv);
            return super.decrypt(encrypt, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 加密
     * @param plain 明文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    @Override
    public String encDataBase64(String plain, AESModule module, String key, String iv) {
        try {
            CipherDTO cipherDTO = super.init(module.getModule(), module.getAlg(), key, iv);
            return super.encryptBase64(plain, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param encrypt 需要加密的byte
     * @param module  加密方式
     * @param key     密钥
     * @param iv      初始向量
     * @return
     */
    @Override
    public byte[] encDataByte(byte[] encrypt, AESModule module, byte[] key, String iv) {
        try {
            CipherDTO cipherDTO = super.initByte(module.getModule(), module.getAlg(), key, iv);
            return super.encryptByte(encrypt, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 解密
     * @param encStr Base64 Encode后的密文
     * @param module 加密方式
     * @param key 密钥
     * @param iv 初始向量
     * @return
     */
    @Override
    public String decDataBase64(String encStr, AESModule module, String key, String iv) {
        try {
            CipherDTO cipherDTO = super.init(module.getModule(), module.getAlg(), key, iv);
            return super.decryptBase64(encStr, cipherDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 签名
     *
     * @param encyData
     * @return
     */
    @Override
    public String signData(String encyData) {
        return super.signData(encyData);
    }

    /**
     * 验签
     *
     * @param signStr 签名值明文
     * @param data    签名数据(hashCode后再Base64)
     * @return
     */
    @Override
    public boolean signCheck(String signStr, String data) {
        return super.signCheck(signStr, data);
    }

}
