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
	 * Set DbInstance.
	 * @param instance: DbInstance object.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of properties key.
	 */
	protected static void setInstance(DbInstance instance, Properties properties, String prefix) {
		instance.setUrl(PropertiesUtils.getProperty(properties, getPropertyKeyUrl(prefix)));
		instance.setHost(PropertiesUtils.getProperty(properties, getPropertyKeyHost(prefix)));
		instance.setPort(PropertiesUtils.getIntProperty(properties, getPropertyKeyPort(prefix)));
		instance.setLoginName(PropertiesUtils.getProperty(properties, getPropertyKeyLoginname(prefix)));
		instance.setPassword(PropertiesUtils.getProperty(properties, getPropertyKeyPassword(prefix)));
		instance.setDatabase(PropertiesUtils.getProperty(properties, getPropertyKeyDatabase(prefix)));
		instance.setTimeout(PropertiesUtils.getIntProperty(properties, getPropertyKeyTimeout(prefix)));
	}

	public static String getPropertyKeyUrl(String prefix) {
		return String.format("%s.url", prefix);
	}

	public static String getPropertyKeyHost(String prefix) {
		return String.format("%s.host", prefix);
	}

	public static String getPropertyKeyPort(String prefix) {
		return String.format("%s.port", prefix);
	}

	public static String getPropertyKeyLoginname(String prefix) {
		return String.format("%s.loginname", prefix);
	}

	public static String getPropertyKeyPassword(String prefix) {
		return String.format("%s.password", prefix);
	}

	public static String getPropertyKeyDatabase(String prefix) {
		return String.format("%s.database", prefix);
	}

	public static String getPropertyKeyTimeout(String prefix) {
		return String.format("%s.timeout", prefix);
	}
}