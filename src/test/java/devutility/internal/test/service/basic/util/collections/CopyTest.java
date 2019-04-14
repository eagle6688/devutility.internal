package devutility.internal.test.service.basic.util.collections;

import java.util.ArrayList;
import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CopyTest extends BaseTest {
	int[] array = { 1, 2, 3 };

	@Override
	public void run() {
		reference();
		arraysCopyOf();

		// Init a arraylist with an array, but cannot convert for a int array.
		String[] strArray = { "1", "asd", "hello" };
		ArrayList<String> strArrayList = new ArrayList<>(Arrays.asList(strArray));
		strArrayList.set(0, "qwe");
		System.out.println(Arrays.toString(strArray));
		System.out.println(strArrayList);
	}

	private void reference() {
		println("reference");
		int[] copiedArrayReference = array;
		copiedArrayReference[0] = 7;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copiedArrayReference));
	}

	private void arraysCopyOf() {
		int[] copiedArray = Arrays.copyOf(array, array.length);
		copiedArray[0] = 8;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copiedArray));
	}

	public static void main(String[] args) {
		TestExecutor.run(CopyTest.class);
	}
}