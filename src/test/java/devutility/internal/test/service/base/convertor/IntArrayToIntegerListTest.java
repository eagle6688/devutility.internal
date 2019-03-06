package devutility.internal.test.service.base.convertor;

import java.util.ArrayList;

import devutility.internal.base.ConvertorUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IntArrayToIntegerListTest extends BaseTest {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ConvertorUtils.intArrayToIntegerList(array);
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(IntArrayToIntegerListTest.class);
	}
}