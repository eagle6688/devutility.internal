package devutility.internal.test.basic.util.array;

import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CopyOfRangeTest extends BaseTest {
	@Override
	public void run() {
		String[] array = { "1", "2", "3" };
		String value = Arrays.toString(Arrays.copyOfRange(array, 0, 1));
		println(value);
	}

	public static void main(String[] args) {
		TestExecutor.run(CopyOfRangeTest.class);
	}
}