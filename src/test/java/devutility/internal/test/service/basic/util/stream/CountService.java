package devutility.internal.test.service.basic.util.stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextFileUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CountService extends BaseTest {
	private List<String> list;

	public CountService(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		long count = list.parallelStream().filter(q -> q.length() > 3).count();
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception {
		String content = TextFileUtils.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		List<String> list = Arrays.asList(array);
		TestExecutor.run(new CountService(list));
	}
}