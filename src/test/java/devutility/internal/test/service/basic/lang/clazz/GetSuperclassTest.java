package devutility.internal.test.service.basic.lang.clazz;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetSuperclassTest extends BaseTest {
	@Override
	public void run() {
		Class<?> superClass = Student.class.getSuperclass();
		println(String.format("superClass.getCanonicalName(): %s", superClass.getCanonicalName()));

		Class<?> superSuperClass = superClass.getSuperclass();
		println(String.format("superSuperClass.getCanonicalName(): %s", superSuperClass.getCanonicalName()));

		Class<?> superSuperSuperClass = superSuperClass.getSuperclass();

		if (superSuperSuperClass == null) {
			println("superSuperSuperClass == null");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetSuperclassTest.class);
	}
}