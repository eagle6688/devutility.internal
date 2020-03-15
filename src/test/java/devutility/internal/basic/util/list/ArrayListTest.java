package devutility.internal.basic.util.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ArrayListTest extends BaseTest {
	private List<Integer> numbers = new ArrayList<>();

	@Override
	public void run() {
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		printArray();
		compareItem();
		convertToArray();
		convertToIntegerArray();
		arrayInList();
	}

	private void printArray() {
		System.out.println(numbers);
		println(numbers.getClass().getName());
		println(numbers instanceof ArrayList ? "yes" : "no");
	}

	private void compareItem() {
		if (numbers.get(0) == numbers.get(numbers.size() - 1)) {
			System.out.println("Equal!");
		} else {
			System.out.println("Not equal!");
		}
	}

	private void convertToArray() {
		Object[] array = numbers.toArray();
		System.out.println(array);
		System.out.println(Arrays.toString(array));

		if (array[0] instanceof Integer) {
			System.out.println("array[0] is Integer type.");
		}
	}

	private void convertToIntegerArray() {
		Integer[] integers = numbers.toArray(new Integer[0]);
		System.out.println(integers);
		System.out.println(Arrays.toString(integers));
	}

	private void arrayInList() {
		println("Arrays: ");
		List<String[]> list = new ArrayList<>();
		list.add(new String[] { "1", "2", "3", "4" });
		list.add(new String[] { "5", "6", "7", "8" });
		String[][] arrays1 = list.toArray(new String[0][]);

		for (String[] array1 : arrays1) {
			System.out.println(Arrays.toString(array1));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ArrayListTest.class);
	}
}