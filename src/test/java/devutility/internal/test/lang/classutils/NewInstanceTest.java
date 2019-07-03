package devutility.internal.test.lang.classutils;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.model.Student;

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