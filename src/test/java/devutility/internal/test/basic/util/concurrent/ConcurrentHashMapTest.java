package devutility.internal.test.basic.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConcurrentHashMapTest extends BaseTest {
	@Override
	public void run() {
		ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
		hashMap.put(null, null);
	}

	public static void main(String[] args) {
		TestExecutor.run(ConcurrentHashMapTest.class);
	}
}