package devutility.internal.cache;

/**
 * 
 * CacheConfig
 * 
 * @author: Aldwin Su
 * @version: 2020-04-05 23:12:17
 */
public class CacheConfig {
	/**
	 * Default key format for cache.
	 */
	private final static String KEY_FORMAT = "$DU-CACHE-%s";

	/**
	 * Get key of cache with provided cache value.
	 * @param value Cache value.
	 * @return String
	 */
	public static String getKey(Object value) {
		if (value == null) {
			return null;
		}

		return String.format(KEY_FORMAT, value.getClass().getName().toUpperCase());
	}

	/**
	 * Get key of cache with provided Class object.
	 * @param clazz Class object.
	 * @return String
	 */
	public static String getKey(Class<?> clazz) {
		if (clazz == null) {
			return null;
		}

		return String.format(KEY_FORMAT, clazz.getName().toUpperCase());
	}
}