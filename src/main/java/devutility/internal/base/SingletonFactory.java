package devutility.internal.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import devutility.internal.lang.ClassHelper;

public class SingletonFactory {
	/**
	 * Singleton object.
	 */
	private static volatile Object value = null;

	/**
	 * Container for singleton object.
	 */
	private static volatile Map<String, Object> container = new ConcurrentHashMap<>();

	/**
	 * Create a singleton object.
	 * @param clazz: Class of singleton object.
	 * @return {@literal T}
	 */
	public static <T> T create(Class<T> clazz) {
		String key = clazz.getName();
		return create(key, clazz);
	}

	/**
	 * Create a singleton object.
	 * @param key: Key of singleton object to save.
	 * @param clazz: Class of singleton object.
	 * @return {@literal T}
	 */
	public static <T> T create(String key, Class<T> clazz) {
		if (container.get(key) != null) {
			return clazz.cast(container.get(key));
		}

		synchronized (SingletonFactory.class) {
			if (container.get(key) == null) {
				value = ClassHelper.newInstance(clazz);
				container.put(key, value);
				value = null;
			}
		}

		return clazz.cast(container.get(key));
	}
}