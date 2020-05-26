package devutility.internal.util.random;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.RandomUtils;

public class GetBooleanTest extends BaseTest {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtils.getBoolean());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetBooleanTest.class);
	}
}