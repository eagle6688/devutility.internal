package devutility.internal.test.basic.util.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

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
	}

	public static void main(String[] args) {
		TestExecutor.run(LinkedHashMapTest.class);
	}
}