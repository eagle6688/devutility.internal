package devutility.internal.test.util.propertiesutils;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.PropertiesUtils;

/**
 * 
 * ContainsPrefixTest
 * @author: Lenovo 
 * @date:   2018-03-15 17:01:05  
 * @Copyright: 2018 www.lenovo.com Inc. All rights reserved.
 */
public class ContainsPrefixTest extends BaseTest {
	@Override
	public void run() {
		println(String.valueOf(PropertiesUtils.containsPrefix("system.properties", "database")));
		println(String.valueOf(PropertiesUtils.containsPrefix("system.properties", "asd")));
		println(String.valueOf(PropertiesUtils.containsPrefix("system.properties", "test")));
	}

	public static void main(String[] args) {
		TestExecutor.run(ContainsPrefixTest.class);
	}
}