package devutility.internal.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devutility.internal.lang.StringUtils;

public class MemoryCache {
	private static volatile Map<String, CacheEntry> container = new HashMap<>();

	// region set

	public static boolean set(CacheEntry entry) {
		if (entry == null || StringUtils.isNullOrEmpty(entry.getKey()) || entry.getValue() == null) {
			return false;
		}

		if (container.containsKey(entry.getKey())) {
			return false;
		}

		synchronized (MemoryCache.class) {
			if (!container.containsKey(entry.getKey())) {
				container.put(entry.getKey(), entry);
				return true;
			}
		}

		return false;
	}

	public static boolean set(String key, Object value, int expireSeconds) {
		CacheEntry entry = new CacheEntry(key, value, expireSeconds);
		return set(entry);
	}

	public static boolean set(String key, Object value) {
		return set(key, value, 0);
	}

	// endregion

	// region get

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

	// endregion

	// region get list

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

	// endregion

	// region del

	public static void del(String key) {
		synchronized (MemoryCache.class) {
			if (container.containsKey(key)) {
				container.remove(key);
			}
		}
	}

	// endregion
}