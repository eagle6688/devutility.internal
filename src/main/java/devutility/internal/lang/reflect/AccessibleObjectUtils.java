package devutility.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import devutility.internal.annotations.Order;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * AccessibleObjectUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-09 23:42:01
 */
public class AccessibleObjectUtils {
	/**
	 * Return Order value by provided AccessibleObject object. 0 will return if there is no Order Annotation added.
	 * @param accessibleObject AccessibleObject object.
	 * @return int
	 */
	public static int getOrder(AccessibleObject accessibleObject) {
		Order order = accessibleObject.getAnnotation(Order.class);

		if (order == null) {
			return 0;
		}

		return order.value();
	}

	/**
	 * Check whether provided AccessibleObject object contains annotations or not?
	 * @param accessibleObject AccessibleObject object.
	 * @param annotations Annotations need check.
	 * @return boolean
	 */
	public static boolean containAnnotations(AccessibleObject accessibleObject, Collection<Annotation> annotations) {
		if (accessibleObject == null || CollectionUtils.isNullOrEmpty(annotations)) {
			return false;
		}

		List<Annotation> fieldAnnotations = Arrays.asList(accessibleObject.getAnnotations());
		return CollectionUtils.exist(annotations, i -> fieldAnnotations.contains(i));
	}

	/**
	 * Check whether provided Field object contains annotations or not?
	 * @param accessibleObject AccessibleObject object.
	 * @param annotationClasses Class objects of annotations need check.
	 * @return boolean
	 */
	public static boolean containAnnotationClasses(AccessibleObject accessibleObject, Collection<Class<? extends Annotation>> annotationClasses) {
		if (accessibleObject == null || CollectionUtils.isNullOrEmpty(annotationClasses)) {
			return false;
		}

		for (Class<? extends Annotation> annotationClass : annotationClasses) {
			if (accessibleObject.isAnnotationPresent(annotationClass)) {
				return true;
			}
		}

		return false;
	}
}