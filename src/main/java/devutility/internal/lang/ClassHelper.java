package devutility.internal.lang;

import java.lang.reflect.InvocationTargetException;

public class ClassHelper {
	public static <T> T newInstanceEx(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return clazz.getDeclaredConstructor().newInstance();
	}

	public static <T> T newInstance(Class<T> clazz) {
		try {
			return newInstanceEx(clazz);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object newInstanceObj(Class<?> clazz) {
		try {
			return newInstanceEx(clazz);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}