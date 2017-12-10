package devutility.internal.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Convertor {
	// region string to int

	public static int stringToInt(String value) {
		try {
			int result = Integer.parseInt(value);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}

	// endregion

	// region byte to int

	public static int byteToInt(byte b) {
		return b & 0xFF;
	}

	// endregion

	// region int to byte

	public static byte intToByte(int number) {
		return (byte) number;
	}

	// endregion

	// region bytes to long

	public static long bytesToLong(byte[] bytes, boolean littleEndian) {
		ByteBuffer buffer = ByteBuffer.wrap(bytes, 0, 8);

		if (littleEndian) {
			buffer.order(ByteOrder.LITTLE_ENDIAN);
		}

		return buffer.getLong();
	}

	public static long bytesToLong(byte[] bytes) {
		return bytesToLong(bytes, false);
	}

	// endregion

	// region to Hex

	public static String toHex(byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		StringBuffer stringBuffer = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append(Character.forDigit((bytes[i] & 240) >> 4, 16));
			stringBuffer.append(Character.forDigit(bytes[i] & 15, 16));
		}

		return stringBuffer.toString();
	}

	// endregion
}