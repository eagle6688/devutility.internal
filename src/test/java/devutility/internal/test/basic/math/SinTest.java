package devutility.internal.test.basic.math;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SinTest extends BaseTest {
	@Override
	public void run() {
		double angdeg = 90;
		double radians = Math.toRadians(angdeg);
		System.out.println(Math.sin(radians));
	}

	public static void main(String[] args) {
		TestExecutor.run(SinTest.class);
	}
}