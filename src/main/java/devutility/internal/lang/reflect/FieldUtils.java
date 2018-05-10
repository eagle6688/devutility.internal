package devutility.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import devutility.internal.util.CollectionUtils;

public class FieldUtils {
	/**
	 * Field whether contains annotations?
	 * @param field: Field object
	 * @param annotations: Annotations want to check.
	 * @return boolean
	 */
	public static boolean contain(Field field, List<Annotation> annotations) {
		if (field == null || CollectionUtils.isNullOrEmpty(annotations)) {
			return false;
		}

		List<Annotation> fieldAnnotations = Arrays.asList(field.getAnnotations());
		return CollectionUtils.exist(annotations, i -> fieldAnnotations.contains(i));
	}
}