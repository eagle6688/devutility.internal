package devutility.internal.util.propertiesutils;

import java.io.IOException;
import java.util.Properties;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

/**
 * 
 * ContainsPrefixTest
 * @author: Lenovo
 * @date: 2018-03-15 17:01:05
 * @Copyright: 2018 www.lenovo.com Inc. All rights reserved.
 */
public class ContainsPrefixTest extends BaseTest {
	@Override
	public void run() {
		Properties properties = null;

		try {
			properties = PropertiesUtils.getPropertiesFromResource("system.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		println(String.valueOf(PropertiesUtils.containsPrefixKey(properties, "database")));
		println(String.valueOf(PropertiesUtils.containsPrefixKey(properties, "asd")));
		println(String.valueOf(PropertiesUtils.containsPrefixKey(properties, "test")));
	}

	public static void main(String[] args) {
		TestExecutor.run(ContainsPrefixTest.class);
	}
}