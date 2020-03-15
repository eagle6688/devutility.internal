package devutility.internal.basic.math;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AcosTest extends BaseTest {
	@Override
	public void run() {
		Double angrad = Math.acos(0.5);
		System.out.println(angrad);
		System.out.println(Math.toDegrees(angrad));

		angrad = Math.acos(0.6);
		System.out.println(angrad);
		System.out.println(Math.toDegrees(angrad));
	}

	public static void main(String[] args) {
		TestExecutor.run(AcosTest.class);
	}
}