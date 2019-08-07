package devutility.internal.test.basic.lang.string;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * @Description: FormatTest
 * @author: Aldwin
 */
public class FormatTest extends BaseTest {
	@Override
	public void run() {
		String value = String.format("%s_%s", "haha", "%s");
		println(value);

		value = String.format("%s_%s", "haha", null == null ? "" : "asd");
		println(value);

		String value1 = String.format(value, "asd");
		println(value1);
	}

	public static void main(String[] args) {
		TestExecutor.run(FormatTest.class);
	}
}