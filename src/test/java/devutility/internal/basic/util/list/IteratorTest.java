package devutility.internal.basic.util.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("world!");
		list.add("hello");
		list.add("java!");

		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			String element = iterator.next();

			if ("Hello".equals(element)) {
				iterator.remove();
			}
		}

		System.out.println(list.toString());
	}
}