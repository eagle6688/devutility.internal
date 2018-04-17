package devutility.internal.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import devutility.internal.base.Convertor;
import devutility.internal.data.codec.Base64Helper;
import devutility.internal.data.codec.UTF8Utils;

public class MD5Helper {
	// region encipher

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

	public static String encipherToBase64(String value) {
		byte[] bytes = null;

		try {
			bytes = UTF8Utils.encode(value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] encipheredBytes = encipher(bytes);
		return Base64Helper.encodeToString(encipheredBytes);
	}

	public static String encipherToHex(String value) {
		byte[] bytes = null;

		try {
			bytes = UTF8Utils.encode(value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] encipheredBytes = encipher(bytes);
		return Convertor.bytesToHex(encipheredBytes);
	}

	// endregion
}