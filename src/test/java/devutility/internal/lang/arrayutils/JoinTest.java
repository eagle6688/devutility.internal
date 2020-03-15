package devutility.internal.lang.arrayutils;

import devutility.internal.lang.ArrayUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class JoinTest extends BaseTest {
	@Override
	public void run() {
		String[] array = { "asd,123", "qwe" };
		println(ArrayUtils.join((Object[]) array, ","));
	}

	public static void main(String[] args) {
		TestExecutor.run(JoinTest.class);
	}
}