package devutility.internal.basic.lang;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConvertTest extends BaseTest {
	@Override
	public void run() {
		String value = null;
		Object obj = value;
		System.err.println((String) obj);
	}

	public static void main(String[] args) {
		TestExecutor.run(ConvertTest.class);
	}
}