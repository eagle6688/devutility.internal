package devutility.internal.test.service.basic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ArrayListTest extends BaseTest {
	@Override
	public void run() {
		// ArrayList
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		System.out.println(numbers);

		println(numbers.getClass().getName());
		println(numbers instanceof ArrayList ? "yes" : "no");

		// compare
		if (numbers.get(0) == numbers.get(numbers.size() - 1)) {
			System.out.println("equal!");
		} else {
			System.out.println("not equal!");
		}

		// ArrayList to object array
		Object[] array = numbers.toArray();
		System.out.println(array);
		System.out.println(Arrays.toString(array));

		// instanceof integer
		if (array[0] instanceof Integer) {
			System.out.println("is Integer type.");
		}

		// ArrayList to Integer array
		Integer[] integers = numbers.toArray(new Integer[0]);
		System.out.println(integers);
		System.out.println(Arrays.toString(integers));

		println("Arrays: ");
		List<String[]> list = new ArrayList<>();
		list.add(new String[] { "1", "2", "3", "4" });
		list.add(new String[] { "5", "6", "7", "8" });
		String[][] arrays1 = list.toArray(new String[0][]);

		for (String[] array1 : arrays1) {
			System.out.println(Arrays.toString(array1));
		}

		String[][] arrays2 = new String[0][];

		for (String[] array2 : arrays2) {
			System.out.println(Arrays.toString(array2));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ArrayListTest.class);
	}
}