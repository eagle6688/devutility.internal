package devutility.internal.util.propertiesutils;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertyTest extends BaseTest {
	@Override
	public void run() {
		println(PropertiesUtils.getPropertyFromResource("system.properties", "test"));
		println(PropertiesUtils.getPropertyFromResource("system.properties", "Test"));
		println(PropertiesUtils.getPropertyFromResource("system.properties", "database"));
		println(PropertiesUtils.getPropertyFromResource("system.properties", "ldap.baseDn"));
		println(String.valueOf(PropertiesUtils.containsKeyFromResource("system.properties", "database")));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPropertyTest.class);
	}
}