package devutility.internal.test.service.basic.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: CollectionTest
 * @author: Aldwin
 */
public class CollectionTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("world!");
		list.add("Hello");
		list.add("java!");

		// frequency
		System.out.println(Collections.frequency(list, "Hello"));

		// remove if
		list.removeIf(i -> "Hello".equals(i));
		System.out.println(list.toString());
	}
}