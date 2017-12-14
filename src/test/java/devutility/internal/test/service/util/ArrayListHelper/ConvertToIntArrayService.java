package devutility.internal.test.service.util.ArrayListHelper;

import java.util.ArrayList;
import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.ArrayListHelper;

public class ConvertToIntArrayService extends BaseTest {
	private ArrayList<Integer> list = new ArrayList<>();

	public ConvertToIntArrayService(ArrayList<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			int[] array = ArrayListHelper.toIntArray(list);
			System.out.println(Arrays.toString(array));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		TestExecutor.run(new ConvertToIntArrayService(numbers));
	}
}