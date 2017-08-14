package devutility.internal.service.basic.util.stream;

import java.util.Arrays;

import devutility.internal.test.BaseService;

public class MapService extends BaseService {
	private String[] array;

	public MapService(String[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		Arrays.stream(array).map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
	}
}