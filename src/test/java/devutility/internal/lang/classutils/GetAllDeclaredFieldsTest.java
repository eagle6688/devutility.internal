package devutility.internal.lang.classutils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.Student;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAllDeclaredFieldsTest extends BaseTest {
	@Override
	public void run() {
		testEnum();
	}

	void testClass() {
		List<Field> list = ClassUtils.getAllDeclaredFields(Student.class);

		list.forEach(i -> {
			println(i.getName());
		});
	}

	void testEnum() {
		List<Field> list = ClassUtils.getAllDeclaredFields(Gender.class);

		list.forEach(i -> {
			println(i.getName());
		});

		println("=======================");
		list = Arrays.asList(Gender.class.getDeclaredFields());

		list.forEach(i -> {
			println(i.getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllDeclaredFieldsTest.class);
	}
}