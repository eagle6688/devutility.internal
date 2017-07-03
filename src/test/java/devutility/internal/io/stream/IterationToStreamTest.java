package devutility.internal.io.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import devutility.internal.io.TextHelper;

public class IterationToStreamTest {

	public static void main(String[] args) throws IOException {
		String content = TextHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		List<String> words = Arrays.asList(array);
		long count = words.parallelStream().filter(q -> q.length() > 3).count();
		System.out.println(count);

		words.parallelStream().forEach(q -> System.out.println(q));
		words.parallelStream().filter(q -> q.length() > 3).forEach(q -> System.out.println(q));
		Arrays.stream(array).forEach(q -> System.out.println(q));
	}
}