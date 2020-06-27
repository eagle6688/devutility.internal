package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class Get_Version_Test extends BaseTest {
	@Override
	public void run() {
		long version = System.currentTimeMillis();
		long sleepMillis = 2000L;

		test(version, version + 1000, sleepMillis);
		test(version, version, sleepMillis);
		test(version, version - 1, sleepMillis);
	}

	void test(long version, long lastVersion, long sleepMillis) {
		String key = this.getClass().getName();
		List<Integer> list = IntegerData.list(10);

		if (MemoryCache.set(key, list, 0, version)) {
			println("Save data successfully!");
		}

		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key, lastVersion);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(Get_Version_Test.class);
	}
}