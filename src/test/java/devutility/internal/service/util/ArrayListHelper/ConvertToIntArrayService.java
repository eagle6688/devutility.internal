package devutility.internal.service.util.ArrayListHelper;

import java.util.ArrayList;
import java.util.Arrays;

import devutility.internal.test.BaseService;
import devutility.internal.util.ArrayListHelper;

public class ConvertToIntArrayService extends BaseService {
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
}