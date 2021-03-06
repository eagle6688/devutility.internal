package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class VersionTest extends BaseTest {
	@Override
	public void run() {
		long version = System.currentTimeMillis();
		long sleepMillis = 2000L;

		println("--------Test1--------");
		test(version, version + 1000, sleepMillis);

		println("--------Test2--------");
		test(version, version, sleepMillis);

		println("--------Test3--------");
		test(version, version - 1, sleepMillis);
	}

	void test(long version, long lastVersion, long sleepMillis) {
		String key = this.getClass().getName();
		List<Integer> list = IntegerData.list(10);
		MemoryCache.set(key, list, 0, version);

		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(VersionTest.class);
	}
}