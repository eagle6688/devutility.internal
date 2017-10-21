package devutility.internal.test.service.basic.util.stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class MapService extends BaseService {
	private String[] array;

	public MapService(String[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		Arrays.stream(array).map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
	}
	
	public static void main(String[] args) throws Exception {
		String content = TextHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		ServiceExecutor.run(new MapService(array));
	}
}