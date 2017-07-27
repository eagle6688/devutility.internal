package devutility.internal.basic.util;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyTest {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };

		// copy reference
		int[] copiedArrayReference = array;
		copiedArrayReference[0] = 7;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copiedArrayReference));

		// copy array
		int[] copiedArray = Arrays.copyOf(array, array.length);
		copiedArray[0] = 8;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copiedArray));

		// Init a arraylist with an array, but cannot convert for a int array.
		String[] strArray = { "1", "asd", "hello" };
		ArrayList<String> strArrayList = new ArrayList<>(Arrays.asList(strArray));
		strArrayList.set(0, "qwe");
		System.out.println(Arrays.toString(strArray));
		System.out.println(strArrayList);
	}
}