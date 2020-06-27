package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		test(2000);
	}

	void test(long sleepMillis) {
		String key = this.getClass().getName();
		List<Integer> list = IntegerData.list(10);
		MemoryCache.set(key, list);

		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}