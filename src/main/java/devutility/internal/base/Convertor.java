package devutility.internal.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class Convertor {
	// region string to int

	public static int stringToInt(String value) {
		try {
			int result = Integer.parseInt(value);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
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

	// region bytes to Hex

	public static String bytesToHex(byte[] bytes) {
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

	// region int Array to Integer ArrayList

	public static ArrayList<Integer> intArrayToIntegerList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		ArrayList<Integer> list = new ArrayList<>(array.length);

		for (int i : array) {
			list.add(i);
		}

		return list;
	}

	// endregion

	// region list to int Array

	public static <T> int[] listToIntArray(ArrayList<T> list) throws InstantiationException, IllegalAccessException {
		if (list == null || list.size() == 0 || !(list.get(0) instanceof Integer)) {
			return new int[0];
		}

		Integer[] integers = list.toArray(new Integer[0]);
		int[] array = new int[list.size()];
		int index = 0;

		for (index = 0; index < list.size(); index++) {
			array[index] = integers[index];
		}

		return array;
	}

	// endregion
}