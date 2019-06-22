package devutility.internal.test.basic.lang.string;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ToUpperCaseTest extends BaseTest {
	@Override
	public void run() {
		println("NoSqlSupportDBReadOnly".toUpperCase());
	}

	public static void main(String[] args) {
		TestExecutor.run(ToUpperCaseTest.class);
	}
}