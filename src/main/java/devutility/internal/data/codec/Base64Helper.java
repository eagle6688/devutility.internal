package devutility.internal.data.codec;

import java.util.Base64;

public class Base64Helper {
	public static byte[] encode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getEncoder().encode(bytes);
	}

	public static byte[] decode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		return Base64.getDecoder().decode(bytes);
	}
}