package devutility.internal.test.service.util.ArrayHelper;

import java.util.ArrayList;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.util.ArrayHelper;

public class ToIntegerArrayListService extends BaseService {
	@Override
	public void run() {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ArrayHelper.toIntegerArrayList(array);
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(ToIntegerArrayListService.class);
	}
}