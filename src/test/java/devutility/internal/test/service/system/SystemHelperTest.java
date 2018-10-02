package devutility.internal.test.service.system;

import devutility.internal.base.SystemUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SystemHelperTest extends BaseTest {
	@Override
	public void run() {
		int count = SystemUtils.getProcessorsCount();
		println(count);

		int porperCount = SystemUtils.getProperProcessorsCount();
		println(porperCount);
	}

	public static void main(String[] args) {
		TestExecutor.run(SystemHelperTest.class);
	}
}