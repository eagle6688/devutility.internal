package devutility.internal.basic.lang;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CurrentTimeMillisTest extends BaseTest {
	@Override
	public void run() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		System.out.println(currentTimeMillis * 10);
		System.out.println(Long.MAX_VALUE);
	}

	public static void main(String[] args) {
		TestExecutor.run(CurrentTimeMillisTest.class);
	}
}