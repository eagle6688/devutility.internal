package devutility.internal.dao;

import java.util.Properties;

import devutility.internal.dao.models.DbInstance;
import devutility.internal.util.PropertiesUtils;

public class DbInstanceHelper {
	// region get instance

	public static DbInstance getInstance(String resourceName, String prefix) {
		Properties properties = PropertiesUtils.getProperties(resourceName);

		if (properties == null || !PropertiesUtils.containsPrefix(properties, prefix)) {
			return null;
		}

		DbInstance instance = new DbInstance();
		setInstance(instance, properties, prefix);
		return instance;
	}

	// endregion

	// region set instance

	protected static void setInstance(DbInstance instance, Properties properties, String prefix) {
		instance.setHost(PropertiesUtils.getProperty(properties, getPropertyKeyHost(prefix)));
		instance.setPort(PropertiesUtils.getIntProperty(properties, getPropertyKeyPort(prefix)));
		instance.setLoginName(PropertiesUtils.getProperty(properties, getPropertyKeyLoginname(prefix)));
		instance.setPassword(PropertiesUtils.getProperty(properties, getPropertyKeyPassword(prefix)));
		instance.setDatabase(PropertiesUtils.getProperty(properties, getPropertyKeyDatabase(prefix)));
		instance.setTimeout(PropertiesUtils.getIntProperty(properties, getPropertyKeyTimeout(prefix)));
	}

	// endregion

	// region get property

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

	// endregion
}