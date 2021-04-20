package devutility.internal.oo;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ObjectInheritTest extends BaseTest {
	@Override
	public void run() {
		Face1 obj = new Class2();
		obj.test();
	}

	public static void main(String[] args) {
		TestExecutor.run(ObjectInheritTest.class);
	}
}