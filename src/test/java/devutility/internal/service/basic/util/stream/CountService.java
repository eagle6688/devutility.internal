package devutility.internal.service.basic.util.stream;

import java.util.List;

import devutility.internal.test.BaseService;

public class CountService extends BaseService {
	private List<String> list;

	public CountService(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		long count = list.parallelStream().filter(q -> q.length() > 3).count();
		System.out.println(count);
	}
}