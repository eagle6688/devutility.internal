package devutility.internal.test.util.propertiesutils;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertyTest extends BaseTest {
	@Override
	public void run() {
		println(PropertiesUtils.getProperty("system.properties", "test"));
		println(PropertiesUtils.getProperty("system.properties", "Test"));
		println(PropertiesUtils.getProperty("system.properties", "database"));
		println(PropertiesUtils.getProperty("system.properties", "ldap.baseDn"));
		println(String.valueOf(PropertiesUtils.containsKey("system.properties", "database")));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPropertyTest.class);
	}
}