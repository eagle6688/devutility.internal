package devutility.internal.test.util.propertiesutils;

import java.util.Properties;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertiesTest extends BaseTest {
	@Override
	public void run() {
		Properties properties = PropertiesUtils.getProperties("system.properties");
		println(properties.getProperty("test"));
	}

	public static void main(String[] args) {
		TestExecutor.run(new GetPropertiesTest());
	}
}