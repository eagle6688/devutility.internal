package devutility.internal.util;

import java.util.LinkedList;
import java.util.List;

public class ArraysUtils {
	/**
	 * Page array
	 * @param array: Array data
	 * @param pageIndex: Page index, from 1
	 * @param pageSize: Page size
	 * @return String[][]
	 */
	public static String[][] pageArray(String[][] array, int pageIndex, int pageSize) {
		if (array == null || pageIndex < 1 || pageSize < 1) {
			return new String[0][];
		}

		List<String[]> list = new LinkedList<>();
		int start = (pageIndex - 1) * pageSize;
		int end = Math.min(start + pageSize, array.length);

		for (int index = start; index < end; index++) {
			list.add(array[index]);
		}

		return list.toArray(new String[0][]);
	}
}