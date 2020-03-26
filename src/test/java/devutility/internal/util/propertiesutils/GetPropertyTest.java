package devutility.internal.util.propertiesutils;

import java.io.IOException;
import java.util.Properties;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertyTest extends BaseTest {
	@Override
	public void run() {
		Properties properties = null;

		try {
			properties = PropertiesUtils.getPropertiesFromResource("system.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		println(PropertiesUtils.getValue(properties, "test"));
		println(PropertiesUtils.getValue(properties, "Test"));
		println(PropertiesUtils.getValue(properties, "database"));
		println(PropertiesUtils.getValue(properties, "ldap.baseDn"));
		println(PropertiesUtils.getValue(properties, "database"));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPropertyTest.class);
	}
}