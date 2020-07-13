package devutility.internal.basic.lang.clazz;

import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IsAssignableFromTest extends BaseTest {
	@Override
	public void run() {
		System.out.println(Member.class.isAssignableFrom(Member.class));
	}

	public static void main(String[] args) {
		TestExecutor.run(IsAssignableFromTest.class);
	}
}