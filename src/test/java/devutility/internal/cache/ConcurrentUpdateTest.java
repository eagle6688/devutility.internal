package devutility.internal.cache;

import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConcurrentUpdateTest extends BaseTest {
	private static String key = UpdateTest.class.getName();

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		CacheEntry<Member> cacheEntry = MemoryCache.getEntry(key);
		Member member = cacheEntry.getValue();
		println("[%s] version: %d, member: %s", threadName, cacheEntry.getVersion(), member);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		update(threadName, cacheEntry.getVersion());
	}

	private void update(String threadName, long version) {
		String format = "[%s] version: %d, member: %s, result: %s, message: %s";
		CacheResponse<Member> response = MemoryCache.modify(key, Member.list(1).get(0), version);
		CacheEntry<Member> newCacheEntry = response.getData();

		if (response.isSucceeded()) {
			println(format, threadName, newCacheEntry.getVersion(), newCacheEntry.getValue(), response.isSucceeded(), response.getMessage());
		} else {
			System.err.println(String.format(format, threadName, newCacheEntry.getVersion(), newCacheEntry.getValue(), response.isSucceeded(), response.getMessage()));
		}
	}

	public static void main(String[] args) {
		MemoryCache.set(key, Member.get(), 0, System.currentTimeMillis());

		TestExecutor.concurrentRun(10, ConcurrentUpdateTest.class, i -> {
			println("Finished");
		});
	}
}