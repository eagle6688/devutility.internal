package devutility.internal.lang.enumutils;

import devutility.internal.enums.MyEnum;
import devutility.internal.lang.EnumUtils;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

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