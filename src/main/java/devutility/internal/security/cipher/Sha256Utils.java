package devutility.internal.security.cipher;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import devutility.internal.data.codec.Utf8Utils;
import devutility.internal.data.converter.ConverterUtils;

public class Sha256Utils {
	/**
	 * Encipher bytes in SHA256.
	 * @param bytes: Bytes.
	 * @return byte[]
	 */
	public static byte[] encipher(byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			return messageDigest.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Encipher string value to Hex.
	 * @param value: Input string.
	 * @return String
	 */
	public static String encipherToHex(String value) {
		byte[] bytes = null;

		try {
			bytes = Utf8Utils.encode(value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] encipheredBytes = encipher(bytes);
		return ConverterUtils.bytesToHex(encipheredBytes);
	}
}