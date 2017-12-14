package devutility.internal.base;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSingletonFactory {
	// region variables

	private static volatile Map<String, ThreadLocal<Object>> container = new HashMap<>();

	// endregion

	// region create

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
				instance = clazz.newInstance();
				ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
				threadLocal.set(instance);
				container.put(key, threadLocal);
			}
		}

		return instance;
	}

	// endregion
}