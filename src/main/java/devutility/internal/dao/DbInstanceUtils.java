package devutility.internal.dao;

import java.io.InputStream;
import java.util.Properties;

import devutility.internal.dao.models.DbInstance;
import devutility.internal.lang.StringHelper;
import devutility.internal.util.PropertiesUtils;

public class DbInstanceUtils {
	/**
	 * Get a DbInstance object by properties and key prefix.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of properties key.
	 * @return DbInstance
	 */
	public static DbInstance getInstance(Properties properties, String prefix) {
		if (properties == null || !PropertiesUtils.containsPrefix(properties, prefix)) {
			return null;
		}

		DbInstance instance = new DbInstance();
		setInstance(instance, properties, prefix);
		return instance;
	}

	/**
	 * Get a DbInstance object by inputStream and key prefix.
	 * @param inputStream: Properties inputStream.
	 * @param prefix: Prefix of properties key.
	 * @return DbInstance
	 */
	public static DbInstance getInstance(InputStream inputStream, String prefix) {
		if (inputStream == null) {
			return null;
		}

		Properties properties = PropertiesUtils.getProperties(inputStream);
		return getInstance(properties, prefix);
	}

	/**
	 * Get a DbInstance object by properties file and key prefix.
	 * @param propertiesFile: Properties file name.
	 * @param prefix: Prefix of properties key.
	 * @return DbInstance
	 */
	public static DbInstance getInstance(String propertiesFile, String prefix) {
		if (StringHelper.isNullOrEmpty(propertiesFile)) {
			return null;
		}

		Properties properties = PropertiesUtils.getProperties(propertiesFile);

		if (properties == null || !PropertiesUtils.containsPrefix(properties, prefix)) {
			return null;
		}

		return getInstance(properties, prefix);
	}

	/**
	 * Get property key.
	 * @param prefix: Prefix of key.
	 * @param name: Key name.
	 * @return String
	 */
	public static String getPropertyKey(String prefix, String name) {
		return String.format("%s.%s", prefix, name);
	}

	/**
	 * Set DbInstance.
	 * @param instance: DbInstance object.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of properties key.
	 */
	protected static void setInstance(DbInstance instance, Properties properties, String prefix) {
		instance.setUri(PropertiesUtils.getProperty(properties, getPropertyKey(prefix, "uri")));
		instance.setHost(PropertiesUtils.getProperty(properties, getPropertyKey(prefix, "host")));
		instance.setPort(PropertiesUtils.getIntProperty(properties, getPropertyKey(prefix, "port")));
		instance.setLoginName(PropertiesUtils.getProperty(properties, getPropertyKey(prefix, "loginname")));
		instance.setPassword(PropertiesUtils.getProperty(properties, getPropertyKey(prefix, "password")));
		instance.setDatabase(PropertiesUtils.getProperty(properties, getPropertyKey(prefix, "database")));
		instance.setTimeout(PropertiesUtils.getIntProperty(properties, getPropertyKey(prefix, "timeout")));
	}
}