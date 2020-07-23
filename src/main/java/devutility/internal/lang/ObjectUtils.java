package devutility.internal.lang;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import devutility.internal.model.EntityField;

/**
 * 
 * ObjectUtils
 * 
 * @author: Aldwin Su
 * @creation: 2019-12-20 17:50:11
 */
public class ObjectUtils {
	/**
	 * Convert to http request parameter string. Such as {@literal asd=xxx&qwe=xxx}
	 * @param object Object need to convert.
	 * @param entityFields EntityField objects for provided object.
	 * @return String Http request parameters.
	 * @throws IllegalAccessException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws InvocationTargetException from invoke method.
	 */
	public static String toHttpRequestParams(Object object, List<EntityField> entityFields) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer buffer = new StringBuffer();

		for (EntityField entityField : entityFields) {
			Object value = entityField.getValue(object);

			if (value == null) {
				continue;
			}

			if (Collection.class.isAssignableFrom(value.getClass())) {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				String collectionString = String.join(",", (Collection) value);
				buffer.append(String.format("%s=%s&", entityField.getField().getName(), collectionString));
				continue;
			}

			if (value.getClass().isArray()) {
				//TODO: Need implementation
				continue;
			}

			buffer.append(String.format("%s=%s&", entityField.getField().getName(), value.toString()));
		}

		if (buffer.length() > 0) {
			buffer.deleteCharAt(buffer.length() - 1);
		}

		return buffer.toString();
	}

	/**
	 * Convert to http request parameter string. Such as {@literal asd=xxx&qwe=xxx}
	 * @param object Object need to convert.
	 * @return String Http request parameters.
	 * @throws InvocationTargetException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws IllegalAccessException from invoke method.
	 */
	public static String toHttpRequestParams(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<EntityField> entityFields = ClassUtils.getEntityFields(object.getClass());
		return toHttpRequestParams(object, entityFields);
	}

	public static int hashCode(Object... args) {
		int result = 3;

		for (Object arg : args) {
			result = result * 31 + hashCode(arg);
		}

		return result;
	}

	public static int hashCode(Object value) {
		if (value == null) {
			return 0;
		}

		if (value instanceof Byte) {
			return (byte) value;
		}

		if (value instanceof Short) {
			return (short) value;
		}

		if (value instanceof Integer) {
			return (int) value;
		}

		if (value instanceof Long) {
			long _value = (long) value;
			return (int) (_value ^ (_value >>> 32));
		}

		if (value instanceof Float) {
			return Float.floatToIntBits((float) value);
		}

		if (value instanceof Double) {
			long _value = Double.doubleToLongBits((long) value);
			return hashCode(_value);
		}

		if (value instanceof Boolean) {
			return (boolean) value ? 1 : 0;
		}

		if (value instanceof Character) {
			return (int) ((char) value);
		}

		if (value.getClass().isArray()) {
			//TODO
		}

		return value.hashCode();
	}
}