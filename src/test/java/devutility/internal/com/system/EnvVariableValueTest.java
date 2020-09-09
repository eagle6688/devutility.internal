package devutility.internal.com.system;

import devutility.internal.com.SystemUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EnvVariableValueTest extends BaseTest {
	@Override
	public void run() {
		println(SystemUtils.environmentVariable("${test123:Hello world!}"));
		println(SystemUtils.environmentVariable("${test123}"));
		println(SystemUtils.environmentVariable("test123"));
		println(SystemUtils.environmentVariable("${test1234:Hello world!}"));
	}

	public static void main(String[] args) {
		TestExecutor.run(EnvVariableValueTest.class);
	}
}