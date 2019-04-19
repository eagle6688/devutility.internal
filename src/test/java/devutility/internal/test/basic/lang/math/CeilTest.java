package devutility.internal.test.basic.lang.math;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CeilTest extends BaseTest {
	@Override
	public void run() {
		println(String.valueOf(Math.ceil(1 / 3)));

		int mod = 1 % 3;

		if (mod > 0) {
			println(String.valueOf(1 / 3 + 1));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CeilTest.class);
	}
}