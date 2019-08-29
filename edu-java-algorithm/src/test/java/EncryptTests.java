import com.aes.IAES;
import com.aes.SHA256Util;
import com.aes.en.AESModule;
import com.aes.impl.AES192Impl;
import org.junit.Test;

public class EncryptTests {

    @Test
    public void encrypt(){
        String iv = "0000000000000000";
        String key = "zcSmartCom_JZSY_20180808";

        String body = "{\"name\": 2, \"email\": \"app@zcsmart.com\"}";
        IAES iaes = new AES192Impl();

        String encode = iaes.encDataBase64(body, AESModule.AES_192_CBC_PKCS7, key, iv);
        String hashBody = SHA256Util.encrypt(encode);

        String info = "{\"clientId\": 2, \"timestamp\": \"20180408120000\", \"hashBody\":\""+hashBody+"\",\"encType\":\"1\"}";
        String sign = iaes.signData(info);
        System.out.println("encode==>" + encode + ", sign: "+ sign);

        System.out.println("===>checkSign: "+iaes.signCheck(info, sign));

        String decode = iaes.decDataBase64(encode, AESModule.AES_192_CBC_PKCS7, key, iv);
        System.out.println("decode==>" + decode);
    }
}
