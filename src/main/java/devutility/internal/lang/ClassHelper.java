package devutility.internal.lang;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.models.EntityField;

public class ClassHelper {
	public static <T> T newInstanceEx(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return clazz.getDeclaredConstructor().newInstance();
	}

	public static <T> T newInstance(Class<T> clazz) {
		try {
			return newInstanceEx(clazz);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object newInstanceObj(Class<?> clazz) {
		try {
			return newInstanceEx(clazz);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
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

	public static List<EntityField> getEntityFields(Class<?> clazz) {
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