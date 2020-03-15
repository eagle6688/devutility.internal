package devutility.internal.lang.arrayutils;

import devutility.internal.lang.ArrayUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SerializeTest extends BaseTest {
	@Override
	public void run() {
		String[] array = { "asd\",\"123", "asd\\", "qwe", null, "null", "nullnull" };
		println(ArrayUtils.serialize((Object[]) array));
	}

	public static void main(String[] args) {
		TestExecutor.run(SerializeTest.class);
	}
}