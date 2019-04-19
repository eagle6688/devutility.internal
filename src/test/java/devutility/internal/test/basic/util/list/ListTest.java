package devutility.internal.test.basic.util.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ListTest extends BaseTest {
	List<Integer> list = new ArrayList<>();

	@Override
	public void run() {
		list.add(1);
		list.add(2);
		list.add(3);
		remove();

		System.out.println(List.class.isAssignableFrom(ArrayList.class));
		System.out.println(ArrayList.class.isAssignableFrom(List.class));

		println(list.getClass().getName());
		println(List.class.getName());
		addAfterAsListFromArray();
	}

	private void remove() {
		list.remove(0);
		System.out.println(list);
	}

	/**
	 * Does not support add one string into an array.
	 */
	private void addAfterAsListFromArray() {
		String[] array = { "1", "a", "s", "d" };
		List<String> list = Arrays.asList(array);
		list.add("hello");
	}

	public static void main(String[] args) {
		TestExecutor.run(ListTest.class);
	}
}