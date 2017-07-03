package devutility.internal.io.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import devutility.internal.io.TextHelper;

public class MapTest {

	public static void main(String[] args) throws IOException {
		String content = TextHelper.read("E:\\Downloads\\Test.txt", StandardCharsets.UTF_8);
		String[] array = content.split("\\PL+");
		Arrays.stream(array).map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
	}
}