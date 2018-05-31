package devutility.internal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import devutility.internal.data.BeanUtils;
import devutility.internal.io.ResourcesUtils;
import devutility.internal.lang.ClassHelper;
import devutility.internal.lang.StringHelper;
import devutility.internal.lang.models.EntityField;

public class PropertiesUtils {
	/**
	 * Get properties.
	 * @param resourceName: Properties file name.
	 * @return Properties
	 */
	public static Properties getProperties(String propertiesFile) {
		InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesFile);
		return getProperties(inputStream);
	}

	/**
	 * Find out the properties file by default order and load it.
	 * @param propertiesFile: Properties file name.
	 * @return Properties
	 * @throws URISyntaxException
	 * @throws FileNotFoundException
	 */
	public static Properties getPropertiesByDefaultOrder(String propertiesFile) throws URISyntaxException, FileNotFoundException {
		String path = ResourcesUtils.getPathByDefaultOrder(propertiesFile);

		if (path == null) {
			return null;
		}

		InputStream inputStream = new FileInputStream(path);
		return getProperties(inputStream);
	}

	/**
	 * Get properties
	 * @param inputStream: InputStream of properties file
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
	 * Check one properties object whether contains prefix.
	 * @param properties: Properties object
	 * @param prefix: Prefix of property key
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
	 * Check one properties file whether contains prefix.
	 * @param resourceName: Properties file
	 * @param prefix: Prefix of property key
	 * @return boolean
	 */
	public static boolean containsPrefix(String resourceName, String prefix) {
		Properties properties = getProperties(resourceName);
		return containsPrefix(properties, prefix);
	}

	/**
	 * Check one properties object whether contains key.
	 * @param properties: Properties object
	 * @param key: Key name for you query
	 * @return boolean
	 */
	public static boolean containsKey(Properties properties, String key) {
		return properties.containsKey(key);
	}

	/**
	 * Check one properties file whether contains key.
	 * @param resourceName: Properties file
	 * @param key: Key name for you query
	 * @return boolean
	 */
	public static boolean containsKey(String resourceName, String key) {
		Properties properties = getProperties(resourceName);
		return containsKey(properties, key);
	}

	/**
	 * Get property value.
	 * @param properties: Properties object
	 * @param key: Key name for you query
	 * @return String
	 */
	public static String getProperty(Properties properties, String key) {
		if (properties == null) {
			return null;
		}

		return properties.getProperty(key);
	}

	/**
	 * Get property value.
	 * @param resourceName: Properties file
	 * @param key: Key name for you query
	 * @return String
	 */
	public static String getProperty(String resourceName, String key) {
		Properties properties = getProperties(resourceName);
		return getProperty(properties, key);
	}

	/**
	 * Get property int value.
	 * @param properties: Properties object
	 * @param key: Key name for you query
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
	 * Get property int value.
	 * @param resourceName: Properties file
	 * @param key: Key name for you query
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
	 * Convert properties to Map
	 * @param resourceName: Properties file
	 * @return {@code Map<String,String>}
	 */
	public static Map<String, String> toMap(String resourceName) {
		Properties properties = getProperties(resourceName);
		return toMap(properties);
	}

	/**
	 * Convert properties to Map
	 * @param properties: Properties object
	 * @return {@code Map<String,String>}
	 */
	public static Map<String, String> toMap(Properties properties) {
		Map<String, String> map = new HashMap<>();

		if (properties == null) {
			return map;
		}

		for (String name : properties.stringPropertyNames()) {
			map.put(name, properties.getProperty(name));
		}

		return map;
	}

	/**
	 * Properties to model
	 * @param resourceName: Properties file
	 * @param prefix: Prefix of property key
	 * @param clazz: Class of model
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
	 * @param properties: Properties object
	 * @param prefix: Prefix of property key
	 * @param clazz: Class of model
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
		T model = ClassHelper.instance(clazz);
		List<EntityField> entityFields = ClassHelper.getEntityFields(clazz);

		for (EntityField entityField : entityFields) {
			String propertyKey = getPropertyKey(prefix, entityField.getField().getName());
			String propertyValue = PropertiesUtils.getProperty(properties, propertyKey);

			if (!StringHelper.isNullOrEmpty(propertyValue)) {
				BeanUtils.setField(entityField.getSetter(), model, propertyValue, entityField.getField());
				hasProperty = true;
			}
		}

		if (!hasProperty) {
			return null;
		}

		return model;
	}

	/**
	 * Get property key
	 * @param prefix: Prefix of property key
	 * @param field: field of model
	 * @return String
	 */
	private static String getPropertyKey(String prefix, String field) {
		if (StringHelper.isNullOrEmpty(prefix)) {
			return field;
		}

		return String.format("%s.%s", prefix, field);
	}
}