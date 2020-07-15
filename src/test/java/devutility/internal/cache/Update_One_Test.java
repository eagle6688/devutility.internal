package devutility.internal.cache;

import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class Update_One_Test extends BaseTest {
	private static String key = UpdateTest.class.getName();
	private static long version = System.currentTimeMillis();

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		Member member = MemoryCache.get(key, version);
		System.out.printf("Thread: %s, member: %s\n", threadName, member);

		boolean result = MemoryCache.update(key, Member.list(1).get(0), System.currentTimeMillis(), version);
		System.out.printf("Thread: %s, result: %s\n", threadName, result);
	}

	public static void main(String[] args) {
		MemoryCache.set(key, Member.get(), 0, version);

		TestExecutor.concurrentRun(10, Update_One_Test.class, i -> {
			println("Finished");
		});
	}
}