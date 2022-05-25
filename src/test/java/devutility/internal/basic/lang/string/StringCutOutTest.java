package devutility.internal.basic.lang.string;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class StringCutOutTest extends BaseTest {
	@Override
	public void run() {
		String fileName = "asd.txt";
		super.println(fileName.substring(0, fileName.lastIndexOf('.')));
	}

	public static void main(String[] args) {
		TestExecutor.run(StringCutOutTest.class);
	}
}