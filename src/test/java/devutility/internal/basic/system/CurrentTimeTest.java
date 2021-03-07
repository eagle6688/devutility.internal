package devutility.internal.basic.system;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CurrentTimeTest extends BaseTest {
	@Override
	public void run() {
		println(System.currentTimeMillis());
		println(System.nanoTime());
	}

	public static void main(String[] args) {
		TestExecutor.run(CurrentTimeTest.class);
	}
}