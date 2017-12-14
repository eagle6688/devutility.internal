package devutility.internal.dao;

import java.util.Properties;

import devutility.internal.dao.models.RedisInstance;
import devutility.internal.util.PropertiesHelper;

public final class RedisInstanceHelper extends DBInstanceHelper {
	// region get instance

	public static RedisInstance getInstance(String resourceName, String prefix) {
		Properties properties = PropertiesHelper.getProperties(resourceName);

		if (properties == null) {
			return null;
		}

		RedisInstance instance = new RedisInstance();
		setInstance(instance, properties, prefix);
		instance.setDBIndex(PropertiesHelper.getIntProperty(properties, getPropertyKey_DBIndex(prefix)));
		return instance;
	}

	// endregion

	// region get property key DBIndex

	public static String getPropertyKey_DBIndex(String prefix) {
		return String.format("%s.dbindex", prefix);
	}

	// endregion
}