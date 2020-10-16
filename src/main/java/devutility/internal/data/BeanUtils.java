package devutility.internal.data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.lang.ClassUtils;
import devutility.internal.lang.EnumUtils;
import devutility.internal.lang.StringUtils;
import devutility.internal.model.ObjectField;

/**
 * 
 * BeanUtils
 * 
 * @author: Aldwin Su
 * @creation: 2017-10-26 17:29:55
 */
public class BeanUtils {
	public static void setField(Object model, Field field, Method setter, Object value) {

	}

	/**
	 * Set value for provided field.
	 * @param setter Setter method for field
	 * @param model Object that need set.
	 * @param value String value
	 * @param field Field that need set
	 * @throws IllegalAccessException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws InvocationTargetException from invoke method.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setField(Method setter, Object model, String value, Field field) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (StringUtils.isNullOrEmpty(value)) {
			return;
		}

		Class<?> clazz = field.getType();

		if (clazz.isArray()) {
			List<?> list = ConverterUtils.stringToList(value, ",", clazz.getComponentType());
			setArrayField(setter, model, list, clazz);
		}

		if (List.class.isAssignableFrom(clazz)) {
			Class<?> genericClass = ClassUtils.getGenericClass(field.getGenericType());

			if (genericClass == null) {
				return;
			}

			List<?> list = ConverterUtils.stringToList(value, ",", genericClass);
			setter.invoke(model, list);
		}

		Object obj = ConverterUtils.stringToType(value, clazz);

		if (obj != null) {
			setter.invoke(model, obj);
		}

		if (Enum.class.isAssignableFrom(clazz) && EnumUtils.maxConstructorParameterCount(clazz) <= 2) {
			Object enumValue = null;

			try {
				enumValue = Enum.valueOf((Class<? extends Enum>) clazz, value);
			} catch (Exception e) {
			}

			if (enumValue != null) {
				setter.invoke(model, enumValue);
			}
		}
	}

	/**
	 * Set field value with Array type.
	 * @param setter Setter method for field
	 * @param model Object that need set
	 * @param list List value for field
	 * @param fieldClazz Field class
	 * @throws IllegalAccessException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws InvocationTargetException from invoke method.
	 */
	private static void setArrayField(Method setter, Object model, List<?> list, Class<?> fieldClazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

		if (componentType == Date.class) {
			Date[] array = list.toArray(new Date[0]);
			setter.invoke(model, new Object[] { array });
		}
	}

	/**
	 * Convert object to an String Array.
	 * @param entity Bean object.
	 * @param entityFields EntityField list.
	 * @return String[]
	 * @throws IllegalAccessException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws InvocationTargetException from invoke method.
	 */
	public static <T> String[] toArray(T entity, List<ObjectField> entityFields) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (entity == null || entityFields.size() == 0) {
			return null;
		}

		String[] array = new String[entityFields.size()];

		for (int i = 0; i < entityFields.size(); i++) {
			ObjectField entityField = entityFields.get(i);
			Method method = entityField.getGetter();
			Object value = method.invoke(entity);

			if (value != null) {
				array[i] = ConverterUtils.objectToString(value);
			}
		}

		return array;
	}

	/**
	 * Convert an String array to an object.
	 * @param array String array.
	 * @param entityFields EntityField objects list.
	 * @param clazz Class object of entity.
	 * @return {@code T}
	 * @throws IllegalAccessException from setField method.
	 * @throws IllegalArgumentException from setField method.
	 * @throws InvocationTargetException from setField method.
	 */
	public static <T> T toEntity(String[] array, List<ObjectField> entityFields, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (array == null || array.length == 0 || entityFields == null || entityFields.size() == 0) {
			return null;
		}

		T entity = ClassUtils.instance(clazz);

		for (int i = 0; i < entityFields.size() && i < array.length; i++) {
			if (array[i] == null) {
				continue;
			}

			ObjectField entityField = entityFields.get(i);
			Field field = entityField.getField();
			Method setter = entityField.getSetter();
			setField(setter, entity, array[i], field);
		}

		return entity;
	}
}