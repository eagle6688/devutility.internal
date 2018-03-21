package devutility.internal.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import devutility.internal.base.Convertor;
import devutility.internal.util.DateHelper;

public class DataHelper {
	/**
	 * toString 
	 * @return String
	 */
	public static String toString(Object value) {
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

	/**
	 * arrayToString 
	 * @return String
	 */
	private static String arrayToString(Object[] array, Class<?> componentType) {
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
	 * stringToList 
	 * @return List<T>
	 */
	public static <T> List<T> stringToList(String value, Class<T> clazz) {
		List<T> list = new ArrayList<>();
		String[] array = value.split(",");

		for (String item : array) {
			list.add(Convertor.stringToType(item, clazz));
		}

		return list;
	}
}