package devutility.internal.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import devutility.internal.lang.StringHelper;

public class BeanHelper {
	// region is setter

	public static boolean isSetter(String methodName, String fieldName) {
		if (StringHelper.isNullOrEmpty(methodName) || StringHelper.isNullOrEmpty(fieldName)) {
			return false;
		}

		return methodName.toLowerCase().equals("set" + fieldName.toLowerCase());
	}

	public static boolean isSetter(Method method, String fieldName) {
		return isSetter(method.getName(), fieldName);
	}

	// endregion

	// region is getter

	public static boolean isGetter(String methodName, String fieldName) {
		if (StringHelper.isNullOrEmpty(methodName) || StringHelper.isNullOrEmpty(fieldName)) {
			return false;
		}

		return methodName.toLowerCase().equals("get" + fieldName.toLowerCase());
	}

	public static boolean isGetter(Method method, String fieldName) {
		return isGetter(method.getName(), fieldName);
	}

	// endregion

	public static void setField(Method setter, Object model, String value, Class<?> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (StringHelper.isNullOrEmpty(value)) {
			return;
		}

		if (clazz == Byte.class) {
			setter.invoke(model, Byte.valueOf(value));
		}

		if (clazz == Short.class) {
			setter.invoke(model, Short.valueOf(value));
		}

		if (clazz == Integer.class) {
			setter.invoke(model, Integer.valueOf(value));
		}

		if (clazz == Long.class) {
			setter.invoke(model, Long.valueOf(value));
		}

		if (clazz == Float.class) {
			setter.invoke(model, Float.valueOf(value));
		}

		if (clazz == Double.class) {
			setter.invoke(model, Double.valueOf(value));
		}

		if (clazz == Character.class) {
			setter.invoke(model, value.toCharArray()[0]);
		}

		if (clazz == Boolean.class) {
			setter.invoke(model, Boolean.valueOf(value));
		}

		if (clazz == String.class) {
			setter.invoke(model, value);
		}
	}

	public static void setArrayField(Method setter, Object model, List<?> list, Class<?> fieldClazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> componentType = fieldClazz.getComponentType();

		if (componentType == Byte.class) {
			Byte[] array = list.toArray(new Byte[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Short.class) {
			Short[] array = list.toArray(new Short[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Integer.class) {
			Integer[] array = list.toArray(new Integer[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Long.class) {
			Long[] array = list.toArray(new Long[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Float.class) {
			Float[] array = list.toArray(new Float[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Double.class) {
			Double[] array = list.toArray(new Double[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Character.class) {
			Character[] array = list.toArray(new Character[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == Boolean.class) {
			Boolean[] array = list.toArray(new Boolean[0]);
			setter.invoke(model, new Object[] { array });
			return;
		}

		if (componentType == String.class) {
			String[] array = list.toArray(new String[0]);
			setter.invoke(model, new Object[] { array });
		}
	}
}