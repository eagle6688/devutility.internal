package devutility.internal.test.service.util.ArrayHelper;

import java.util.ArrayList;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.ArrayHelper;

public class ToIntegerArrayListService extends BaseTest {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ArrayHelper.toIntegerArrayList(array);
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		TestExecutor.run(ToIntegerArrayListService.class);
	}
}