package devutility.internal.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import devutility.internal.lang.StringHelper;
import devutility.internal.util.DateHelper;

public class Convertor {
	/**
	 * intToByte
	 * @param number
	 * @return byte
	 */
	public static byte intToByte(int number) {
		return (byte) number;
	}

	/**
	 * byteToInt
	 * @param b
	 * @return int
	 */
	public static int byteToInt(byte b) {
		return b & 0xFF;
	}

	/**
	 * bytesToLong
	 * @return long
	 */
	public static long bytesToLong(byte[] bytes, boolean littleEndian) {
		ByteBuffer buffer = ByteBuffer.wrap(bytes, 0, 8);

		if (littleEndian) {
			buffer.order(ByteOrder.LITTLE_ENDIAN);
		}

		return buffer.getLong();
	}

	/**
	 * bytesToLong
	 * @param bytes
	 * @return long
	 */
	public static long bytesToLong(byte[] bytes) {
		return bytesToLong(bytes, false);
	}

	/**
	 * bytesToHex
	 * @param bytes
	 * @return String
	 */
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

	/**
	 * array to string
	 * @param array
	 * @param componentType
	 * @return String
	 */
	public static String arrayToString(Object[] array, Class<?> componentType) {
		if (componentType == String.class) {
			return String.join(",", (String[]) array);
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (Object object : array) {
			stringBuilder.append(object.toString());
			stringBuilder.append(",");
		}

		return stringBuilder.substring(0, stringBuilder.length() - 2);
	}

	/**
	 * int array to integer list
	 * @param array
	 * @return ArrayList
	 */
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

	/**
	 * list to int array
	 * @param list
	 * @return int[]
	 * @throws InstantiationException
	 * @throws IllegalAccessException int[]
	 */
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

	/**
	 * string to type
	 * @param value
	 * @param clazz
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stringToType(String value, Class<T> clazz) {
		if (StringHelper.isNullOrEmpty(value)) {
			return null;
		}

		if (clazz == Byte.class) {
			return (T) Byte.valueOf(value);
		}

		if (clazz == Short.class) {
			return (T) Short.valueOf(value);
		}

		if (clazz == Integer.class) {
			return (T) Integer.valueOf(value);
		}

		if (clazz == Long.class) {
			return (T) Long.valueOf(value);
		}

		if (clazz == Float.class) {
			return (T) Float.valueOf(value);
		}

		if (clazz == Double.class) {
			return (T) Double.valueOf(value);
		}

		if (clazz == Character.class) {
			return (T) Character.valueOf(value.toCharArray()[0]);
		}

		if (clazz == Boolean.class) {
			return (T) Boolean.valueOf(value);
		}

		if (clazz == String.class) {
			return (T) value;
		}

		if (clazz == Date.class) {
			try {
				return (T) DateHelper.standardToDate(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * string to list
	 * @param value
	 * @param clazz
	 * @return List
	 */
	public static <T> List<T> stringToList(String value, String separator, Class<T> clazz) {
		List<T> list = new ArrayList<>();
		String[] array = value.split(separator);

		for (String item : array) {
			list.add(Convertor.stringToType(item, clazz));
		}

		return list;
	}

	/**
	 * string to int
	 * @param value
	 * @return int
	 */
	public static int stringToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * object to string
	 * @param value
	 * @return String
	 */
	public static String objectToString(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			return arrayToString((Object[]) value, clazz.getComponentType());
		}

		if (clazz == Date.class) {
			return DateHelper.formatToStandard((Date) value);
		}

		return value.toString();
	}
}