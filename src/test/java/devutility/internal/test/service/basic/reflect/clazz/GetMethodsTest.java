package devutility.internal.test.service.basic.reflect.clazz;

import java.lang.reflect.Method;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetMethodsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetMethodsTest.class);
	}
}