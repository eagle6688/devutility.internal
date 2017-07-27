package devutility.internal.ext.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHelperTest {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		int[] array = ArrayListHelper.toIntArray(numbers);
		System.out.println(Arrays.toString(array));
	}
}