package com.aes.en;

/**
 * 加密方式
 * AES192
 * AES256
 * Created by garychen on 2018/4/25.
 * @author admin
 */
public enum AESModule {
    /**AES AES-192 5Padding*/
    AES_192_CBC_PKCS5(192, "AES/CBC/PKCS5Padding", 1),
    /**AES AES-192 7Padding*/
    AES_192_CBC_PKCS7(192, "AES/CBC/PKCS7Padding", 2),
    /**AES AES-256 5Padding*/
    AES_256_CBC_PKCS5(256, "AES/CBC/PKCS5Padding", 3),
    /**AES AES-256 7Padding*/
    AES_256_CBC_PKCS7(256, "AES/CBC/PKCS7Padding", 4),
    /**AES AES-192 No Padding*/
    AES_192_CBC_NOPKD(192, "AES/CBC/NoPadding",5);

    private int module;
    private String alg;
    private int index;

    AESModule(int module, String alg, int index) {
        this.module = module;
        this.alg = alg;
        this.index = index;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
