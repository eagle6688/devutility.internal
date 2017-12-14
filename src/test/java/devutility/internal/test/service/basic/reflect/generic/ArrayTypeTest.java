package devutility.internal.test.service.basic.reflect.generic;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ArrayTypeTest extends BaseTest {
	@Override
	public void run() {
		println(String[].class.getName());
		println(String[][].class.getName());
	}

	public static void main(String[] args) {
		TestExecutor.run(ArrayTypeTest.class);
	}
}