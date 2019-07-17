package devutility.internal.test.basic.lang.bool;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ParseTest extends BaseTest {
	@Override
	public void run() {
		System.out.println(Boolean.valueOf("true"));
		System.out.println(Boolean.valueOf("False"));
		System.out.println(Boolean.valueOf("TRUE"));
	}

	public static void main(String[] args) {
		TestExecutor.run(ParseTest.class);
	}
}