package devutility.internal.test.models;

import java.util.LinkedList;
import java.util.List;

import devutility.internal.util.RandomUtils;

public class IntegerData {
	public static List<Integer> list(int count) {
		List<Integer> list = new LinkedList<>();

		for (int i = 0; i < count; i++) {
			int value = RandomUtils.getNumber(count);
			list.add(value);
		}

		return list;
	}
}