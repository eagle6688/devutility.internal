package devutility.internal.test.cache.memory;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.cache.MemoryCache;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SetTest extends BaseTest {
	@Override
	public void run() {
		List<String> list = new ArrayList<String>();
		System.out.println(MemoryCache.set("test", list));
	}

	public static void main(String[] args) {
		TestExecutor.run(SetTest.class);
	}
}