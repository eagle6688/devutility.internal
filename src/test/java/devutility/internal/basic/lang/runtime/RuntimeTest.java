package devutility.internal.basic.lang.runtime;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class RuntimeTest extends BaseTest {
	@Override
	public void run() {
		System.out.print("Xmx=");
		System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

		System.out.print("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
	}

	public static void main(String[] args) {
		TestExecutor.run(RuntimeTest.class);
	}
}