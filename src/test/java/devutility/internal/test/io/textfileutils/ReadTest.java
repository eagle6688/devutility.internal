package devutility.internal.test.io.textfileutils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ReadTest extends BaseTest {
	private String path = "E:\\Downloads\\Test.txt";

	@Override
	public void run() {
		try {
			String content = TextFileUtils.read(path, StandardCharsets.UTF_8);
			println(content);

			if (content == null) {
				println(String.format("Cannot found %s.", path));
				return;
			}

			String[] array = content.split("\\PL+");
			List<String> words = Arrays.asList(array);
			System.out.println(words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ReadTest.class);
	}
}