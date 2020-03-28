package devutility.internal.system;

import devutility.internal.com.SystemUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SystemHelperTest extends BaseTest {
	@Override
	public void run() {
		int count = SystemUtils.processorsCount();
		println(count);

		int porperCount = SystemUtils.properProcessorsCount();
		println(porperCount);
	}

	public static void main(String[] args) {
		TestExecutor.run(SystemHelperTest.class);
	}
}