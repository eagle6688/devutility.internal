package devutility.internal.security.cipher;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 
 * AesUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-08-07 15:16:23
 */
public class AesUtils {
	public SecretKey secretKey(String key, int keySize) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(keySize, new SecureRandom(key.getBytes()));
		return keyGenerator.generateKey();
	}

	public SecretKey secretKey(String key) throws NoSuchAlgorithmException {
		return secretKey(key, 128);
	}
}