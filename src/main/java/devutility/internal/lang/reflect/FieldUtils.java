package devutility.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * 
 * FieldUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-09 23:32:11
 */
public class FieldUtils {
	/**
	 * Return Order value by provided Field object. If no Order setting, 0 will return.
	 * @param field Field object.
	 * @return int
	 */
	public static int getOrder(Field field) {
		return AccessibleObjectUtils.getOrder(field);
	}

	/**
	 * Check whether provided Field object contains annotations or not?
	 * @param field Field object.
	 * @param annotations Annotations need check.
	 * @return boolean
	 */
	public static boolean containAnnotations(Field field, Collection<Annotation> annotations) {
		return AccessibleObjectUtils.containAnnotations(field, annotations);
	}

	/**
	 * Check whether provided Field object contains annotations or not?
	 * @param field Field object.
	 * @param annotationClasses Class objects of Annotations need check.
	 * @return boolean
	 */
	public static boolean containAnnotationClasses(Field field, Collection<Class<? extends Annotation>> annotationClasses) {
		return AccessibleObjectUtils.containAnnotationClasses(field, annotationClasses);
	}
}