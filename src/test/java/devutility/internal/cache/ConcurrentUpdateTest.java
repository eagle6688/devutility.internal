package devutility.internal.cache;

import devutility.internal.model.Member;
import devutility.internal.response.EasyResponse;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConcurrentUpdateTest extends BaseTest {
	private static String key = UpdateTest.class.getName();

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		CacheEntry<Member> cacheEntry = MemoryCache.getEntry(key);
		Member member = cacheEntry.getValue();
		System.out.printf("Thread: %s, member: %s\n", threadName, member);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		EasyResponse response = MemoryCache.modify(key, Member.list(1).get(0), cacheEntry.getVersion());
		System.out.printf("Thread: %s, result: %s, message: %s\n", threadName, response.isSucceeded(), response.getMessage());
	}

	public static void main(String[] args) {
		MemoryCache.set(key, Member.get(), 0, System.currentTimeMillis());

		TestExecutor.concurrentRun(10, ConcurrentUpdateTest.class, i -> {
			println("Finished");
		});
	}
}