package devutility.internal.util;

import java.util.Arrays;

public class ArraysUtils {
	/**
	 * Page array
	 * @param array: Array data
	 * @param pageIndex: Page index
	 * @param pageSize: Page size
	 * @return String[][]
	 */
	public static String[][] pageArray(String[][] array, int pageIndex, int pageSize) {
		return (String[][]) Arrays.stream(array).skip(pageIndex * pageSize).limit(pageSize).toArray();
	}
}