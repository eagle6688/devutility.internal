package devutility.internal.util;

import java.util.LinkedList;
import java.util.List;

public class ArraysUtils {
	/**
	 * Page array
	 * @param array: Array data
	 * @param pageIndex: Page index
	 * @param pageSize: Page size
	 * @return String[][]
	 */
	public static String[][] pageArray(String[][] array, int pageIndex, int pageSize) {
		List<String[]> list = new LinkedList<>();
		int start = pageIndex * pageSize;
		int end = start + pageSize;

		for (int index = start; index < end; index++) {
			list.add(array[index]);
		}

		return list.toArray(new String[0][]);
	}
}