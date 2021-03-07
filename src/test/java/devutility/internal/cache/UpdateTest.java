package devutility.internal.cache;

import devutility.internal.model.Member;
import devutility.internal.response.EasyResponse;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UpdateTest extends BaseTest {
	private static String key = UpdateTest.class.getName();

	@Override
	public void run() {
		long targetVersion = 0L;
		String threadName = Thread.currentThread().getName();
		CacheEntry<Member> cacheEntry = MemoryCache.getEntry(key);

		if (cacheEntry != null) {
			targetVersion = cacheEntry.getVersion();
		}

		System.out.printf("Thread: %s, member: %s\n", threadName, cacheEntry != null ? cacheEntry.getValue() : null);
		EasyResponse response = MemoryCache.modify(key, Member.list(1).get(0), System.currentTimeMillis(), targetVersion);
		System.out.printf("Thread: %s, result: %s\n", threadName, response);
	}

	public static void main(String[] args) {
		TestExecutor.concurrentRun(10, UpdateTest.class, i -> {
			println("Finished");
		});
	}
}