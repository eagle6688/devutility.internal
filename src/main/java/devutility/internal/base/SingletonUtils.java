package devutility.internal.base;

import devutility.internal.lang.ClassHelper;

public class SingletonUtils {
	/**
	 * Singleton instance.
	 */
	private static volatile Object instance = null;

	/**
	 * Create singleton instance.
	 * @param clazz
	 * @return T
	 */
	public static <T> T create(Class<T> clazz) {
		if (instance != null) {
			return clazz.cast(instance);
		}

		synchronized (SingletonFactory.class) {
			if (instance == null) {
				instance = ClassHelper.newInstance(clazz);
			}
		}

		return clazz.cast(instance);
	}
}