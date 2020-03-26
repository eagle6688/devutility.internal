package devutility.internal.util;

import java.io.FileInputStream;
import java.io.IOException;
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
import devutility.internal.model.EntityField;

/**
 * 
 * PropertiesUtils
 * 
 * @author: Aldwin Su
 * @version: 2019-12-07 11:24:30
 */
public class PropertiesUtils {
	/**
	 * Get Properties object from provided InputStream object. Remember close InputStream object by yourself.
	 * @param inputStream InputStream object of properties file.
	 * @return Properties
	 * @throws IOException from load method.
	 */
	public static Properties getProperties(InputStream inputStream) throws IOException {
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	/**
	 * Get Properties object from provided file path.
	 * @param file File path.
	 * @return Properties
	 * @throws IOException from getProperties method.
	 */
	public static Properties getProperties(String file) throws IOException {
		return getProperties(new FileInputStream(file));
	}

	/**
	 * Get Properties object from properties file located in resources folder.
	 * @param file Properties file located in resources folder.
	 * @return Properties
	 * @throws IOException from getProperties method.
	 */
	public static Properties getPropertiesFromResource(String file) throws IOException {
		InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(file);
		return getProperties(inputStream);
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
	 * Get property key.
	 * @param prefix Prefix of property key.
	 * @param fieldName Field name in object.
	 * @return String
	 */
	public static String getKey(String prefix, String fieldName) {
		if (StringUtils.isNullOrEmpty(prefix)) {
			return fieldName;
		}

		return String.format("%s.%s", prefix, fieldName);
	}

	/**
	 * Get property key.
	 * @param prefix Prefix of property key.
	 * @param field Field object.
	 * @return String
	 */
	public static String getKey(String prefix, Field field) {
		PropertiesKey propertiesKey = field.getAnnotation(PropertiesKey.class);

		if (propertiesKey != null) {
			return propertiesKey.value();
		}

		return getKey(prefix, field.getName());
	}

	/**
	 * Get property key.
	 * @param field Field object.
	 * @return String
	 */
	public static String getKey(Field field) {
		return getKey(null, field);
	}

	/**
	 * Get property value.
	 * @param properties Properties object.
	 * @param key Properties key.
	 * @return String
	 */
	public static String getValue(Properties properties, String key) {
		if (properties == null || StringUtils.isNullOrEmpty(key)) {
			return null;
		}

		return properties.getProperty(key);
	}

	/**
	 * Get property value.
	 * @param properties Properties object.
	 * @param prefix Prefix of property key.
	 * @param field Field object in model.
	 * @return String
	 */
	public static String getValue(Properties properties, String prefix, Field field) {
		String key = getKey(prefix, field);

		if (StringUtils.isNullOrEmpty(key)) {
			return null;
		}

		return getValue(properties, key);
	}

	/**
	 * Get property value.
	 * @param properties Properties object.
	 * @param field Field object in model.
	 * @return String
	 */
	public static String getValue(Properties properties, Field field) {
		return getValue(properties, null, field);
	}

	/**
	 * Get value for the provided key from properties file located in resources folder.
	 * @param file Properties file located in resources folder.
	 * @param key Properties key.
	 * @return String
	 * @throws IOException
	 */
	public static String getValueFromResource(String file, String key) throws IOException {
		Properties properties = getPropertiesFromResource(file);
		return getValue(properties, key);
	}

	/**
	 * Get int value from Properties object.
	 * @param properties Properties object.
	 * @param key Properties key.
	 * @return int
	 */
	public static int getIntProperty(Properties properties, String key) {
		String value = getValue(properties, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	/**
	 * Convert Properties object to Map<String, String> object.
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
			String value = getValue(properties, entityField.getField());

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
			String value = getValue(properties, prefix, entityField.getField());

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
	 * @throws IOException
	 */
	public static <T> T toModel(String file, String prefix, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
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
	 * @throws IOException
	 */
	public static <T> T toModel(String propertiesFile, Class<T> clazz) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Properties properties = getPropertiesFromResource(propertiesFile);
		return toModel(properties, clazz);
	}
}