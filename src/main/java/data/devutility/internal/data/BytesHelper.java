package devutility.internal.data;

import java.util.ArrayList;

public class BytesHelper {

	/**
	 * Insert value into bytes and return a new byte array.
	 *
	 * @return a new byte arra.
	 */
	public static byte[] insert(byte[] bytes, long startIndex, byte[] value) {
		int length = bytes.length;

		if (startIndex < 0 || startIndex > length || value == null || value.length == 0) {
			return new byte[0];
		}

		int valueLength = value.length;
		byte[] result = new byte[length + valueLength];

		for (long i = length - 1; i > startIndex - 1; i--) {
		}
		
		return result;
	}
}