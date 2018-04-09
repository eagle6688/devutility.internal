package devutility.internal.test.service.basic.util;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ListTest extends BaseTest {
	@Override
	public void run() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		System.out.println(list);

		System.out.println(List.class.isAssignableFrom(ArrayList.class));
		System.out.println(ArrayList.class.isAssignableFrom(List.class));

		println(list.getClass().getName());
		println(List.class.getName());
	}

	public static void main(String[] args) {
		TestExecutor.run(ListTest.class);
	}
}