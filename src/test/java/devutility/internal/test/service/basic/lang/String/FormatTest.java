package devutility.internal.test.service.basic.lang.String;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class FormatTest extends BaseTest {
	@Override
	public void run() {
		String value = String.format("%s_%s", "haha", "%s");
		println(value);

		String value1 = String.format(value, "asd");
		println(value1);
	}

	public static void main(String[] args) {
		TestExecutor.run(FormatTest.class);
	}
}