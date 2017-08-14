package devutility.internal.executors.basic.util.stream;

import java.nio.charset.StandardCharsets;

import devutility.internal.io.TextHelper;
import devutility.internal.service.basic.util.stream.MapService;
import devutility.internal.test.ServiceExecutor;

public class MapTest {
	public static void main(String[] args) throws Exception {
		String content = TextHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		ServiceExecutor.run(new MapService(array));
	}
}