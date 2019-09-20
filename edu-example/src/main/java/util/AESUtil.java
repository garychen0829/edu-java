package util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.Base64;
import java.util.UUID;

/**
 * AES 工具类
 *
 */
public class AESUtil {
	private static final String PROVIDER = "BC";
	public static final String AES = "AES";
	private static final int KEY_SIZE = 16;

	/**
	 * AES 加密
	 * 
	 * @param content
	 * @param secret
	 *            密钥 长度需要16位
	 * @return
	 */
	public static String encrypt(String content, String secret) {
		if (secret.length() != KEY_SIZE) {
			return null;
		}
		try {
			Key key = new SecretKeySpec(secret.getBytes(), AES);
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance(AES, PROVIDER);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] bytes = cipher.doFinal(content.getBytes());
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * AES 解密
	 */
	public static String decrypt(String content, String secret) {
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(content);

			Key key = new SecretKeySpec(secret.getBytes("utf-8"), AES);
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance(AES, PROVIDER);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] original = cipher.doFinal(decodedBytes);
			return new String(original,"utf-8");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 得到同步的秘钥
	 * 
	 * @return
	 */
	public static String genAesKey() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid.substring(0, KEY_SIZE);
	}
}