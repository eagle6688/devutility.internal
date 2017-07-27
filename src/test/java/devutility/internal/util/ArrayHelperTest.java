package devutility.internal.util;

import java.util.ArrayList;

public class ArrayHelperTest {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		ArrayList<Integer> list = ArrayHelper.toIntegerArrayList(array);
		System.out.println(list.toString());
	}
}