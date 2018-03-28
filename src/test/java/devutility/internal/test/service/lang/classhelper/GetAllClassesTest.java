package devutility.internal.test.service.lang.classhelper;

import java.util.List;

import devutility.internal.lang.ClassHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetAllClassesTest extends BaseTest {
	@Override
	public void run() {
		List<Class<?>> list = ClassHelper.getAllClasses(Student.class);

		list.forEach(i -> {
			println(i.getCanonicalName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllClassesTest.class);
	}
}