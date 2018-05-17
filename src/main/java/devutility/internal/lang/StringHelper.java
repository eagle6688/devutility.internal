package devutility.internal.lang;

public class StringHelper {
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.length() == 0 || value.trim().length() == 0;
	}

	public static boolean isNotEmpty(String value) {
		return !isNullOrEmpty(value);
	}

	public static String concat(String... str) {
		if (str.length == 0) {
			return null;
		}

		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < str.length; i++) {
			stringBuffer.append(str[i]);
		}

		return stringBuffer.toString();
	}

	public static String trimEnd(String value, String tail) {
		if (value == null || tail == null) {
			return value;
		}

		int index = value.indexOf(tail);

		if (index == value.length() - tail.length()) {
			return value.substring(0, index);
		}

		return value;
	}
}