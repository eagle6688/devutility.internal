package devutility.internal.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);
		System.out.println(numbers);

		if (numbers.get(0) == numbers.get(numbers.size() - 1)) {
			System.out.println("equal!");
		} else {
			System.out.println("not equal!");
		}

		Object[] array = numbers.toArray();
		System.out.println(array);
		System.out.println(Arrays.toString(array));

		Integer[] integers = numbers.toArray(new Integer[0]);
		System.out.println(integers);
		System.out.println(Arrays.toString(integers));
	}
}