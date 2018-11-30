package devutility.internal.test.service.cache.memory;

import java.util.ArrayList;
import java.util.List;

import devutility.internal.cache.MemoryCache;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		String key = GetTest.class.getName();

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		if (MemoryCache.set(key, numbers, 6)) {
			println("success!");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Integer> cache = MemoryCache.<Integer>getList(key);
		System.out.println(cache);
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}