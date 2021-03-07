package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IdleTimeTest extends BaseTest {
	private String key = this.getClass().getName();

	@Override
	public void run() {
		println("--------Test1--------");
		test(2000, 2001);

		println("--------Test2--------");
		test(2000, 2000);

		println("--------Test3--------");
		test(2000, 1500);
	}

	void test(long maxIdleTime, long sleepMillis) {
		CacheEntry<List<Integer>> cacheEntry = new CacheEntry<List<Integer>>(key, IntegerData.list(10));
		cacheEntry.setMaxIdle(maxIdleTime);
		MemoryCache.set(cacheEntry);

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
		TestExecutor.run(IdleTimeTest.class);
	}
}