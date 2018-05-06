package devutility.internal.test.service.util.propertieshelper;

import java.util.Properties;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertiesService extends BaseTest {
	@Override
	public void run() {
		Properties properties = PropertiesUtils.getProperties("system.properties");
		println(properties.getProperty("test"));
	}

	public static void main(String[] args) {
		TestExecutor.run(new GetPropertiesService());
	}
}