package devutility.internal.service.basic.util.stream;

import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseService;

public class ForeachService extends BaseService {
	private List<String> list;

	public ForeachService(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		list.parallelStream().forEach(q -> System.out.println(q));
		list.parallelStream().filter(q -> q.length() > 3).forEach(q -> System.out.println(q));

		String[] array = list.toArray(new String[0]);
		Arrays.stream(array).forEach(q -> System.out.println(q));
	}
}