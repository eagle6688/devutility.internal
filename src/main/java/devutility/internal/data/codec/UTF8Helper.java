package devutility.internal.data.codec;

import java.io.UnsupportedEncodingException;

public class UTF8Helper {
	// region encode

	public static byte[] encode(String value) throws UnsupportedEncodingException {
		if (value == null) {
			return null;
		}

		return value.getBytes("UTF-8");
	}

	// endregion

	// region decode

	public static String decode(byte[] bytes) throws UnsupportedEncodingException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return new String(bytes, "UTF-8");
	}

	// endregion
}