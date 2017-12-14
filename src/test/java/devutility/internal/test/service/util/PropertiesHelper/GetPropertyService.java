package devutility.internal.test.service.util.PropertiesHelper;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesHelper;

public class GetPropertyService extends BaseTest {
	@Override
	public void run() {
		println(PropertiesHelper.getProperty("system.properties", "test"));
		println(PropertiesHelper.getProperty("system.properties", "Test"));
	}
	
	public static void main(String[] args) {
		TestExecutor.run(GetPropertyService.class);
	}
}