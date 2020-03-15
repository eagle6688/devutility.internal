package devutility.internal.basic.math;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class PiTest extends BaseTest {
	@Override
	public void run() {
		System.out.println(Math.PI);
		System.out.println(Math.toDegrees(Math.PI));
	}

	public static void main(String[] args) {
		TestExecutor.run(PiTest.class);
	}
}