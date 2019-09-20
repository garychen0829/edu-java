package util;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class RSAUtil {
    private static final String MD5_WITH_RSA = "MD5withRSA";
    private static final String RSA_ALGORTHM = "RSA";

    public RSAUtil() {
    }

    public static String[] generateKeyPair(int keySize) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA_ALGORTHM);
        keyPairGen.initialize(keySize, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        String privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
        String publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
        String[] keys = new String[]{privateKey, publicKey};
        return keys;
    }

    public static String encryptWithBase64(String data, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    public static String decryptWithBase64(String data, String privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORTHM);
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        cipher.init(2, key);
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

    public static String signBase64(String content, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5_WITH_RSA);
        signature.initSign(key);
        signature.update(content.getBytes());
        byte[] signed = signature.sign();
        return Base64.encodeBase64String(signed);
    }


    public static boolean verifyBase64(String content, String sign, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5_WITH_RSA);
        signature.initVerify(key);
        signature.update(content.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }


    public static String signBase64_RSA(String content, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("NONEwithRSA");
        signature.initSign(key);
        signature.update(content.getBytes());
        byte[] signed = signature.sign();
        return Base64.encodeBase64String(signed);
    }


    public static String decryptRSA(String data, String privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORTHM);
        byte[] keyBytes = privateKey.getBytes();
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORTHM);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        cipher.init(2, key);
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

}