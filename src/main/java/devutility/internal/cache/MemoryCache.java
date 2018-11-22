package devutility.internal.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devutility.internal.lang.StringUtils;
import devutility.internal.util.CollectionUtils;

public class MemoryCache {
	/**
	 * Container
	 */
	private static volatile Map<String, CacheEntry> container = new HashMap<>();

	/**
	 * Set entry in memory.
	 * @param entry: Entry object.
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

	public static boolean set(String key, Object value, int expireSeconds) {
		CacheEntry entry = new CacheEntry(key, value, expireSeconds);
		return set(entry);
	}

	public static boolean set(String key, Object value) {
		return set(key, value, 0);
	}

	public static Object get(String key) {
		CacheEntry entry = container.get(key);

		if (entry == null) {
			return null;
		}

		if (entry.expired()) {
			del(key);
			return null;
		}

		return entry.getValue();
	}

	public static <T> T get(String key, Class<T> clazz) {
		Object value = get(key);

		if (value == null) {
			return null;
		}

		return clazz.cast(value);
	}

	public static <T> List<T> getList(String key) {
		Object value = get(key);

		if (value == null || !(value instanceof ArrayList)) {
			return new ArrayList<>();
		}

		@SuppressWarnings("unchecked")
		List<T> list = (ArrayList<T>) value;
		return list;
	}

	public static <T> List<T> getList(String key, Class<T> clazz) {
		Object value = get(key);

		if (value == null || !(value instanceof ArrayList)) {
			return new ArrayList<>();
		}

		@SuppressWarnings("unchecked")
		List<Object> objs = ArrayList.class.cast(value);
		List<T> list = new ArrayList<>();

		for (Object obj : objs) {
			list.add(clazz.cast(obj));
		}

		return list;
	}

	public static void del(String key) {
		synchronized (MemoryCache.class) {
			if (container.containsKey(key)) {
				container.remove(key);
			}
		}
	}
}