package devutility.internal.test.com;

import devutility.internal.com.Config;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EscapeCharacterTest extends BaseTest {
	@Override
	public void run() {
		println(Config.ESCAPECHARACTER.length());
	}

	public static void main(String[] args) {
		TestExecutor.run(EscapeCharacterTest.class);
	}
}