package devutility.internal.base;

public class InstanceHelper {
	public static boolean notInstanceof(Object object, Class<?> cl) {
		return !cl.isInstance(object);
	}
}