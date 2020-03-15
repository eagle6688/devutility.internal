package devutility.internal.io.textfileutils;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class AppendLineTest extends BaseTest {
	@Override
	public void run() {
		try {
			TextFileUtils.appendLine("E:\\Test\\Test.txt", "New line!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		println("Append new line completely!");
	}

	public static void main(String[] args) throws Exception {
		TestExecutor.run(AppendLineTest.class);
	}
}