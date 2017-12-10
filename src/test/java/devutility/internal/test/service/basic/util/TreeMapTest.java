package devutility.internal.test.service.basic.util;

import java.util.Map.Entry;
import java.util.TreeMap;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class TreeMapTest extends BaseService {
	@Override
	public void run() {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("b", "bbb");
		treeMap.put("a", "aaa");
		treeMap.put("c", "ccc");

		for (Entry<String, String> entry : treeMap.entrySet()) {
			println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()));
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(TreeMapTest.class);
	}
}