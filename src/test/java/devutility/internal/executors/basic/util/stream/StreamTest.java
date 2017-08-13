package devutility.internal.executors.basic.util.stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextHelper;
import devutility.internal.service.basic.util.stream.*;
import devutility.internal.test.ServiceExecutor;

public class StreamTest {
	public static void main(String[] args) throws Exception {
		String content = TextHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		List<String> list = Arrays.asList(array);
		
		ServiceExecutor.run(new CountService(list));
		ServiceExecutor.run(new ForeachService(list));
		ServiceExecutor.run(ParallelStreamService.class);
	}
}