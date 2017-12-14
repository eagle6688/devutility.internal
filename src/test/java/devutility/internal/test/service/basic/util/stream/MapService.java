package devutility.internal.test.service.basic.util.stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import devutility.internal.io.TextFileHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MapService extends BaseTest {
	private String[] array;

	public MapService(String[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		Arrays.stream(array).map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
	}
	
	public static void main(String[] args) throws Exception {
		String content = TextFileHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		TestExecutor.run(new MapService(array));
	}
}