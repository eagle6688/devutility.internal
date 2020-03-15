package devutility.internal.lang.classutils;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class NewInstanceTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Student student = ClassUtils.instance(clazz);
		System.out.println(String.format("student.getClass().getCanonicalName(): %s", student.getClass().getCanonicalName()));
	}

	public static void main(String[] args) {
		TestExecutor.run(NewInstanceTest.class);
	}
}