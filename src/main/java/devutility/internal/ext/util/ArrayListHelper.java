package devutility.internal.ext.util;

import java.util.ArrayList;

public class ArrayListHelper {

	// region Convert array list to array

	public static <T> int[] toIntArray(ArrayList<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		}

		int[] array = new int[list.size()];

		list.parallelStream().forEach(i -> {

		});

		return array;
	}

	// endregion
}