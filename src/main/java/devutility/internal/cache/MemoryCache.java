package devutility.internal.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * MemoryCache
 * 
 * @author: Aldwin Su
 * @creation: 2017-11-22 17:40:28
 */
public class MemoryCache {
	/**
	 * Default key format for cache.
	 */
	private final static String KEY_FORMAT = "$DU-CACHE-%s";

	/**
	 * Container
	 */
	private static volatile Map<String, CacheEntry<?>> CONTAINER = new LinkedHashMap<>();

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

	/**
	 * Set CacheEntry object in container.
	 * @param entry CacheEntry<T> object.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(CacheEntry<T> entry) {
		if (entry == null) {
			throw new IllegalArgumentException("CacheEntry can't be null!");
		}

		synchronized (CONTAINER) {
			CONTAINER.put(entry.getKey(), entry);
		}

		return entry;
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(String key, T value, long expirationMillis, long version) {
		return set(new CacheEntry<T>(key, value, expirationMillis, version));
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(String key, T value, long expirationMillis) {
		return set(new CacheEntry<T>(key, value, expirationMillis));
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(String key, T value) {
		return set(new CacheEntry<T>(key, value));
	}

	/**
	 * Delete CacheEntry object in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 */
	public static synchronized void del(String key) {
		if (CONTAINER.containsKey(key)) {
			CONTAINER.remove(key);
		}
	}

	/**
	 * Update CacheEntry object in cache container.
	 * @param entry {@code CacheEntry<T>} object.
	 * @param targetVersion Version of CacheEntry object need to be updated.
	 * @return boolean
	 */
	public static <T> boolean update(CacheEntry<T> entry, long targetVersion) {
		if (entry == null) {
			throw new IllegalArgumentException("CacheEntry can't be null!");
		}

		if (entry.getVersion() == targetVersion) {
			throw new IllegalArgumentException("Invalid version, current cache version can't same as new version!");
		}

		synchronized (CONTAINER) {
			CacheEntry<T> cachedEntry = getEntry(entry.getKey());

			if (cachedEntry == null) {
				CONTAINER.put(entry.getKey(), entry);
				return true;
			}

			if (cachedEntry.getVersion() == targetVersion) {
				CONTAINER.put(entry.getKey(), entry);
				return true;
			}
		}

		return false;
	}

	/**
	 * Update data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expirationMillis Expiration time in milliseconds, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 * @param targetVersion Version of CacheEntry object need to be updated.
	 * @return boolean
	 */
	public static <T> boolean update(String key, T value, long expirationMillis, long version, long targetVersion) {
		return update(new CacheEntry<T>(key, value, expirationMillis, version), targetVersion);
	}

	/**
	 * Update data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param version Version of CacheEntry object.
	 * @param targetVersion Version of CacheEntry object need to be updated.
	 * @return boolean
	 */
	public static <T> boolean update(String key, T value, long version, long targetVersion) {
		return update(key, value, 0, version, targetVersion);
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