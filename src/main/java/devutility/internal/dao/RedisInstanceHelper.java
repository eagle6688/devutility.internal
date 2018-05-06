package devutility.internal.dao;

import java.util.Properties;

import devutility.internal.dao.models.RedisInstance;
import devutility.internal.util.PropertiesUtils;

public final class RedisInstanceHelper extends DbInstanceHelper {
	// region get instance

	public static RedisInstance getInstance(String resourceName, String prefix) {
		Properties properties = PropertiesUtils.getProperties(resourceName);

		if (properties == null) {
			return null;
		}

		RedisInstance instance = new RedisInstance();
		setInstance(instance, properties, prefix);
		instance.setDBIndex(PropertiesUtils.getIntProperty(properties, getPropertyKeyDBIndex(prefix)));
		return instance;
	}

	// endregion

	// region get property key DBIndex

	public static String getPropertyKeyDBIndex(String prefix) {
		return String.format("%s.dbindex", prefix);
	}

	// endregion
}