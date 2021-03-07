package devutility.internal.cache;

import java.util.LinkedHashMap;
import java.util.Map;

import devutility.internal.com.CommonResultCode;

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
			throw new IllegalArgumentException("CacheEntry can't be null.");
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
	 * @param expiration Expiration time in millisecond, default 0 means no expiration.
	 * @param version Version of CacheEntry object.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(String key, T value, long expiration, long version) {
		return set(new CacheEntry<T>(key, value, expiration, version));
	}

	/**
	 * Set data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value Cache value.
	 * @param expiration Expiration time in millisecond, default 0 means no expiration.
	 * @return {@code CacheEntry<T>}
	 */
	public static <T> CacheEntry<T> set(String key, T value, long expiration) {
		return set(new CacheEntry<T>(key, value, expiration));
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
	 * Modify data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value New cache value.
	 * @param version Version of saved CacheEntry object.
	 * @param newVersion New version of CacheEntry object need to be updated.
	 * @return {@code BaseResponse<T> with original value}.
	 */
	public static <T> CacheResponse<T> modify(String key, T value, long version, long newVersion) {
		CacheResponse<T> response = new CacheResponse<>();

		if (version == newVersion) {
			response.setError(CommonResultCode.PARAMETERINVALID.getCodeAsString(), "New cache version %d can't same as cached version %d.", newVersion, version);
			return response;
		}

		CacheEntry<T> cacheEntry = getEntry(key);

		if (cacheEntry == null) {
			response.setError(CommonResultCode.PARAMETERINVALID.getCodeAsString(), "CacheEntry with key %s not found.", key);
			return response;
		}

		if (cacheEntry.getVersion() != version) {
			response.setError(CommonResultCode.PARAMETERINVALID.getCodeAsString(), "Cached version %d different with provided version %d.", cacheEntry.getVersion(), version);
			return response;
		}

		synchronized (CONTAINER) {
			if (cacheEntry.getVersion() == version) {
				cacheEntry.setValue(value, newVersion);
			} else {
				response.setError(CommonResultCode.CONCURRENTERROR.getCodeAsString(), "Cached version %d different with provided version %d.", cacheEntry.getVersion(), version);
			}

			response.setData(cacheEntry);
		}

		return response;
	}

	/**
	 * Modify data in cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @param value New cache value.
	 * @param version Version of saved CacheEntry object.
	 * @return {@code BaseResponse<T> with original value}.
	 */
	public static <T> CacheResponse<T> modify(String key, T value, long version) {
		return modify(key, value, version, version + 1);
	}

	/**
	 * Get CacheEntry<T> object from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @return {@code CacheEntry<T>}
	 */
	@SuppressWarnings("unchecked")
	public static <T> CacheEntry<T> getEntry(String key) {
		CacheEntry<?> entry = CONTAINER.get(key);

		if (entry == null) {
			return null;
		}

		if (entry.isExpired()) {
			del(key);
			return null;
		}

		return (CacheEntry<T>) entry;
	}

	/**
	 * Get value from cache container.
	 * @param key Key of CacheEntry object in cache container.
	 * @return {@code T}
	 */
	public static <T> T get(String key) {
		CacheEntry<T> entry = getEntry(key);

		if (entry == null) {
			return null;
		}

		return entry.getValue();
	}
}