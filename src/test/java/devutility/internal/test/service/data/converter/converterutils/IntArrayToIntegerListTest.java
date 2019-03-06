package devutility.internal.test.service.data.converter.converterutils;

import java.util.ArrayList;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IntArrayToIntegerListTest extends BaseTest {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ConverterUtils.intArrayToIntegerList(array);
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(IntArrayToIntegerListTest.class);
	}
}