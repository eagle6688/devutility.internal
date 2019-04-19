package devutility.internal.test.cache.memory;

import java.util.List;

import devutility.internal.cache.MemoryCache;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.IntegerData;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		String key = GetTest.class.getName();
		List<Integer> list = IntegerData.list(10);

		if (MemoryCache.set(key, list, 6)) {
			println("Save successful!");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Integer> cache = MemoryCache.list(key, Integer.class);
		System.out.println(cache);
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}