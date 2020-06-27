package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class Get_Idle_Test extends BaseTest {
	private String key = this.getClass().getName();

	@Override
	public void run() {
		test(2000, 2001);
		test(2000, 2000);
		test(2000, 1500);
	}

	void test(long maxIdleMillis, long sleepMillis) {
		CacheEntry<List<Integer>> cacheEntry = new CacheEntry<List<Integer>>(key, IntegerData.list(10));
		cacheEntry.setMaxIdleMillis(maxIdleMillis);

		if (MemoryCache.set(cacheEntry)) {
			println("Save data successfully!");
		}

		List<Integer> list = MemoryCache.get(key);
		System.out.println(list);

		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(Get_Idle_Test.class);
	}
}