package devutility.internal.test.service.basic.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class FilterTest extends BaseTest {
	@Override
	public void run() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> result = list.stream().filter(i -> i == 8).map(i -> i).collect(Collectors.toList());
		println(result.size());
	}

	public static void main(String[] args) {
		TestExecutor.run(FilterTest.class);
	}
}