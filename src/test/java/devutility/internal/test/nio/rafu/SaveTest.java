package devutility.internal.test.nio.rafu;

import java.io.IOException;

import devutility.internal.nio.RandomAccessFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SaveTest extends BaseTest {
	private String file = "E:\\Test\\1.txt";
	private String content = "Hello world! 大家好！";

	@Override
	public void run() {
		try {
			RandomAccessFileUtils.save(file, content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(SaveTest.class);
	}
}