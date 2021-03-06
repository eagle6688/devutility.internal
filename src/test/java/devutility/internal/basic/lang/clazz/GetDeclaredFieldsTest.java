package devutility.internal.basic.lang.clazz;

import java.lang.reflect.Field;

import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetDeclaredFieldsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Field[] declaredFields = clazz.getDeclaredFields();

		for (Field declaredField : declaredFields) {
			println(String.format("declaredField.getName(): %s", declaredField.getName()));
			println(String.format("declaredField.getClass().getName(): %s", declaredField.getClass().getName()));
			println(String.format("declaredField.getType().getName(): %s", declaredField.getType().getName()));
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