package devutility.internal.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import devutility.internal.lang.StringUtils;
import devutility.internal.util.CollectionUtils;

public class MemoryCache {
	/**
	 * Container
	 */
	private static volatile Map<String, CacheEntry> container = new HashMap<>();

	/**
	 * Set entry in memory.
	 * @param entry Entry object.
	 * @return boolean
	 */
	public static boolean set(CacheEntry entry) {
		if (entry == null || StringUtils.isNullOrEmpty(entry.getKey()) || entry.getValue() == null) {
			return false;
		}

		if (entry.getValue() instanceof Collection) {
			Collection<?> collection = Collection.class.cast(entry.getValue());

			if (CollectionUtils.isNullOrEmpty(collection)) {
				return false;
			}
		}

		synchronized (MemoryCache.class) {
			container.put(entry.getKey(), entry);
		}

		return true;
	}

	/**
	 * Set value in memory.
	 * @param key Cache key for value.
	 * @param value Cache value need to be saved in memory.
	 * @param expireSeconds Expire time in seconds.
	 * @return boolean
	 */
	public static boolean set(String key, Object value, int expireSeconds) {
		return set(new CacheEntry(key, value, expireSeconds));
	}

	/**
	 * Set value in memory.
	 * @param key Cache key for value.
	 * @param value Cache value need to be saved in memory.
	 * @return boolean
	 */
	public static boolean set(String key, Object value) {
		return set(key, value, 0);
	}

	/**
	 * Get cache value from memory.
	 * @param key Cache key for value.
	 * @param timestamp This field is used for determine whether the version of cache is the latest version.
	 * @return Object
	 */
	public static Object get(String key, long timestamp) {
		CacheEntry entry = container.get(key);

		if (entry == null) {
			return null;
		}

		if (entry.expired() || !entry.latestVersion(timestamp)) {
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
			if (container.containsKey(key)) {
				container.remove(key);
			}
		}
	}
}