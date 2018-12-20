package devutility.internal.test.service.cache.memory;

import java.util.List;

import devutility.internal.cache.MemoryCache;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.IntegerData;

public class VersionTest extends BaseTest {
	@Override
	public void run() {
		String key = VersionTest.class.getName();
		List<Integer> list = IntegerData.list(10);
		long timestamp = System.currentTimeMillis();

		if (MemoryCache.set(key, list)) {
			println("Save successful!");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Integer> cache = MemoryCache.list(key, timestamp, Integer.class);
		System.out.println(cache);

		timestamp += 3000;
		cache = MemoryCache.list(key, timestamp, Integer.class);
		System.out.println(cache);
	}

	public static void main(String[] args) {
		TestExecutor.run(VersionTest.class);
	}
}