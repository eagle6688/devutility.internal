package devutility.internal.lang;

/**
 * 
 * BytesUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-05-26 15:19:07
 */
public class BytesUtils {
	/**
	 * Whether provided array is null or empty?
	 * @param array byte array.
	 * @return boolean
	 */
	public static boolean isNotEmpty(byte... array) {
		return array != null && array.length > 0;
	}

	/**
	 * Whether provided array is null or empty?
	 * @param array byte array.
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(byte[] array) {
		return array == null || array.length == 0;
	}
}