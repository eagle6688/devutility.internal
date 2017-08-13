package devutility.internal.service.util.ArrayHelper;

import java.util.ArrayList;

import devutility.internal.test.BaseService;
import devutility.internal.util.ArrayHelper;

public class ConvertToIntegerArrayListService extends BaseService {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ArrayHelper.toIntegerArrayList(array);
		System.out.println(list.toString());
	}
}