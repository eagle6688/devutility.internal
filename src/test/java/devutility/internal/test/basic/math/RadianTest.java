package devutility.internal.test.basic.math;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class RadianTest extends BaseTest {
	@Override
	public void run() {
		double radians = test(30);
		System.out.println(radians * 2);
		radians = test(60);

		double radians2 = Math.PI - radians;
		System.out.println(Math.toDegrees(radians2));
	}

	double test(float angdeg) {
		double radians = Math.toRadians(angdeg);
		System.out.println(String.format("Radian of %f degress: ", angdeg) + String.valueOf(Math.sin(radians)));
		return radians;
	}

	public static void main(String[] args) {
		TestExecutor.run(RadianTest.class);
	}
}