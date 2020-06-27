package devutility.internal.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * MemoryCache
 * 
 * @author: Aldwin Su
 * @version: 2017-11-22 17:40:28
 */
public class MemoryCache {
	/**
	 * Container
	 */
	private static volatile Map<String, CacheEntry<?>> CONTAINER = new LinkedHashMap<>();

	/**
	 * Set CacheEntry object in container.
	 * @param entry CacheEntry object.
	 * @return boolean
	 */
	public static boolean set(CacheEntry<?> entry) {
		if (entry == null) {
			return false;
		}

		synchronized (CONTAINER) {
			CONTAINER.put(entry.getKey(), entry);
		}

		return true;
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 * @return boolean
	 */
	public static <T> boolean set(String key, T value, long expirationMillis, long version) {
		return set(new CacheEntry<T>(key, value, expirationMillis, version));
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @return boolean
	 */
	public static <T> boolean set(String key, T value, long expirationMillis) {
		return set(new CacheEntry<T>(key, value, expirationMillis));
	}

	/**
	 * Set cache data in memory.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @return boolean
	 */
	public static <T> boolean set(String key, T value) {
		return set(new CacheEntry<T>(key, value));
	}

	/**
	 * Delete CacheEntry object from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 */
	public static synchronized void del(String key) {
		if (CONTAINER.containsKey(key)) {
			CONTAINER.remove(key);
		}
	}

	/**
	 * Get CacheEntry<T> object from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param version The latest version, this field is used for determine whether the version of cache is the latest
	 *            version.
	 * @return {@code CacheEntry<T>}
	 */
	@SuppressWarnings("unchecked")
	public static <T> CacheEntry<T> getEntry(String key, long version) {
		CacheEntry<?> entry = CONTAINER.get(key);

		if (entry == null) {
			return null;
		}

		if (!entry.isAvailable(version)) {
			del(key);
			return null;
		}

		return (CacheEntry<T>) entry;
	}

	/**
	 * Get CacheEntry<T> object from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> getEntry(String key) {
		return getEntry(key, 0);
	}

	/**
	 * Get value from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param version The latest version, this field is used for determine whether the version of cache is the latest
	 *            version.
	 * @return {@code T}
	 */
	public static <T> T get(String key, long version) {
		CacheEntry<T> entry = getEntry(key, version);

		if (entry == null) {
			return null;
		}

		return entry.getValue();
	}

	/**
	 * Get value from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @return {@code T}
	 */
	public static <T> T get(String key) {
		return get(key, 0);
	}
}