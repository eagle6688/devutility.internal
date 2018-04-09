package devutility.internal.util;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import devutility.internal.data.BeanHelper;
import devutility.internal.lang.ClassHelper;
import devutility.internal.lang.StringHelper;
import devutility.internal.lang.models.EntityField;

public class PropertiesHelper {
	/**
	 * getProperties
	 * @return Properties
	 */
	public static Properties getProperties(String resourceName) {
		return getProperties(PropertiesHelper.class.getClassLoader().getResourceAsStream(resourceName));
	}

	/**
	 * getProperties
	 * @return Properties
	 */
	public static Properties getProperties(InputStream inputStream) {
		try (InputStream inStream = inputStream) {
			Properties properties = new Properties();
			properties.load(inStream);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * containsPrefix
	 * @return boolean
	 */
	public static boolean containsPrefix(Properties properties, String prefix) {
		List<Object> keys = Collections.list(properties.keys());

		for (Object key : keys) {
			if (key.toString().indexOf(prefix) == 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * containsPrefix
	 * @return boolean
	 */
	public static boolean containsPrefix(String resourceName, String prefix) {
		Properties properties = getProperties(resourceName);
		return containsPrefix(properties, prefix);
	}

	/**
	 * contains
	 * @return boolean
	 */
	public static boolean containsKey(Properties properties, String key) {
		return properties.containsKey(key);
	}

	/**
	 * contains
	 * @return boolean
	 */
	public static boolean containsKey(String resourceName, String key) {
		Properties properties = getProperties(resourceName);
		return containsKey(properties, key);
	}

	/**
	 * getProperty
	 * @return String
	 */
	public static String getProperty(Properties properties, String key) {
		if (properties == null) {
			return null;
		}

		return properties.getProperty(key);
	}

	/**
	 * getProperty
	 * @return String
	 */
	public static String getProperty(String resourceName, String key) {
		Properties properties = getProperties(resourceName);
		return getProperty(properties, key);
	}

	/**
	 * getIntProperty
	 * @return int
	 */
	public static int getIntProperty(Properties properties, String key) {
		String value = getProperty(properties, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	/**
	 * getIntProperty
	 * @return int
	 */
	public static int getIntProperty(String resourceName, String key) {
		String value = getProperty(resourceName, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	/**
	 * toModel
	 * @param resourceName
	 * @param prefix
	 * @param clazz
	 * @return model
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toModel(String resourceName, String prefix, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Properties properties = getProperties(resourceName);
		return toModel(properties, prefix, clazz);
	}

	/**
	 * Properties to model
	 * @param properties
	 * @param prefix
	 * @param clazz
	 * @return model
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toModel(Properties properties, String prefix, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (properties == null) {
			return null;
		}

		boolean hasProperty = false;
		T model = ClassHelper.newInstance(clazz);
		List<EntityField> entityFields = ClassHelper.getEntityFields(clazz);

		for (EntityField entityField : entityFields) {
			String propertyKey = getPropertyKey(prefix, entityField.getField().getName());
			String propertyValue = PropertiesHelper.getProperty(properties, propertyKey);

			if (!StringHelper.isNullOrEmpty(propertyValue)) {
				BeanHelper.setField(entityField.getSetter(), model, propertyValue, entityField.getField().getType());
				hasProperty = true;
			}
		}

		if (!hasProperty) {
			return null;
		}

		return model;
	}

	/**
	 * getPropertyKey
	 * @param prefix
	 * @param field
	 * @return String
	 */
	private static String getPropertyKey(String prefix, String field) {
		if (StringHelper.isNullOrEmpty(prefix)) {
			return field;
		}

		return String.format("%s.%s", prefix, field);
	}
}