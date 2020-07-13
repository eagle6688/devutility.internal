package devutility.internal.basic.lang.string.buffer;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DeleteCharAtTest extends BaseTest {
	@Override
	public void run() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("asd");
		buffer.deleteCharAt(buffer.length() - 1);
		System.out.println(buffer);
	}

	public static void main(String[] args) {
		TestExecutor.run(DeleteCharAtTest.class);
	}
}