package devutility.internal.test.lang.classutils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.Student;
import devutility.internal.test.model.constant.Gender;

public class GetAllDeclaredMethodsTest extends BaseTest {
	@Override
	public void run() {
		testEnum();
	}

	void testClass() {
		List<Method> list = ClassUtils.getAllDeclaredMethods(Student.class);

		list.forEach(i -> {
			println(i.getName());
		});
	}

	void testEnum() {
		List<Method> list = Arrays.asList(Gender.class.getDeclaredMethods());

		list.forEach(i -> {
			println(i.getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllDeclaredMethodsTest.class);
	}
}