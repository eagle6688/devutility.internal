package devutility.internal.test.service.basic.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SkipTest extends BaseTest {
	@Override
	public void run() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> result = list.stream().skip(1).limit(1).collect(Collectors.toList());
		System.out.println(result);
	}

	public static void main(String[] args) {
		TestExecutor.run(SkipTest.class);
	}
}