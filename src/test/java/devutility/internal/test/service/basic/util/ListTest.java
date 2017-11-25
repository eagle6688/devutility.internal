package devutility.internal.test.service.basic.util;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class ListTest extends BaseService {
	@Override
	public void run() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		System.out.println(list);
	}

	public static void main(String[] args) {
		ServiceExecutor.run(ListTest.class);
	}
}