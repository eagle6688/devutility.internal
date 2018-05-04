package devutility.internal.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.models.EntityField;

public class ClassHelper {
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

	public static <T> List<Class<?>> getAllClasses(Class<T> clazz) {
		List<Class<?>> list = new ArrayList<>();

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
		List<Class<?>> classes = getAllClasses(clazz);

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
		List<Class<?>> classes = getAllClasses(clazz);

		if (classes.size() == 0) {
			return list;
		}

		for (Class<?> cl : classes) {
			list.addAll(Arrays.asList(cl.getDeclaredMethods()));
		}

		return list;
	}

	/**
	 * Get EntityFields and exclude specified annotations.
	 * @param clazz: Class object
	 * @param excludeAnnotations: Annotations want to be excluded.
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getEntityFields(Class<?> clazz, List<String> excludeFields) {
		if (clazz == null) {
			return new ArrayList<>();
		}

		List<Field> declaredFields = getAllDeclaredFields(clazz);
		List<Method> declaredMethods = getAllDeclaredMethods(clazz);
		List<EntityField> list = new ArrayList<>(declaredFields.size());

		for (Field declaredField : declaredFields) {
			if (excludeFields != null && excludeFields.contains(declaredField.getName())) {
				continue;
			}

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

	/**
	 * Get EntityFields.
	 * @param clazz: Class object
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getEntityFields(Class<?> clazz) {
		return getEntityFields(clazz, new ArrayList<String>());
	}

	/**
	 * Get EntityFields and exclude specified annotations.
	 * @param clazz: Class object
	 * @param excludeAnnotations: Annotations want to be excluded.
	 * @return {@code List<EntityField>}
	 */
	public static List<EntityField> getEntityFields(Class<?> clazz, Annotation[] excludeAnnotations) {
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

			if (entityField.containAnnotations(Arrays.asList(excludeAnnotations))) {
				continue;
			}

			list.add(entityField);
		}

		list.sort((ef1, ef2) -> ef1.getField().getName().compareTo(ef2.getField().getName()));
		return list;
	}

	public static boolean isGetterField(Field field, List<String> methods) {
		String name = String.format("get%s", StringHelper.uppercase(field.getName()));

		if (methods.contains(name)) {
			return true;
		}

		return isBoolField(field, methods);
	}

	private static boolean isBoolField(Field field, List<String> methods) {
		if (field.getType() != Boolean.class) {
			return false;
		}

		String name = String.format("is%s", StringHelper.uppercase(field.getName()));
		return methods.contains(name);
	}

	public static boolean isSetterField(String field, List<String> methods) {
		String name = String.format("set%s", StringHelper.uppercase(field));
		return methods.contains(name);
	}

	public static Method getSetter(String field, List<Method> methods) {
		String name = String.format("set%s", StringHelper.uppercase(field));

		for (Method method : methods) {
			if (name.equals(method.getName())) {
				return method;
			}
		}

		return null;
	}

	public static Method getGetter(Field field, List<Method> methods) {
		Class<?> fieldType = field.getType();
		String name = String.format("get%s", StringHelper.uppercase(field.getName()));

		if (fieldType == Boolean.class) {
			name = String.format("is%s", StringHelper.uppercase(field.getName()));
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