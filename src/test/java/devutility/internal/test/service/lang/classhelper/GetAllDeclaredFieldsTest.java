package devutility.internal.test.service.lang.classhelper;

import java.lang.reflect.Field;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetAllDeclaredFieldsTest extends BaseTest {
	@Override
	public void run() {
		List<Field> list = ClassUtils.getAllDeclaredFields(Student.class);

		list.forEach(i -> {
			println(i.getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllDeclaredFieldsTest.class);
	}
}