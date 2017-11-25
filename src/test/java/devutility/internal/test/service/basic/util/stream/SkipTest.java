package devutility.internal.test.service.basic.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class SkipTest extends BaseService {
	@Override
	public void run() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> result = list.stream().skip(1).limit(1).collect(Collectors.toList());
		System.out.println(result);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(SkipTest.class);
	}
}