package devutility.internal.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import devutility.internal.lang.ClassHelper;

public class SingletonFactory {
	/**
	 * Container for singleton object.
	 */
	private static volatile ConcurrentMap<String, Object> container = new ConcurrentHashMap<>();

	/**
	 * Get container of SingletonFactory
	 * @return ConcurrentMap<String,Object>
	 */
	public static ConcurrentMap<String, Object> getContainer() {
		return container;
	}

	/**
	 * Get or create a singleton object.
	 * @param clazz: Class of singleton object.
	 * @return {@code: T}
	 */
	public static <T> T get(Class<T> clazz) {
		String key = clazz.getName();
		return get(key, clazz);
	}

	/**
	 * Get a singleton object.
	 * @param key: Key of singleton object to save.
	 * @param clazz: Class of singleton object.
	 * @return {@code: T}
	 */
	public static <T> T get(String key, Class<T> clazz) {
		if (container.get(key) != null) {
			Object value = container.get(key);

			if (value != null && value.getClass().isAssignableFrom(clazz)) {
				return clazz.cast(value);
			}

			container.remove(key);
		}

		return null;
	}

	/**
	 * Create a singleton object.
	 * @param clazz: Class of singleton object.
	 * @return {@code: T}
	 */
	public static <T> T create(Class<T> clazz) {
		String key = clazz.getName();
		return create(key, clazz);
	}

	/**
	 * Create a singleton object.
	 * @param Key of singleton object to save.
	 * @param Class of singleton object.
	 * @return {@code:T}
	 */
	public static <T> T create(String key, Class<T> clazz) {
		T instance = get(key, clazz);

		if (instance != null) {
			return instance;
		}

		synchronized (SingletonFactory.class) {
			if (container.get(key) == null) {
				T value = ClassHelper.newInstance(clazz);
				container.put(key, value);
			}
		}

		return clazz.cast(container.get(key));
	}
}