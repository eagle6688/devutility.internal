package devutility.internal.test.service.basic.util.stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextFileHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ForeachService extends BaseTest {
	private List<String> list;

	public ForeachService(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		list.parallelStream().forEach(q -> System.out.println(q));
		list.parallelStream().filter(q -> q.length() > 3).forEach(q -> System.out.println(q));

		String[] array = list.toArray(new String[0]);
		Arrays.stream(array).forEach(q -> System.out.println(q));
	}
	
	public static void main(String[] args) throws Exception {
		String content = TextFileHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		List<String> list = Arrays.asList(array);
		TestExecutor.run(new ForeachService(list));
	}
}