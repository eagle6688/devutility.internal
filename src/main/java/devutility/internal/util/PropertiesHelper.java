package devutility.internal.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
	// region get properties

	public static Properties getProperties(String resourceName) {
		return getProperties(PropertiesHelper.class.getClassLoader().getResourceAsStream(resourceName));
	}

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

	// endregion

	// region get property

	public static String getProperty(Properties properties, String key) {
		if (properties == null) {
			return null;
		}

		return properties.getProperty(key);
	}

	public static String getProperty(String resourceName, String key) {
		Properties properties = getProperties(resourceName);
		return getProperty(properties, key);
	}

	// endregion

	// region get int property

	public static int getIntProperty(Properties properties, String key) {
		String value = getProperty(properties, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	public static int getIntProperty(String resourceName, String key) {
		String value = getProperty(resourceName, key);

		if (value == null) {
			return 0;
		}

		return Integer.parseInt(value);
	}

	// endregion
}