package devutility.internal.lang;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import devutility.internal.model.EntityField;

/**
 * 
 * ObjectUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-20 17:50:11
 */
public class ObjectUtils {
	/**
	 * Convert to http request parameter string. Such as {@literal asd=xxx&qwe=xxx}
	 * @param object Object need to convert.
	 * @return String Http request parameters.
	 * @throws InvocationTargetException from invoke method.
	 * @throws IllegalArgumentException from invoke method.
	 * @throws IllegalAccessException from invoke method.
	 */
	public static String toHttpRequestParams(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer buffer = new StringBuffer();
		List<EntityField> entityFields = ClassUtils.getEntityFields(object.getClass());

		for (EntityField entityField : entityFields) {
			Object value = entityField.getValue(object);

			if (value != null) {
				buffer.append(String.format("%s=%s&", entityField.getField().getName(), value.toString()));
			}
		}

		if (buffer.length() > 0) {
			buffer = buffer.deleteCharAt(buffer.length() - 1);
		}

		return buffer.toString();
	}
}