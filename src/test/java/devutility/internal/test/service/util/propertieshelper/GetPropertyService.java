package devutility.internal.test.service.util.propertieshelper;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesHelper;

public class GetPropertyService extends BaseTest {
	@Override
	public void run() {
		println(PropertiesHelper.getProperty("system.properties", "test"));
		println(PropertiesHelper.getProperty("system.properties", "Test"));
		println(PropertiesHelper.getProperty("system.properties", "database"));
		println(String.valueOf(PropertiesHelper.containsKey("system.properties", "database")));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetPropertyService.class);
	}
}