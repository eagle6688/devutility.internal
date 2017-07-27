package devutility.internal.util;

import java.util.ArrayList;

public class ArrayHelper {
	public static ArrayList<Integer> toIntegerArrayList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i : array) {
			list.add(i);
		}

		return list;
	}
}