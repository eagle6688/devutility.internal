package devutility.internal.lang;

/**
 * 
 * ArrayUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-02-17 22:58:52
 */
public class ArrayUtils {
	/**
	 * Whether elements null or empty?
	 * @param array Array need check.
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Whether elements not empty?
	 * @param array Array need check.
	 * @return boolean
	 */
	public static boolean isNotEmpty(Object... array) {
		return array != null && array.length > 0;
	}

	/**
	 * Convert each of element of array to String type and join them together into one string.
	 * @param array Array need to join together.
	 * @param delimiter the delimiter that separates each element.
	 * @param prefix Prefix of each element.
	 * @param suffix Suffix of each element.
	 * @return String
	 */
	public static String join(Object[] array, String delimiter, String prefix, String suffix) {
		if (array == null || array.length == 0) {
			return null;
		}

		String _prefix = prefix != null ? prefix : "";
		String _suffix = suffix != null ? suffix : "";
		StringBuilder stringBuilder = new StringBuilder();

		for (Object object : array) {
			stringBuilder.append(_prefix);
			stringBuilder.append(object.toString());
			stringBuilder.append(_suffix);
			stringBuilder.append(delimiter);
		}

		return stringBuilder.substring(0, stringBuilder.length() - delimiter.length());
	}

	/**
	 * Convert each of element to String type and join them together into one string.
	 * @param array Array need to join together.
	 * @param delimiter the delimiter that separates each element.
	 * @return String
	 */
	public static String join(Object[] array, String delimiter) {
		return join(array, delimiter, null, null);
	}

	/**
	 * Serialize array to string.
	 * @param array array need to serialize.
	 * @return String
	 */
	public static String serialize(Object[] array) {
		return join(array, ",", "\"", "\"");
	}
}