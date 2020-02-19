package devutility.internal.data.converter;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import devutility.internal.annotations.Convertor;
import devutility.internal.base.SingletonFactory;
import devutility.internal.lang.ArrayUtils;
import devutility.internal.lang.StringUtils;
import devutility.internal.lang.reflect.MethodUtils;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * ConvertorUtils
 * 
 * @author: Aldwin Su
 */
public class ConverterUtils {
	/**
	 * Convert value with source type to value with target type.
	 * @param value Source type value.
	 * @param converter Converter object.
	 * @return {@code T Target value}
	 */
	public static <S, T> T convert(S value, Converter<S, T> converter) {
		return converter.convert(value);
	}

	/**
	 * Convert value with source type to value with target type.
	 * @param value Source type value.
	 * @param sClass Class object for source type.
	 * @param tClass Class object for target type.
	 * @return T
	 */
	public static <S, T> T convert(S value, Class<S> sClass, Class<T> tClass) {
		Converter<S, T> converter = getConverter(sClass, tClass);

		if (converter != null) {
			return converter.convert(value);
		}

		Method convertorMethod = getConvertorMethod(sClass, tClass);

		if (convertorMethod != null) {
			return MethodUtils.<T>quietCall(convertorMethod, value);
		}

		return null;
	}

	/**
	 * Get Converter object with provided source and target Class objects.
	 * @param sClazz Class object for source type.
	 * @param tClazz Class object for target type.
	 * @return {@code Converter<S,T>}
	 */
	public static <S, T> Converter<S, T> getConverter(Class<S> sClazz, Class<T> tClazz) {
		return ConverterCacheUtils.getConverterFromCache(sClazz, tClazz);
	}

	/**
	 * Get method annotated with Convertor by provided source Class object and target Class object.
	 * @param sClazz Source Class object.
	 * @param tClazz Target Class object.
	 * @return Method
	 */
	public static <S, T> Method getConvertorMethod(Class<S> sClazz, Class<T> tClazz) {
		String key = ConverterCacheUtils.getCacheKeyForConvertorMethod(sClazz.getName(), tClazz.getName());
		Method convertorMethod = SingletonFactory.get(key, Method.class);

		if (convertorMethod != null) {
			return convertorMethod;
		}

		List<Method> methods = new LinkedList<>();
		methods.addAll(Arrays.asList(sClazz.getDeclaredMethods()));
		methods.addAll(Arrays.asList(tClazz.getDeclaredMethods()));

		for (Method method : methods) {
			if (method.isAnnotationPresent(Convertor.class)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				Class<?> returnType = method.getReturnType();

				if (parameterTypes != null && parameterTypes.length == 1 && parameterTypes[0].equals(sClazz) && returnType != null && returnType.equals(tClazz)) {
					convertorMethod = method;
					break;
				}
			}
		}

		if (convertorMethod != null) {
			SingletonFactory.save(key, convertorMethod);
		}

		return convertorMethod;
	}

	/**
	 * Convert int value to byte value.
	 * @param value int value.
	 * @return byte
	 */
	public static byte intToByte(int value) {
		return (byte) value;
	}

	/**
	 * Convert int value to byte array.
	 * @param value int value.
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
	 * Convert byte value to int value.
	 * @param value byte value.
	 * @return int
	 */
	public static int byteToInt(byte value) {
		return value & 0xFF;
	}

	/**
	 * Convert byte array to long value.
	 * @param bytes bytes array.
	 * @param littleEndian whether need little endian or not?
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
	 * Convert byte array to long value.
	 * @param bytes bytes array.
	 * @return long
	 */
	public static long bytesToLong(byte[] bytes) {
		return bytesToLong(bytes, false);
	}

	/**
	 * Convert byte array to hex string.
	 * @param bytes bytes array.
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
	 * Convert int array to integer list.
	 * @param array int array.
	 * @return List
	 */
	public static List<Integer> intArrayToIntegerList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		List<Integer> list = new ArrayList<>(array.length);

		for (int i : array) {
			list.add(i);
		}

		return list;
	}

	/**
	 * Convert collection to int array
	 * @return int[] array with int elements.
	 */
	public static int[] listToIntArray(Collection<? extends Integer> collection) {
		if (CollectionUtils.isNullOrEmpty(collection)) {
			return null;
		}

		int index = 0;
		int[] array = new int[collection.size()];

		for (int element : collection) {
			array[index++] = element;
		}

		return array;
	}

	/**
	 * Convert string value to specific type.
	 * @param value string value.
	 * @param clazz target class.
	 * @return {@code T}
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

		return convert(value, String.class, clazz);
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
			list.add(stringToType(item, clazz));
		}

		return list;
	}

	/**
	 * Convert string to int value.
	 * @param value String value.
	 * @return int
	 */
	public static int stringToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Convert object to string
	 * @param value Object value.
	 * @return String
	 */
	public static String objectToString(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (clazz == Date.class) {
			long time = ((Date) value).getTime();
			return String.valueOf(time);
		}

		if (clazz.isArray()) {
			return ArrayUtils.join(",", (Object[]) value);
		}

		return value.toString();
	}

	/**
	 * Convert Object value to long type.
	 * @param value Object value with unknow type.
	 * @return long
	 */
	public static long objectTolong(Object value) {
		String className = value.getClass().getName();

		switch (className) {
		case "java.lang.Short":
			return ((Short) value).longValue();

		case "java.lang.Integer":
			return ((Integer) value).longValue();

		case "java.lang.Float":
			return ((Float) value).longValue();

		case "java.lang.Double":
			return ((Double) value).longValue();

		case "java.lang.Long":
			return (Long) value;

		case "java.lang.String":
			return Long.parseLong((String) value);

		default:
			return 0;
		}
	}

	/**
	 * Convert Object value to int type.
	 * @param value Object value with unknow type.
	 * @return int
	 */
	public static int objectToint(Object value) {
		String className = value.getClass().getName();

		switch (className) {
		case "java.lang.Short":
			return ((Short) value).intValue();

		case "java.lang.Integer":
			return (Integer) value;

		case "java.lang.Float":
			return ((Float) value).intValue();

		case "java.lang.Double":
			return ((Double) value).intValue();

		case "java.lang.Long":
			return ((Long) value).intValue();

		case "java.lang.String":
			return Integer.parseInt((String) value);

		default:
			return 0;
		}
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