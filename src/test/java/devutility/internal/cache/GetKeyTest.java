package devutility.internal.cache;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetKeyTest extends BaseTest {
	@Override
	public void run() {
		println(MemoryCache.getKey(new GetKeyTest()));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetKeyTest.class);
	}
}