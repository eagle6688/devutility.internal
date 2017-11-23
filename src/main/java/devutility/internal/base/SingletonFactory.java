package devutility.internal.base;

import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {
	private static volatile Map<String, ThreadLocal<Object>> container = new HashMap<>();

	public static <T> T create(Class<T> clazz) throws ReflectiveOperationException {
		T instance = null;
		String key = clazz.getName();
		ThreadLocal<Object> threadLocal = container.get(key);

		if (threadLocal != null) {
			Object value = threadLocal.get();

			if (value != null) {
				instance = clazz.cast(value);
				return instance;
			}
		}

		synchronized (SingletonFactory.class) {
			if (threadLocal == null || instance == null) {
				try {
					instance = clazz.newInstance();
					threadLocal = new ThreadLocal<Object>();
					threadLocal.set(instance);
					container.put(key, threadLocal);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}

		return instance;
	}
}