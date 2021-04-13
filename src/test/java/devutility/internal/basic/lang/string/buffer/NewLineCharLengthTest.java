package devutility.internal.basic.lang.string.buffer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class NewLineCharLengthTest extends BaseTest {
	@Override
	public void run() {
		StringBuffer message = new StringBuffer();
		message.append("\n");
		println(message.length());
	}

	public static void main(String[] args) {
		TestExecutor.run(NewLineCharLengthTest.class);
	}
}