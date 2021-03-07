package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ExpirationTest extends BaseTest {
	@Override
	public void run() {
		println("--------Test1--------");
		test(3000, -500);

		println("--------Test2--------");
		test(3000, 500);
	}

	void test(long expiration, long increment) {
		String key = this.getClass().getName();
		List<Integer> list = IntegerData.list(10);
		MemoryCache.set(key, list, expiration);

		try {
			Thread.sleep(expiration + increment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(ExpirationTest.class);
	}
}