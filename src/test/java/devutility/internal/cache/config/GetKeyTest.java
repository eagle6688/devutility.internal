package devutility.internal.cache.config;

import devutility.internal.cache.CacheConfig;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetKeyTest extends BaseTest {
	@Override
	public void run() {
		println(CacheConfig.getKey(new GetKeyTest()));
	}

	public static void main(String[] args) {
		TestExecutor.run(GetKeyTest.class);
	}
}