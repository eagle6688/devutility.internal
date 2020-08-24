package devutility.internal.basic.lang.string;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

/**
 * @Description: StringLengthService
 * @author: Aldwin
 */
public class StringLengthTest extends BaseTest {
	@Override
	public void run() {
		test("a");
		test("asd!");
		test("��ã�");
	}

	void test(String value) {
		println("length of string is: %s", value.length());
		println("length of string bytes is: %d", value.getBytes().length);
	}

	public static void main(String[] args) {
		TestExecutor.run(StringLengthTest.class);
	}
}