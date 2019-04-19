package devutility.internal.test.io.fileutils;

import java.io.FileNotFoundException;

import devutility.internal.io.FileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CreateTest extends BaseTest {
	@Override
	public void run() {
		try {
			FileUtils.create("E:\\Downloads\\test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(CreateTest.class);
	}
}