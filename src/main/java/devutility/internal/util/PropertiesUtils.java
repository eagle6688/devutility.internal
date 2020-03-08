package devutility.internal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import devutility.internal.annotation.PropertiesKey;
import devutility.internal.data.BeanUtils;
import devutility.internal.lang.ClassUtils;
import devutility.internal.lang.StringUtils;
import devutility.internal.lang.models.EntityField;

/**
 * 
 * PropertiesUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-07 11:24:30
 */
public class PropertiesUtils {
	/**
	 * Get Properties object from InputStream object of properties file.
	 * @param inputStream InputStream object of properties file.
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
	 * Get Properties object from provided file path.
	 * @param file File path.
	 * @return Properties
	 * @throws FileNotFoundException from FileInputStream constructor.
	 */
	public static Properties getProperties(String file) throws FileNotFoundException {
		return getProperties(new FileInputStream(file));
	}

	/**
	 * Get Properties object from properties file.
	 * @param file Properties file in resources folder.
	 * @return Properties
	 */
	public static Properties getPropertiesFromResource(String file) {
		InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(file);
		return getProperties(inputStream);
	}

	/**
	 * Check whether provided properties file contains key or not.
	 * @param file Properties file in resources folder.
	 * @param key Properties key.
	 * @return boolean
	 */
	public static boolean containsKeyFromResource(String file, String key) {
		Properties properties = getPropertiesFromResource(file);
		return containsKey(properties, key);
	}

	/**
	 * Get property value.
	 * @param properties Properties object.
	 * @param key Properties key.
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
	 * @param file Properties file in resources folder.
	 * @param key Properties key.
	 * @return String
	 */
	public static String getPropertyFromResource(String file, String key) {
		Properties properties = getPropertiesFromResource(file);
		return getProperty(properties, key);
	}

	/**
	 * Get int value from Properties object.
	 * @param properties Properties object.
	 * @param key Properties key.
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
	 * Get int value from properties file.
	 * @param file Properties file in resources folder.
	 * @param key Properties key.
	 * @return int
	 */
	public static int getIntPropertyFromResource(String file, String key) {
		String value = getPropertyFromResource(file, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	/**
	 * Get property key.
	 * @param field Field object.
	 * @return String
	 */
	public static String getPropertyKey(Field field) {
		PropertiesKey propertiesKey = field.getAnnotation(PropertiesKey.class);

		if (propertiesKey == null) {
			return field.getName();
		}

		return propertiesKey.value();
	}

	/**
	 * Get property key.
	 * @param prefix: Prefix of property key.
	 * @param fieldName: Field name.
	 * @return String
	 */
	public static String getPropertyKey(String prefix, String fieldName) {
		if (StringUtils.isNullOrEmpty(prefix)) {
			return fieldName;
		}

		return String.format("%s.%s", prefix, fieldName);
	}

	/**
	 * Check whether provided Properties object contains the provided prefix or not.
	 * @param properties Properties object.
	 * @param prefix Prefix of property key.
	 * @return boolean
	 */
	public static boolean containsPrefixKey(Properties properties, String prefix) {
		List<Object> keys = Collections.list(properties.keys());

		for (Object key : keys) {
			if (key.toString().indexOf(prefix) == 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Check whether provided properties file contains prefix or not.
	 * @param file Properties file in resources folder.
	 * @param prefix Prefix of property key.
	 * @return boolean
	 */
	public static boolean containsPrefixKeyFromResource(String file, String prefix) {
		Properties properties = getPropertiesFromResource(file);
		return containsPrefixKey(properties, prefix);
	}

	/**
	 * Check whether provided Properties object contains key or not.
	 * @param properties Properties object.
	 * @param key Properties key.
	 * @return boolean
	 */
	public static boolean containsKey(Properties properties, String key) {
		return properties.containsKey(key);
	}

	/**
	 * Convert Properties object to Map.
	 * @param properties Properties object.
	 * @return {@code Map<String,String>}
	 */
	public static Map<String, String> toMap(Properties properties) {
		Map<String, String> map = new LinkedHashMap<>();

		if (properties == null) {
			return map;
		}

		for (String name : properties.stringPropertyNames()) {
			map.put(name, properties.getProperty(name));
		}

		return map;
	}

	/**
	 * Convert properties file to Map.
	 * @param file Properties file in resources folder.
	 * @return {@code Map<String,String>}
	 */
	public static Map<String, String> toMapFromResource(String file) {
		Properties properties = getPropertiesFromResource(file);
		return toMap(properties);
	}

	/**
	 * Convert Properties object to model.
	 * @param properties Properties object.
	 * @param clazz Class object.
	 * @return {@code T}
	 * @throws NumberFormatException from BeanUtils.setField method.
	 * @throws IllegalAccessException from BeanUtils.setField method.
	 * @throws IllegalArgumentException from BeanUtils.setField method.
	 * @throws InvocationTargetException from BeanUtils.setField method.
	 */
	public static <T> T toModel(Properties properties, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean hasProperty = false;
		T model = ClassUtils.instance(clazz);
		List<EntityField> entityFields = ClassUtils.getEntityFields(clazz);

		for (EntityField entityField : entityFields) {
			String value = getPropertyValue(properties, entityField.getField());

			if (value != null) {
				hasProperty = true;
				BeanUtils.setField(entityField.getSetter(), model, value, entityField.getField());
			}
		}

		if (!hasProperty) {
			return null;
		}

		return model;
	}

	/**
	 * Convert Properties to model.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of property key.
	 * @param clazz: Model Class object.
	 * @return {@code T}
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toModel(Properties properties, String prefix, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T model = ClassUtils.instance(clazz);

		boolean hasProperty = false;
		List<EntityField> entityFields = ClassUtils.getEntityFields(clazz);

		for (EntityField entityField : entityFields) {
			String value = getPropertyValue(properties, prefix, entityField.getField());

			if (value != null) {
				BeanUtils.setField(entityField.getSetter(), model, value, entityField.getField());
				hasProperty = true;
			}
		}

		if (!hasProperty) {
			return null;
		}

		return model;
	}

	/**
	 * Convert Properties to model.
	 * @param file Properties file.
	 * @param prefix Prefix of property key.
	 * @param clazz Model Class object.
	 * @return {@code T}
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toModel(String file, String prefix, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Properties properties = getPropertiesFromResource(file);
		return toModel(properties, prefix, clazz);
	}

	/**
	 * Convert Properties to model.
	 * @param propertiesFile: Properties file.
	 * @param clazz: Model Class object.
	 * @return {@code T}
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T toModel(String propertiesFile, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Properties properties = getPropertiesFromResource(propertiesFile);
		return toModel(properties, clazz);
	}

	/**
	 * Get property key.
	 * @param prefix: Prefix of property key.
	 * @param field: Field object in model.
	 * @return String
	 */
	public static String getPropertyKey(String prefix, Field field) {
		String propertyKey = getPropertyKey(field);

		if (StringUtils.isNotEmpty(propertyKey)) {
			return propertyKey;
		}

		return getPropertyKey(prefix, field.getName());
	}

	/**
	 * Get property value.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of property key.
	 * @param field: Field object in model.
	 * @return String
	 */
	public static String getPropertyValue(Properties properties, String prefix, Field field) {
		String propertyKey = getPropertyKey(prefix, field);

		if (StringUtils.isNullOrEmpty(propertyKey)) {
			return null;
		}

		return PropertiesUtils.getProperty(properties, propertyKey);
	}

	/**
	 * Get property value.
	 * @param properties: Properties object.
	 * @param field: Field object in model.
	 * @return String
	 */
	public static String getPropertyValue(Properties properties, Field field) {
		String propertyKey = getPropertyKey(field);

		if (StringUtils.isNullOrEmpty(propertyKey)) {
			propertyKey = field.getName();
		}

		return PropertiesUtils.getProperty(properties, propertyKey);
	}
}