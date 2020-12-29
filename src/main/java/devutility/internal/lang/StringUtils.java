package devutility.internal.lang;

/**
 * 
 * StringUtils
 * 
 * @author: Aldwin Su
 * @version: 2017-05-31 23:31:38
 */
public class StringUtils {
	/**
	 * Check provided String value is null or empty?
	 * @param value String value.
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.length() == 0 || value.trim().length() == 0;
	}

	public static boolean isNumberic(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}

		return true;
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

	public static String upperFirstCase(String value) {
		char[] array = value.toCharArray();

		if (array[0] >= 'a' && array[0] <= 'z') {
			array[0] = (char) (array[0] - 32);
		}

		return String.valueOf(array);
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