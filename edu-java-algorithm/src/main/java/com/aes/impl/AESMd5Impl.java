package com.aes.impl;

//import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author fjy
 */
public class AESMd5Impl extends AES256Impl {
    /**
     * 签名
     *
     * @param encyData
     * @return
     */
    /*@Override
    public String signData(String encyData) {
        return DigestUtils.md5Hex(encyData);
    }*/

    /**
     * 验签
     *
     * @param signStr 签名值明文
     * @param data    签名数据
     * @return
     */
    @Override
    public boolean signCheck(String signStr, String data) {
        return data.equals(signData(signStr));
    }
}
