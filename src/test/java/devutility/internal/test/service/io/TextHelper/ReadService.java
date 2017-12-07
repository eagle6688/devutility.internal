package devutility.internal.test.service.io.TextHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ReadService extends BaseService {
	private String path;

	public ReadService(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		try {
			String content = TextHelper.read(path, StandardCharsets.UTF_8);
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
		ServiceExecutor.run(new ReadService("E:\\Downloads\\Test.txt"));
	}
}