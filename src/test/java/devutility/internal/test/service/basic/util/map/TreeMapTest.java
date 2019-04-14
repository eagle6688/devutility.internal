package devutility.internal.test.service.basic.util.map;

import java.util.Map.Entry;
import java.util.TreeMap;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TreeMapTest extends BaseTest {
	@Override
	public void run() {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("b", "bbb");
		treeMap.put("a", "aaa");
		treeMap.put("c", "ccc");
		treeMap.put("c", "ccc");

		for (Entry<String, String> entry : treeMap.entrySet()) {
			println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()));
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(TreeMapTest.class);
	}
}