package devutility.internal.util;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

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
}