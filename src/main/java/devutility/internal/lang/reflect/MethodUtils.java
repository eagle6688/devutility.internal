package devutility.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.StringUtils;
import devutility.internal.util.CollectionUtils;

public class MethodUtils {
	/**
	 * Method whether contains annotations?
	 * @param method: Method object.
	 * @param annotations: Annotations want to check.
	 * @return boolean
	 */
	public static boolean contain(Method method, List<Annotation> annotations) {
		if (method == null || CollectionUtils.isNullOrEmpty(annotations)) {
			return false;
		}

		List<Annotation> fieldAnnotations = Arrays.asList(method.getAnnotations());
		return CollectionUtils.exist(annotations, i -> fieldAnnotations.contains(i));
	}

	/**
	 * Find Method object from Method objects by method name.
	 * @param name Method name.
	 * @param methods Method object.
	 * @return Method
	 */
	public static Method find(String name, List<Method> methods) {
		for (Method method : methods) {
			if (name.equals(method.getName())) {
				return method;
			}
		}

		return null;
	}

	/**
	 * Return name of Getter method.
	 * @param field Field object.
	 * @return String
	 */
	public static String getterName(Field field) {
		Class<?> fieldType = field.getType();

		if (fieldType == Boolean.class || "boolean".equals(fieldType.getName())) {
			return String.format("is%s", StringUtils.upperFirstCase(field.getName()));
		}

		return String.format("get%s", StringUtils.upperFirstCase(field.getName()));
	}

	/**
	 * Return name of Setter method.
	 * @param field Field object.
	 * @return String
	 */
	public static String setterName(String field) {
		return String.format("set%s", StringUtils.upperFirstCase(field));
	}

	/**
	 * Does field has Getter method or not?
	 * @param field Field object.
	 * @param methods Names of methods.
	 * @return boolean
	 */
	public static boolean hasGetter(Field field, List<String> methods) {
		String name = getterName(field);
		return methods.contains(name);
	}

	/**
	 * Does field has Getter method or not?
	 * @param field Field object.
	 * @param methods Names of methods.
	 * @return boolean
	 */
	public static boolean hasSetter(String field, List<String> methods) {
		String name = setterName(field);
		return methods.contains(name);
	}

	/**
	 * Return Setter Method object.
	 * @param field Field object.
	 * @param methods Method objects.
	 * @return Method
	 */
	public static Method setter(String field, List<Method> methods) {
		String name = setterName(field);
		return find(name, methods);
	}

	/**
	 * Return Getter Method object.
	 * @param field Field object.
	 * @param methods Method objects.
	 * @return Method
	 */
	public static Method getter(Field field, List<Method> methods) {
		String name = getterName(field);
		return find(name, methods);
	}
}