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
	 * @param elements Elements need check.
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(Object... elements) {
		return elements == null || elements.length == 0;
	}

	/**
	 * Whether elements not empty?
	 * @param elements Elements need check.
	 * @return boolean
	 */
	public static boolean isNotEmpty(Object... elements) {
		return elements != null && elements.length > 0;
	}

	/**
	 * Convert each of element to String type and join them together into one string.
	 * @param delimiter the delimiter that separates each element.
	 * @param elements the elements to join together.
	 * @return String
	 */
	public static String join(String delimiter, Object... elements) {
		if (elements == null || elements.length == 0) {
			return null;
		}

		Class<?> componentType = elements[1].getClass();

		if (componentType == String.class) {
			return String.join(delimiter, (String[]) elements);
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (Object object : elements) {
			stringBuilder.append(object.toString());
			stringBuilder.append(delimiter);
		}

		return stringBuilder.substring(0, stringBuilder.length() - delimiter.length() - 1);
	}
}