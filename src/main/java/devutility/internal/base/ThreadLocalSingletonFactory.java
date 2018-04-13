package devutility.internal.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import devutility.internal.lang.ClassHelper;

public class ThreadLocalSingletonFactory {
	/**
	 * Container for singleton objects.
	 */
	private static volatile ConcurrentMap<String, ThreadLocal<Object>> container = new ConcurrentHashMap<>();

	/**
	 * Get container of ThreadLocalSingletonFactory
	 * @return ConcurrentMap<String,ThreadLocal<Object>>
	 */
	public static ConcurrentMap<String, ThreadLocal<Object>> getContainer() {
		return container;
	}

	/**
	 * Create a singleton object.
	 * @param clazz: Class of singleton object.
	 * @return {@code: T}
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T create(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		String key = clazz.getName();
		return create(key, clazz);
	}

	/**
	 * Create a singleton object.
	 * @param key: Key of singleton object in container.
	 * @param clazz: Class of singleton object.
	 * @return {@code: T}
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T create(String key, Class<T> clazz) throws InstantiationException, IllegalAccessException {
		ThreadLocal<Object> threadLocal = container.get(key);

		if (threadLocal != null) {
			Object value = threadLocal.get();

			if (value != null && value.getClass().isAssignableFrom(clazz)) {
				return clazz.cast(value);
			}

			container.put(key, null);
		}

		synchronized (ThreadLocalSingletonFactory.class) {
			if (container.get(key) == null) {
				T instance = ClassHelper.newInstance(clazz);
				threadLocal = new ThreadLocal<Object>();
				threadLocal.set(instance);
				container.put(key, threadLocal);
			}
		}

		return clazz.cast(container.get(key).get());
	}
}