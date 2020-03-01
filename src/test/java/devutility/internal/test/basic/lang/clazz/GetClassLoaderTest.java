package devutility.internal.test.basic.lang.clazz;

import java.time.LocalDate;
import java.util.Date;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.Member;

public class GetClassLoaderTest extends BaseTest {
	@Override
	public void run() {
		test(int.class);
		test(Long.class);
		test(Date.class);
		test(LocalDate.class);
		test(Member.class);
	}

	void test(Class<?> clazz) {
		ClassLoader classLoader = clazz.getClassLoader();

		if (classLoader == null) {
			println("No ClassLoader object!");
			return;
		}

		println(classLoader.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(GetClassLoaderTest.class);
	}
}