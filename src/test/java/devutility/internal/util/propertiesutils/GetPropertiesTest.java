package devutility.internal.util.propertiesutils;

import java.io.IOException;
import java.util.Properties;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

public class GetPropertiesTest extends BaseTest {
	@Override
	public void run() {
		Properties properties = null;

		try {
			properties = PropertiesUtils.getPropertiesFromResource("system.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		println(properties.getProperty("test"));
	}

	public static void main(String[] args) {
		TestExecutor.run(new GetPropertiesTest());
	}
}