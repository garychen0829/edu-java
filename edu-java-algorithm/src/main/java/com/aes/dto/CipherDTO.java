package com.aes.dto;

import javax.crypto.Cipher;
import java.security.Key;

/**
 * Created by garychen on 2018/4/27.
 * @author admin
 */
public class CipherDTO {
    private Key key;
    private Cipher cipher;
    private byte[]iv;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "CipherDTO(key=" + this.getKey() + ", cipher=" + this.getCipher() + ", iv=" + this.getIv() + ")";
    }
}
