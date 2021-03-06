package devutility.internal.basic.lang.clazz;

import java.lang.reflect.Method;

import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetMethodsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());

			Class<?>[] parameterTypes = method.getParameterTypes();

			for (Class<?> parameterType : parameterTypes) {
				println(parameterType.getCanonicalName());
			}
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetMethodsTest.class);
	}
}