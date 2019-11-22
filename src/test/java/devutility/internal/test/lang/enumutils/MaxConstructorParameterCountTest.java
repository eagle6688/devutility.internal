package devutility.internal.test.lang.enumutils;

import devutility.internal.lang.EnumUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.constants.Gender;
import devutility.internal.test.enums.MyEnum;

/**
 * 
 * MaxConstructorParameterCountTest
 * 
 * @author: Aldwin Su
 * @version: 2019-11-22 20:18:07
 */
public class MaxConstructorParameterCountTest extends BaseTest {
	@Override
	public void run() {
		println(EnumUtils.maxConstructorParameterCount(Enum.class));
		println(EnumUtils.maxConstructorParameterCount(MyEnum.class));
		println(EnumUtils.maxConstructorParameterCount(Gender.class));
	}

	public static void main(String[] args) {
		TestExecutor.run(MaxConstructorParameterCountTest.class);
	}
}