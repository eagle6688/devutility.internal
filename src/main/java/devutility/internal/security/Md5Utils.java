package devutility.internal.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import devutility.internal.data.codec.Base64Utils;
import devutility.internal.data.codec.Utf8Utils;
import devutility.internal.data.converter.ConverterUtils;

public class Md5Utils {
	/**
	 * Encipher bytes in MD5.
	 * @param bytes: Input bytes.
	 * @return byte[]
	 */
	public static byte[] encipher(byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			return messageDigest.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Encipher string value to Base64.
	 * @param value: Input string value.
	 * @return String
	 */
	public static String encipherToBase64(String value) {
		byte[] bytes = null;

		try {
			bytes = Utf8Utils.encode(value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] encipheredBytes = encipher(bytes);

		try {
			return Base64Utils.encodeToString(encipheredBytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Encipher string value to Hex.
	 * @param value: Input string value.
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