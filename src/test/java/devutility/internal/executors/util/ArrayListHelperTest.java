package devutility.internal.executors.util;

import java.util.ArrayList;

import devutility.internal.service.util.ArrayListHelper.ConvertToIntArrayService;
import devutility.internal.test.ServiceExecutor;

public class ArrayListHelperTest {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		ServiceExecutor.run(new ConvertToIntArrayService(numbers));
	}
}