package devutility.internal.system;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class CPUTest extends BaseTest {
	@Override
	public void run() {
		int coreCount = Runtime.getRuntime().availableProcessors();
		println(coreCount);
	}

	public static void main(String[] args) {
		TestExecutor.run(CPUTest.class);
	}
}