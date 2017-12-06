package devutility.internal.base;

import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {
	// region variables

	private static volatile Object value = null;

	private static volatile Map<String, Object> container = new HashMap<>();

	// endregion

	// region create

	public static <T> T create(Class<T> clazz) {
		String key = clazz.getName();
		return create(key, clazz);
	}

	public static <T> T create(String key, Class<T> clazz) {
		if (container.get(key) != null) {
			return clazz.cast(container.get(key));
		}

		synchronized (SingletonFactory.class) {
			if (container.get(key) == null) {
				try {
					value = clazz.newInstance();
					container.put(key, value);
					value = null;
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return clazz.cast(container.get(key));
	}

	// endregion
}