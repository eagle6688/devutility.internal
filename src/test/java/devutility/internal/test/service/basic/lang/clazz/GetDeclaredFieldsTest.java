package devutility.internal.test.service.basic.lang.clazz;

import java.lang.reflect.Field;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetDeclaredFieldsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Field[] declaredFields = clazz.getDeclaredFields();

		for (Field declaredField : declaredFields) {
			System.out.println(declaredField.getName());
		}

		Class<?> superClass = clazz.getSuperclass();
		Field[] superDeclaredFields = superClass.getDeclaredFields();

		for (Field declaredField : superDeclaredFields) {
			System.out.println(declaredField.getName());
		}

		Class<?> superSuperClass = superClass.getSuperclass();

		if (superSuperClass == Object.class) {
			println("superSuperClass = Object.class");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetDeclaredFieldsTest.class);
	}
}