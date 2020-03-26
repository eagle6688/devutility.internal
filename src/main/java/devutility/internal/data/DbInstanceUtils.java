package devutility.internal.data;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import devutility.internal.lang.StringUtils;
import devutility.internal.model.DbInstance;
import devutility.internal.util.PropertiesUtils;

public class DbInstanceUtils {
	/**
	 * Get a DbInstance object by properties and key prefix.
	 * @param properties Properties object.
	 * @param prefix Prefix of properties key.
	 * @return DbInstance
	 */
	public static DbInstance getInstance(Properties properties, String prefix) {
		if (properties == null || !PropertiesUtils.containsPrefixKey(properties, prefix)) {
			return null;
		}

		DbInstance instance = null;

		try {
			instance = PropertiesUtils.toModel(properties, prefix, DbInstance.class);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * Get a DbInstance object by inputStream and key prefix.
	 * @param inputStream Properties inputStream.
	 * @param prefix Prefix of properties key.
	 * @return DbInstance
	 * @throws IOException from getProperties method.
	 */
	public static DbInstance getInstance(InputStream inputStream, String prefix) throws IOException {
		if (inputStream == null) {
			return null;
		}

		Properties properties = PropertiesUtils.getProperties(inputStream);
		return getInstance(properties, prefix);
	}

	/**
	 * Get a DbInstance object by properties file and key prefix.
	 * @param propertiesFile Properties file name.
	 * @param prefix Prefix of properties key.
	 * @return DbInstance
	 * @throws IOException from getPropertiesFromResource method.
	 */
	public static DbInstance getInstance(String propertiesFile, String prefix) throws IOException {
		if (StringUtils.isNullOrEmpty(propertiesFile)) {
			return null;
		}

		Properties properties = PropertiesUtils.getPropertiesFromResource(propertiesFile);

		if (properties == null || !PropertiesUtils.containsPrefixKey(properties, prefix)) {
			return null;
		}

		return getInstance(properties, prefix);
	}
}