package devutility.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import devutility.internal.util.ListHelper;

public class MethodUtils {
	/**
	 * Method whether contains annotations?
	 * @param method: Method object.
	 * @param annotations: Annotations want to check.
	 * @return boolean
	 */
	public static boolean contain(Method method, List<Annotation> annotations) {
		if (method == null || annotations == null || annotations.size() == 0) {
			return false;
		}

		List<Annotation> fieldAnnotations = Arrays.asList(method.getAnnotations());
		return ListHelper.exist(annotations, i -> fieldAnnotations.contains(i));
	}
}