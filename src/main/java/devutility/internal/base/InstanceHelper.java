package devutility.internal.base;

public class InstanceHelper {
	public static boolean notInstanceof(Object object, Class<?> cl) {
		return !cl.isInstance(object);
	}

	public static boolean isJaveClass(Class<?> cl) {
		return cl != null && cl.getClassLoader() == null;
	}
}