package devutility.internal.test.util.random;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.RandomUtils;

public class GetNumberTest extends BaseTest {
	@Override
	public void run() {
		println("======[8,8]======");

		for (int i = 0; i < 10; i++) {
			println(RandomUtils.getNumber(8, 8));
		}

		println("======[0,1]======");

		for (int i = 0; i < 10; i++) {
			println(RandomUtils.getNumber(0, 1));
		}

		println("======[1,2]======");

		for (int i = 0; i < 10; i++) {
			println(RandomUtils.getNumber(1, 2));
		}

		println("======[1,9]======");

		for (int i = 0; i < 10; i++) {
			println(RandomUtils.getNumber(1, 9));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetNumberTest.class);
	}
}