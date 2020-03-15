package devutility.internal.data.converter.converterutils;

import java.util.List;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IntArrayToIntegerListTest extends BaseTest {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		List<Integer> list = ConverterUtils.intArrayToIntegerList(array);
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(IntArrayToIntegerListTest.class);
	}
}