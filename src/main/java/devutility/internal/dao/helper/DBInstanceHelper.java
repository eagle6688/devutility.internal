package devutility.internal.dao.helper;

import java.util.Properties;

import devutility.internal.dao.DBInstance;
import devutility.internal.util.PropertiesHelper;

public class DBInstanceHelper {
	public static DBInstance getInstance(String resourceName, String prefix) {
		Properties properties = PropertiesHelper.getProperties(resourceName);

		if (properties == null) {
			return null;
		}

		DBInstance instance = new DBInstance();
		setInstance(instance, properties, prefix);
		return instance;
	}

	protected static void setInstance(DBInstance instance, Properties properties, String prefix) {
		instance.setHost(PropertiesHelper.getProperty(properties, getPropertyKey_Host(prefix)));
		instance.setPort(PropertiesHelper.getIntProperty(properties, getPropertyKey_Port(prefix)));
		instance.setLoginName(PropertiesHelper.getProperty(properties, getPropertyKey_Loginname(prefix)));
		instance.setPassword(PropertiesHelper.getProperty(properties, getPropertyKey_Password(prefix)));
		instance.setDatabase(PropertiesHelper.getProperty(properties, getPropertyKey_Database(prefix)));
		instance.setTimeout(PropertiesHelper.getIntProperty(properties, getPropertyKey_Timeout(prefix)));
	}

	public static String getPropertyKey_Host(String prefix) {
		return String.format("%s.host", prefix);
	}

	public static String getPropertyKey_Port(String prefix) {
		return String.format("%s.port", prefix);
	}

	public static String getPropertyKey_Loginname(String prefix) {
		return String.format("%s.loginname", prefix);
	}

	public static String getPropertyKey_Password(String prefix) {
		return String.format("%s.password", prefix);
	}

	public static String getPropertyKey_Database(String prefix) {
		return String.format("%s.database", prefix);
	}

	public static String getPropertyKey_Timeout(String prefix) {
		return String.format("%s.timeout", prefix);
	}
}