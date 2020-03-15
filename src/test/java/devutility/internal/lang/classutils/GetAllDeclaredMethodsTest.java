package devutility.internal.lang.classutils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Student;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

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