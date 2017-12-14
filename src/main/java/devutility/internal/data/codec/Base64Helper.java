package devutility.internal.data.codec;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Helper {
	// region encode

	public static byte[] encode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getEncoder().encode(bytes);
	}

	// endregion

	// region encode to String

	public static String encodeToString(byte[] bytes) {
		byte[] base64Bytes = encode(bytes);

		try {
			return UTF8Helper.decode(base64Bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	// endregion

	// region decode

	public static byte[] decode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getDecoder().decode(bytes);
	}

	// endregion

	// region decode by String

	public static byte[] decodeByString(String value) {
		try {
			byte[] base64Bytes = UTF8Helper.encode(value);
			return decode(base64Bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// endregion
}