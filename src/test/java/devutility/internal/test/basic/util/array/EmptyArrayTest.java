package devutility.internal.test.basic.util.array;

import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EmptyArrayTest extends BaseTest {
	@Override
	public void run() {
		String[][] arrays = new String[0][];

		for (String[] array : arrays) {
			System.out.println(array);
			System.out.println(Arrays.toString(array));
			println(array.length);
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(EmptyArrayTest.class);
	}
}