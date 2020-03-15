package devutility.internal.basic.lang.clazz;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EqualsTest extends BaseTest {
	@Override
	public void run() {
		String asd = "";
		println(asd.getClass().equals(String.class) ? "Yes" : "No");
	}

	public static void main(String[] args) {
		TestExecutor.run(EqualsTest.class);
	}
}