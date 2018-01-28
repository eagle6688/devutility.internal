package devutility.internal.dao;

import java.util.Properties;

import devutility.internal.dao.models.DBInstance;
import devutility.internal.util.PropertiesHelper;

/**
 * @Description: DBInstanceHelper
 * @author: Aldwin
 */
public class DbInstanceHelper {
	// region get instance

	public static DBInstance getInstance(String resourceName, String prefix) {
		Properties properties = PropertiesHelper.getProperties(resourceName);

		if (properties == null) {
			return null;
		}

		DBInstance instance = new DBInstance();
		setInstance(instance, properties, prefix);
		return instance;
	}

	// endregion

	// region set instance

	protected static void setInstance(DBInstance instance, Properties properties, String prefix) {
		instance.setHost(PropertiesHelper.getProperty(properties, getPropertyKeyHost(prefix)));
		instance.setPort(PropertiesHelper.getIntProperty(properties, getPropertyKeyPort(prefix)));
		instance.setLoginName(PropertiesHelper.getProperty(properties, getPropertyKeyLoginname(prefix)));
		instance.setPassword(PropertiesHelper.getProperty(properties, getPropertyKeyPassword(prefix)));
		instance.setDatabase(PropertiesHelper.getProperty(properties, getPropertyKeyDatabase(prefix)));
		instance.setTimeout(PropertiesHelper.getIntProperty(properties, getPropertyKeyTimeout(prefix)));
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