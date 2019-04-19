package devutility.internal.test.util.random;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.RandomUtils;

public class GetStringTest extends BaseTest {
	@Override
	public void run() {
		println(RandomUtils.getString(128));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetStringTest.class);
	}
}