package devutility.internal.test.service.basic.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class LinkedHashMapTest extends BaseService {
	@Override
	public void run() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("1", "aa");
		linkedHashMap.put("2", "bb");
		linkedHashMap.put("3", "cc");

		for (Entry<String, String> entry : linkedHashMap.entrySet()) {
			String message = String.format("key: %s, value: %s", entry.getKey(), entry.getValue());
			println(message);
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(LinkedHashMapTest.class);
	}
}