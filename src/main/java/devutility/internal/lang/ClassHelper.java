package devutility.internal.lang;

import java.lang.reflect.InvocationTargetException;

public class ClassHelper {
	public static <T> T newInstanceWE(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return clazz.getDeclaredConstructor().newInstance();
	}

	public static <T> T newInstance(Class<T> clazz) {
		try {
			return newInstanceWE(clazz);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}