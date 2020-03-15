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
		String str1 = "asd!";
		println("length of string is: %s", str1.length());
		println("length of string bytes is: %d", str1.getBytes().length);

		String str2 = "��ã�";
		println("length of string is: %s", str2.length());
		println("length of string bytes is: %d", str2.getBytes().length);
	}

	public static void main(String[] args) {
		TestExecutor.run(StringLengthTest.class);
	}
}