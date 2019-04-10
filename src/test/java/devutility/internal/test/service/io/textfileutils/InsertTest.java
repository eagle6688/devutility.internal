package devutility.internal.test.service.io.textfileutils;

import java.io.IOException;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class InsertTest extends BaseTest {
	private String file = "E:\\Test\\Test.txt";

	@Override
	public void run() {
		try {
			TextFileUtils.insert(file, 4, "Hello world!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(InsertTest.class);
	}
}