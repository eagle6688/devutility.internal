package devutility.internal.dao.helper;

import java.util.Properties;

import devutility.internal.dao.RedisInstance;
import devutility.internal.util.PropertiesHelper;

public final class RedisInstanceHelper extends DBInstanceHelper {
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

	public static String getPropertyKey_DBIndex(String prefix) {
		return String.format("%s.dbindex", prefix);
	}
}