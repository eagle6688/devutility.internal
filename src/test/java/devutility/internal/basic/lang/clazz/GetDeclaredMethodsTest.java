package devutility.internal.basic.lang.clazz;

import java.lang.reflect.Method;

import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

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