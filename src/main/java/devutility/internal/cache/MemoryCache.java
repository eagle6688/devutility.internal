package devutility.internal.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
	 * Set cache data in container.
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
	 * Get cache value from memory.
	 * @param key Cache key for value.
	 * @param timestamp This field is used for determine whether the version of cache is the latest version.
	 * @return Object
	 */
	public static Object get(String key, long timestamp) {
		CacheEntry<?> entry = CONTAINER.get(key);

		if (entry == null) {
			return null;
		}

		if (entry.isExpired() || !entry.isLatest(timestamp)) {
			del(key);
			return null;
		}

		return entry.getValue();
	}

	/**
	 * Get cache value from memory and convert to original type.
	 * @param key Cache key for value.
	 * @param timestamp This field is used for determine whether the version of cache is the latest version.
	 * @param clazz Original Class object.
	 * @return {@code T}
	 */
	public static <T> T get(String key, long timestamp, Class<T> clazz) {
		Object value = get(key, timestamp);

		if (value == null) {
			return null;
		}

		return clazz.cast(value);
	}

	/**
	 * Get cache value from memory.
	 * @param key Cache key for value.
	 * @return Object
	 */
	public static Object get(String key) {
		return get(key, 0);
	}

	/**
	 * Get cache value from memory.
	 * @param key Cache key for value.
	 * @param clazz Original Class object.
	 * @return {@code T}
	 */
	public static <T> T get(String key, Class<T> clazz) {
		Object value = get(key);

		if (value == null) {
			return null;
		}

		return clazz.cast(value);
	}

	/**
	 * Get cache value from memory and convert to List.
	 * @param key Cache key for value.
	 * @param clazz Original Class object.
	 * @return {@code List<T>}
	 */
	public static <T> List<T> list(String key, Class<T> clazz) {
		return list(key, 0, clazz);
	}

	/**
	 * Get cache value from memory and convert to List.
	 * @param key Cache key for value.
	 * @param timestamp This field is used for determine whether the version of cache is the latest version.
	 * @param clazz Original Class object.
	 * @return {@code List<E>}
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> list(String key, long timestamp, Class<E> clazz) {
		List<E> list = new ArrayList<>();
		Object value = get(key, timestamp);

		if (value == null) {
			return list;
		}

		Class<?> valueClazz = value.getClass();

		if (!List.class.isAssignableFrom(valueClazz)) {
			return list;
		}

		if (ArrayList.class.isAssignableFrom(valueClazz)) {
			return (ArrayList<E>) value;
		}

		if (LinkedList.class.isAssignableFrom(valueClazz)) {
			return (LinkedList<E>) value;
		}

		if (Vector.class.isAssignableFrom(valueClazz)) {
			return (Vector<E>) value;
		}

		return list;
	}

	/**
	 * Delete CacheEntry from memory.
	 * @param key Cache key for value.
	 */
	public static void del(String key) {
		synchronized (MemoryCache.class) {
			if (CONTAINER.containsKey(key)) {
				CONTAINER.remove(key);
			}
		}
	}
}