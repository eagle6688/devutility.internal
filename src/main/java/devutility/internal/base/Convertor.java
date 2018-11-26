package devutility.internal.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import devutility.internal.data.converter.Converter;
import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.lang.StringUtils;

public class Convertor {
	/**
	 * int to byte
	 * @param value: int value
	 * @return byte
	 */
	public static byte intToByte(int value) {
		return (byte) value;
	}

	/**
	 * int to bytes
	 * @param value: int value.
	 * @return byte[]
	 */
	public static byte[] intToBytes(int value) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (value & 0xFF);
		bytes[1] = (byte) ((value >> 8) & 0xFF);
		bytes[2] = (byte) ((value >> 16) & 0xFF);
		bytes[3] = (byte) ((value >> 24) & 0xFF);
		return bytes;
	}

	/**
	 * byte to int
	 * @param value: byte value
	 * @return int
	 */
	public static int byteToInt(byte value) {
		return value & 0xFF;
	}

	/**
	 * bytes to long
	 * @param bytes: bytes array
	 * @param littleEndian: whether need little endian or not?
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
	 * bytes to long
	 * @param bytes: bytes array
	 * @return long
	 */
	public static long bytesToLong(byte[] bytes) {
		return bytesToLong(bytes, false);
	}

	/**
	 * bytes to hex
	 * @param bytes: bytes array
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
	 * @param array: Object array
	 * @param componentType: array component type
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
	 * @param array: int array
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
	 * @param <T>: Generic type
	 * @param list: Integer list
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
	 * @param <T>: Generic type
	 * @param value: string value
	 * @param clazz: target class
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stringToType(String value, Class<T> clazz) {
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}

		if (clazz == Byte.class || clazz == byte.class) {
			return (T) Byte.valueOf(value);
		}

		if (clazz == Short.class || clazz == short.class) {
			return (T) Short.valueOf(value);
		}

		if (clazz == Integer.class || clazz == int.class) {
			return (T) Integer.valueOf(value);
		}

		if (clazz == Long.class || clazz == long.class) {
			return (T) Long.valueOf(value);
		}

		if (clazz == Float.class || clazz == float.class) {
			return (T) Float.valueOf(value);
		}

		if (clazz == Double.class || clazz == double.class) {
			return (T) Double.valueOf(value);
		}

		if (clazz == Character.class || clazz == char.class) {
			return (T) Character.valueOf(value.toCharArray()[0]);
		}

		if (clazz == Boolean.class || clazz == boolean.class) {
			return (T) Boolean.valueOf(value);
		}

		if (clazz == String.class) {
			return (T) value;
		}

		if (clazz == Date.class) {
			long time = Long.parseLong(value);
			return (T) new Date(time);
		}

		Converter<String, T> converter = ConverterUtils.find(String.class, clazz);

		if (converter != null) {
			return converter.convert(value);
		}

		return null;
	}

	/**
	 * string to list
	 * @param <T>: Generic type
	 * @param value: String value
	 * @param separator: separator for String value
	 * @param clazz: List generic class
	 * @return List
	 */
	public static <T> List<T> stringToList(String value, String separator, Class<T> clazz) {
		String[] array = value.split(separator);
		List<T> list = new ArrayList<>(array.length);

		for (String item : array) {
			list.add(Convertor.stringToType(item, clazz));
		}

		return list;
	}

	/**
	 * string to int
	 * @param value: String value
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
	 * @param value: Object value
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
			long time = ((Date) value).getTime();
			return String.valueOf(time);
		}

		return value.toString();
	}

	/**
	 * Convert S value to T value.
	 * @param value: S type value.
	 * @param converter: Convert.
	 * @return {@code T}
	 */
	public static <T, S> T convert(S value, Converter<S, T> converter) {
		return converter.convert(value);
	}

	/**
	 * Convert LocalDate To Date
	 * @param localDate: LocalDate object.
	 * @param zoneId: ZoneId object, default is ZoneId.systemDefault().
	 * @return Date
	 */
	public static Date localDateToDate(LocalDate localDate, ZoneId zoneId) {
		if (zoneId == null) {
			zoneId = ZoneId.systemDefault();
		}

		ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
		return Date.from(zonedDateTime.toInstant());
	}

	/**
	 * Convert LocalDateTime to Date.
	 * @param localDateTime: LocalDateTime object.
	 * @param zoneId: ZoneId object, default is ZoneId.systemDefault().
	 * @return Date
	 */
	public static Date localDateTimeToDate(LocalDateTime localDateTime, ZoneId zoneId) {
		if (zoneId == null) {
			zoneId = ZoneId.systemDefault();
		}

		ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
		return Date.from(zonedDateTime.toInstant());
	}
}