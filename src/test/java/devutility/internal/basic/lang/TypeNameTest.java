package devutility.internal.basic.lang;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TypeNameTest extends BaseTest {
	@Override
	public void run() {
		println(Short.class.getName());
		println(Float.class.getName());
		println(Integer.class.getName());
		println(Long.class.getName());
		println(Double.class.getName());
	}

	public static void main(String[] args) {
		TestExecutor.run(TypeNameTest.class);
	}
}