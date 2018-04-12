package devutility.internal.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import devutility.internal.lang.ClassHelper;

public class ThreadLocalSingletonFactory {
	/**
	 * Container for singleton object.
	 */
	private static volatile ConcurrentMap<String, ThreadLocal<Object>> container = new ConcurrentHashMap<>();

	/**
	 * Create a singleton object.
	 * @param clazz: Class of singleton object.
	 * @return {@literal: T}
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T create(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		T instance = null;
		String key = clazz.getName();
		ThreadLocal<Object> tl = container.get(key);

		if (tl != null) {
			Object value = tl.get();

			if (value != null && value.getClass().isAssignableFrom(clazz)) {
				return clazz.cast(value);
			}

			container.put(key, null);
		}

		synchronized (ThreadLocalSingletonFactory.class) {
			if (container.get(key) == null) {
				instance = ClassHelper.newInstance(clazz);
				ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
				threadLocal.set(instance);
				container.put(key, threadLocal);
			}
		}

		return instance;
	}

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