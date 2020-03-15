package devutility.internal.basic.lang.clazz;

import java.lang.reflect.Field;

import devutility.internal.model.Student;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetFieldsTest extends BaseTest {
	@Override
	public void run() {
		Class<Student> clazz = Student.class;
		Field[] fields = clazz.getFields();

		for (Field field : fields) {
			System.out.println(field.getName());
			println(field.getDeclaringClass().getName());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetFieldsTest.class);
	}
}