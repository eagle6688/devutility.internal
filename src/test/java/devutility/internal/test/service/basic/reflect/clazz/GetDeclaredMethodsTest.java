package devutility.internal.test.service.basic.reflect.clazz;

import java.lang.reflect.Method;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetDeclaredMethodsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Method[] declaredMethods = clazz.getDeclaredMethods();

		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod.getName());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetDeclaredMethodsTest.class);
	}
}