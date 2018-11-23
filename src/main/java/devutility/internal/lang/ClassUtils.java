package devutility.internal.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import devutility.internal.lang.models.EntityField;
import devutility.internal.lang.models.EntityFieldUtils;
import devutility.internal.util.CollectionUtils;

public class ClassUtils {
	/**
	 * Create a new instance.
	 * @param clazz: Class object
	 * @return {@code  T}
	 * @throws ReflectiveOperationException
	 */
	public static <T> T newInstance(Class<T> clazz) throws ReflectiveOperationException {
		return clazz.getDeclaredConstructor().newInstance();
	}

	/**
	 * Create a new instance.
	 * @param clazz: Class object
	 * @return {@code  T}
	 */
	public static <T> T instance(Class<T> clazz) {
		try {
			return newInstance(clazz);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get super classes include itself.
	 * @param clazz: Class object
	 * @return {@code List<Class<?>>}
	 */
	public static <T> List<Class<?>> getSuperClasses(Class<T> clazz) {
		List<Class<?>> list = new LinkedList<>();

		if (clazz == null) {
			return list;
		}

		Class<?> temp = clazz;

		while (temp != null && !"java.lang.Object".equals(temp.getCanonicalName())) {
			list.add(temp);
			temp = temp.getSuperclass();
		}

		return list;
	}

	public static List<Field> getAllDeclaredFields(Class<?> clazz) {
		List<Field> list = new ArrayList<>();
		List<Class<?>> classes = getSuperClasses(clazz);

		if (classes.size() == 0) {
			return list;
		}

		for (Class<?> cl : classes) {
			list.addAll(Arrays.asList(cl.getDeclaredFields()));
		}

		return list;
	}

	public static List<Method> getAllDeclaredMethods(Class<?> clazz) {
		List<Method> list = new ArrayList<>();
		List<Class<?>> classes = getSuperClasses(clazz);

		if (classes.size() == 0) {
			return list;
		}

		for (Class<?> cl : classes) {
			list.addAll(Arrays.asList(cl.getDeclaredMethods()));
		}

		return list;
	}

	/**
	 * Get EntityFields and include specified fields.
	 * @param includeFields: Fields want to include.
	 * @param clazz: Class object
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getIncludedEntityFields(List<String> includeFields, Class<?> clazz) {
		List<EntityField> list = getEntityFields(clazz);
		return EntityFieldUtils.includeEntityFields(list, includeFields);
	}

	/**
	 * Get EntityFields and exclude specified fields.
	 * @param clazz: Class object
	 * @param excludeFields: Fields want to exclude.
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getNonExcludedEntityFields(List<String> excludeFields, Class<?> clazz) {
		List<EntityField> list = getEntityFields(clazz);
		return EntityFieldUtils.excludeEntityFields(list, excludeFields);
	}

	/**
	 * Get EntityFields and exclude specified annotations.
	 * @param clazz: Class object
	 * @param excludeAnnotations: Annotations want to be excluded.
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getNonExcludedEntityFields(Annotation[] excludeAnnotations, Class<?> clazz) {
		List<EntityField> list = getEntityFields(clazz);
		List<Annotation> annotations = Arrays.asList(excludeAnnotations);
		return CollectionUtils.list(list, i -> i.containAnnotations(annotations));
	}

	/**
	 * Get EntityFields.
	 * @param clazz: Class object
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getEntityFields(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Illegal parameter!");
		}

		List<Field> declaredFields = getAllDeclaredFields(clazz);
		List<Method> declaredMethods = getAllDeclaredMethods(clazz);
		List<EntityField> list = new ArrayList<>(declaredFields.size());

		for (Field declaredField : declaredFields) {
			Method setter = getSetter(declaredField.getName(), declaredMethods);
			Method getter = getGetter(declaredField, declaredMethods);

			if (setter == null || getter == null) {
				continue;
			}

			EntityField entityField = new EntityField();
			entityField.setField(declaredField);
			entityField.setSetter(setter);
			entityField.setGetter(getter);
			list.add(entityField);
		}

		list.sort((ef1, ef2) -> ef1.getField().getName().compareTo(ef2.getField().getName()));
		return list;
	}

	public static boolean isGetterField(Field field, List<String> methods) {
		String name = String.format("get%s", StringUtils.upperFirstCase(field.getName()));

		if (methods.contains(name)) {
			return true;
		}

		return isBoolField(field, methods);
	}

	private static boolean isBoolField(Field field, List<String> methods) {
		if (field.getType() != Boolean.class) {
			return false;
		}

		String name = String.format("is%s", StringUtils.upperFirstCase(field.getName()));
		return methods.contains(name);
	}

	public static boolean isSetterField(String field, List<String> methods) {
		String name = String.format("set%s", StringUtils.upperFirstCase(field));
		return methods.contains(name);
	}

	public static Method getSetter(String field, List<Method> methods) {
		String name = String.format("set%s", StringUtils.upperFirstCase(field));

		for (Method method : methods) {
			if (name.equals(method.getName())) {
				return method;
			}
		}

		return null;
	}

	public static Method getGetter(Field field, List<Method> methods) {
		Class<?> fieldType = field.getType();
		String name = String.format("get%s", StringUtils.upperFirstCase(field.getName()));

		if (fieldType == Boolean.class || "boolean".equals(fieldType.getName())) {
			name = String.format("is%s", StringUtils.upperFirstCase(field.getName()));
		}

		for (Method method : methods) {
			if (name.equals(method.getName())) {
				return method;
			}
		}

		return null;
	}

	public static Class<?> getGenericClass(Type genericType) {
		if (genericType != null && genericType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			return (Class<?>) parameterizedType.getActualTypeArguments()[0];
		}

		return null;
	}

	/**
	 * Get Method object by provided name and clazz.
	 * @param name: Method name.
	 * @param clazz: Class object.
	 * @return Method
	 */
	public static Method getMethod(String name, Class<?> clazz) {
		List<Method> methods = getAllDeclaredMethods(clazz);
		return CollectionUtils.find(methods, i -> name.equals(i.getName()));
	}

	/**
	 * Check whether object is instance of clazz?
	 * @param object: Object need check.
	 * @param clazz: Target Class object.
	 * @return boolean
	 */
	public static boolean isInstanceOf(Object object, Class<?> clazz) {
		return clazz.isInstance(object) || clazz.isAssignableFrom(object.getClass());
	}

	/**
	 * Whether clazz is Jave class
	 * @param clazz: Class object need check
	 * @return boolean
	 */
	public static boolean isJaveClass(Class<?> clazz) {
		return clazz != null && clazz.getClassLoader() == null;
	}
}