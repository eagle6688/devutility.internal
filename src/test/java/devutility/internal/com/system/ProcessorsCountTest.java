package devutility.internal.com.system;

import devutility.internal.com.SystemUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ProcessorsCountTest extends BaseTest {
	@Override
	public void run() {
		println(SystemUtils.processorsCount());
	}

	public static void main(String[] args) {
		TestExecutor.run(ProcessorsCountTest.class);
	}
}