package devutility.internal.test.service.base.system;

import devutility.internal.base.SystemUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EnvVariableValueTest extends BaseTest {
	@Override
	public void run() {
		println(SystemUtils.envVariableValue("${test123:Hello world!}"));
		println(SystemUtils.envVariableValue("${test123}"));
		println(SystemUtils.envVariableValue("test123"));
		println(SystemUtils.envVariableValue("${test1234:Hello world!}"));
	}

	public static void main(String[] args) {
		TestExecutor.run(EnvVariableValueTest.class);
	}
}