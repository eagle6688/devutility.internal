package devutility.internal.cache;

import java.util.List;

import devutility.internal.model.data.IntegerData;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class Get_Expiration_Test extends BaseTest {
	@Override
	public void run() {
		test(3000, -500);
		test(3000, 500);
	}

	void test(long expirationMillis, long increment) {
		String key = this.getClass().getName();
		List<Integer> list = IntegerData.list(10);

		if (MemoryCache.set(key, list, expirationMillis)) {
			println("Save data successfully!");
		}

		try {
			Thread.sleep(expirationMillis + increment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		list = MemoryCache.get(key);
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestExecutor.run(Get_Expiration_Test.class);
	}
}