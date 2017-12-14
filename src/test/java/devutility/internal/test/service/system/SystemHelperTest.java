package devutility.internal.test.service.system;

import devutility.internal.system.SystemHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SystemHelperTest extends BaseTest {
	@Override
	public void run() {
		int count = SystemHelper.getProcessorsCount();
		println(count);

		int porperCount = SystemHelper.getProperProcessorsCount();
		println(porperCount);
	}

	public static void main(String[] args) {
		TestExecutor.run(SystemHelperTest.class);
	}
}