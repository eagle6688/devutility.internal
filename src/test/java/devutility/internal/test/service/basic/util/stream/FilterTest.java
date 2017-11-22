package devutility.internal.test.service.basic.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class FilterTest extends BaseService {
	@Override
	public void run() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> result = list.stream().filter(i -> i == 8).map(i -> i).collect(Collectors.toList());
		println(result.size());
	}

	public static void main(String[] args) {
		ServiceExecutor.run(FilterTest.class);
	}
}