package devutility.internal.lang.classutils;

import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAllClassesTest extends BaseTest {
	@Override
	public void run() {
		List<Class<?>> list = ClassUtils.getSuperClasses(Student.class);

		list.forEach(i -> {
			println(i.getCanonicalName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllClassesTest.class);
	}
}