package com.aes.impl;

import com.aes.SHA256Util;
import com.aes.codec.Base64;
import com.aes.dto.CipherDTO;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;



/**
 * Created by garychen on 2018/4/27.
 * @author admin
 */
public class AESParent {
    /**算法名称*/
    private final String KEY_ALGORITHM = "AES";

    /**
     * 初始化CipherDTO
     * @param module        192/256加密
     * @param algorithmStr  补位
     * @param keyStr        key
     * @param ivStr         IV向量
     * @return              CipherDTO
     * @throws Exception
     */
    public CipherDTO init(int module, String algorithmStr, String keyStr, String ivStr) throws Exception {
        return initCore(module, algorithmStr,keyStr.getBytes(),ivStr);
    }

    /**
     * key 是 byte类型
     * @param module
     * @param algorithmStr
     * @param bytes
     * @param ivStr
     * @return
     */
    public CipherDTO initByte(int module, String algorithmStr, byte[] bytes, String ivStr) throws Exception{
        return initCore(module, algorithmStr,bytes,ivStr);
    }

    /**
     * @param module
     * @param algorithmStr
     * @param bytes
     * @param ivStr
     * @return
     * @throws Exception
     */
    private CipherDTO initCore(int module, String algorithmStr, byte[] bytes, String ivStr) throws Exception{
        int keyNum = module / 8;
        Key key;
        Cipher cipher;
        CipherDTO cipherDTO = new CipherDTO();
        //IV处理,iv是 16 byte
        byte[] iv = convert(ivStr.getBytes("UTF-8"), 16);
        //"AES"：请求的密钥算法的标准名称
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //192：密钥生成参数；securerandom：密钥生成器的随机源
        generator.init(module, new SecureRandom(bytes));

        //IV处理
        byte[] keyByte = convert(bytes, keyNum);
        //根据给定的字节数组构造一个密钥。enCodeFormat：密钥内容；"AES"：与给定的密钥内容相关联的密钥算法的名称
        key = new SecretKeySpec(keyByte, KEY_ALGORITHM);

        //将提供程序添加到下一个可用位置
        Security.addProvider(new BouncyCastleProvider());

        // 初始化cipher
        cipher = Cipher.getInstance(algorithmStr);
        cipherDTO.setCipher(cipher);
        cipherDTO.setKey(key);
        cipherDTO.setIv(iv);
        return cipherDTO;
    }
    /**
     * 加密返回字符串对象
     * @param data
     * @param cipherDTO
     * @return
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String encryptBase64(String data, CipherDTO cipherDTO) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] dataByte = data.getBytes("UTF-8");
        return Base64.encodeBase64String(encCore(dataByte,cipherDTO));
    }

    /**
     * 对byte数组进行加密
     * @param dataByte
     * @param cipherDTO
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public byte[] encryptByte(byte[]  dataByte, CipherDTO cipherDTO) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return encCore(dataByte,cipherDTO);
    }

    /**
     * 加密核心方法
     * @param dataByte
     * @param cipherDTO
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private byte[] encCore(byte[] dataByte, CipherDTO cipherDTO) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = cipherDTO.getCipher();
        cipher.init(Cipher.ENCRYPT_MODE, cipherDTO.getKey(), new IvParameterSpec(cipherDTO.getIv()));
        return cipher.doFinal(dataByte);
    }

    /**
     * 加密返回byte[]
     * @param data
     * @param cipherDTO
     * @return
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] encrypt(String data, CipherDTO cipherDTO) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = cipherDTO.getCipher();
        cipher.init(Cipher.ENCRYPT_MODE, cipherDTO.getKey(), new IvParameterSpec(cipherDTO.getIv()));
        byte[] encryptedText = cipher.doFinal(data.getBytes("UTF-8"));
        return encryptedText;
    }

    /**
     * 解密
     *
     * @param cipherText
     * @param cipherDTO
     * @return
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     */
    public String decryptBase64(String cipherText, CipherDTO cipherDTO) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] cpihers = Base64.decodeBase64(cipherText);
        Cipher cipher = cipherDTO.getCipher();
        cipher.init(Cipher.DECRYPT_MODE, cipherDTO.getKey(), new IvParameterSpec(cipherDTO.getIv()));
        byte[] result = cipher.doFinal(cpihers);
        return new String(result, "UTF-8");
    }

    /**
     * 解密
     *
     * @param cpihers
     * @param cipherDTO
     * @return
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     */
    public byte[] decrypt(byte[] cpihers, CipherDTO cipherDTO) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = cipherDTO.getCipher();
        cipher.init(Cipher.DECRYPT_MODE, cipherDTO.getKey(), new IvParameterSpec(cipherDTO.getIv()));
        byte[] result = cipher.doFinal(cpihers);
        return result;
    }

    /**
     * 签名
     *
     * @param encyData
     * @return
     */
    public String signData(String encyData) {
        System.out.println("签名的入参" + encyData);
        //1.对密文进行sha256
        byte[] sha256Byte = SHA256Util.encryption(encyData);

        //2.再Base64.encode
        String signStr = Base64.encodeBase64String(sha256Byte);
        return signStr;
    }

    /**
     * 验签
     *
     * @param data 签名值明文
     * @param sign    签名数据(hashCode后再Base64)
     * @return
     */
    public boolean signCheck(String data, String sign) {
        byte[] sha256Byte = SHA256Util.encryption(data);
        return sign.equals(Base64.encodeBase64String(sha256Byte));
    }

    /**
     * byte 补位
     *
     * @param keyBytes
     * @param base
     * @return
     */
    private byte[] convert(byte[] keyBytes, int base) {
        byte[] iv = keyBytes;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
            iv = keyBytes;
        }
        return iv;
    }
}
