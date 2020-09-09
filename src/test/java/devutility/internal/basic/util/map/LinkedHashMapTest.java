package devutility.internal.basic.util.map;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class LinkedHashMapTest extends BaseTest {
	@Override
	public void run() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("1", "aa");
		linkedHashMap.put("2", "bb");
		linkedHashMap.put("3", "cc");
		linkedHashMap.put(null, "asd");

		for (Entry<String, String> entry : linkedHashMap.entrySet()) {
			String message = String.format("key: %s, value: %s", entry.getKey(), entry.getValue());
			println(message);
		}

		Map<String, Set<String>> map = new LinkedHashMap<>();
		Set<String> set = new LinkedHashSet<>();
		map.put("asd", set);
		set.add("value1");

		Set<String> mapValue = map.get("asd");
		set.add("value2");
		println("Map value ref:");

		for (String value : mapValue) {
			println(value);
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(LinkedHashMapTest.class);
	}
}