package devutility.internal.dao;

import java.util.Properties;

import devutility.internal.dao.models.RedisInstance;
import devutility.internal.util.PropertiesUtils;

public final class RedisInstanceUtils extends DbInstanceUtils {
	/**
	 * Create an RedisInstance instance with configuration in properties file.
	 * @param propertiesFile: Properties file name.
	 * @param prefix: Prefix of item configuration in properties file.
	 * @return RedisInstance
	 */
	public static RedisInstance getInstance(String propertiesFile, String prefix) {
		Properties properties = PropertiesUtils.getProperties(propertiesFile);

		if (properties == null) {
			return null;
		}

		return getInstance(properties, prefix);
	}

	/**
	 * Create an RedisInstance instance with configuration in properties object.
	 * @param properties: Properties object.
	 * @param prefix: Prefix of item configuration in properties file.
	 * @return RedisInstance
	 */
	public static RedisInstance getInstance(Properties properties, String prefix) {
		RedisInstance instance = new RedisInstance();
		setInstance(instance, properties, prefix);

		int dbIndex = PropertiesUtils.getIntProperty(properties, getPropertyKeyDBIndex(prefix));
		instance.setDBIndex(dbIndex);
		return instance;
	}

	/**
	 * Get property key of dbindex.
	 * @param prefix: Prefix of item configuration in properties file.
	 * @return String
	 */
	public static String getPropertyKeyDBIndex(String prefix) {
		return String.format("%s.dbindex", prefix);
	}
}