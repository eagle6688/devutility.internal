package devutility.internal.data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import devutility.internal.base.Convertor;
import devutility.internal.lang.ClassHelper;
import devutility.internal.lang.StringHelper;
import devutility.internal.lang.models.EntityField;

public class BeanUtils {
	/**
	 * Set value for field
	 * @param setter: Setter method for field
	 * @param model: Model that need set
	 * @param value: String value
	 * @param field: Field that need set
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void setField(Method setter, Object model, String value, Field field) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (StringHelper.isNullOrEmpty(value)) {
			return;
		}

		Class<?> clazz = field.getType();

		if (clazz.isArray()) {
			List<?> list = Convertor.stringToList(value, ",", clazz.getComponentType());
			setArrayField(setter, model, list, clazz);
		}

		if (List.class.isAssignableFrom(clazz)) {
			Class<?> genericClass = ClassHelper.getGenericClass(field.getGenericType());

			if (genericClass == null) {
				return;
			}

			List<?> list = Convertor.stringToList(value, ",", genericClass);
			setter.invoke(model, list);
		}

		Object obj = Convertor.stringToType(value, clazz);

		if (obj != null) {
			setter.invoke(model, obj);
		}
	}

	/**
	 * set array field
	 * @param setter: Setter method for field
	 * @param model: Model object
	 * @param list: List value for field
	 * @param fieldClazz: Field class
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException void
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
	 * Entity to Array
	 * @param entity: Bean object
	 * @param entityFields: EntityField list
	 * @return String[]
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> String[] toArray(T entity, List<EntityField> entityFields) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (entity == null || entityFields.size() == 0) {
			return null;
		}

		String[] array = new String[entityFields.size()];

		for (int i = 0; i < entityFields.size(); i++) {
			EntityField entityField = entityFields.get(i);
			Method method = entityField.getGetter();
			Object value = method.invoke(entity);

			if (value != null) {
				array[i] = Convertor.objectToString(value);
			}
		}

		return array;
	}

	/**
	 * Array to entity
	 * @param array: Array
	 * @param entityFields: EntityField list
	 * @param clazz: Class object of entity.
	 * @return {@code T}
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toEntity(String[] array, List<EntityField> entityFields, Class<T> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (array == null || array.length == 0 || entityFields == null || entityFields.size() == 0) {
			return null;
		}

		T entity = ClassHelper.instance(clazz);

		for (int i = 0; i < entityFields.size(); i++) {
			if (array[i] == null) {
				continue;
			}

			EntityField entityField = entityFields.get(i);
			Field field = entityField.getField();
			Method setter = entityField.getSetter();
			setField(setter, entity, array[i], field);
		}

		return entity;
	}
}