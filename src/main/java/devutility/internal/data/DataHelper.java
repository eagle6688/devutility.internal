package devutility.internal.data;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
	public static String toString(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			return arrayToString((Object[]) value, clazz.getComponentType());
		}

		return value.toString();
	}

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

	public static <T> List<T> toList(String value, Class<T> componentType) {
		List<T> list = new ArrayList<>();
		String[] array = value.split(",");

		for (String item : array) {
			list.add(componentType.cast(item));
		}

		return list;
	}
}