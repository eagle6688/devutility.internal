package devutility.internal.cache;

import java.util.HashMap;
import java.util.Map;

import devutility.internal.lang.StringHelper;

public class MemoryCache {
	private static volatile Object locker = new Object();
	private static Map<String, CacheEntry> container = new HashMap<>();

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

	public static boolean set(CacheEntry entry) {
		if (entry == null || StringHelper.isNullOrEmpty(entry.getKey()) || entry.getValue() == null) {
			return false;
		}

		if (container.containsKey(entry.getKey())) {
			return false;
		}

		synchronized (locker) {
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

	public static void del(String key) {
		synchronized (locker) {
			if (container.containsKey(key)) {
				container.remove(key);
			}
		}
	}
}