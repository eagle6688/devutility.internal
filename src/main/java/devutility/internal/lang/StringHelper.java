package devutility.internal.lang;

public class StringHelper {
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

	public static boolean isNullOrEmpty(String value) {
		return value == null || value.length() == 0 || value.trim().length() == 0;
	}

	public static String uppercase(String value) {
		char[] array = value.toCharArray();

		if (array[0] >= 'a' && array[0] <= 'z') {
			array[0] = (char) (array[0] - 32);
		}

		return String.valueOf(array);
	}
}