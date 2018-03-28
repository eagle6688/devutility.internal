package devutility.internal.test.service.lang.classhelper;

import java.lang.reflect.Method;
import java.util.List;

import devutility.internal.lang.ClassHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Student;

public class GetAllDeclaredMethodsTest extends BaseTest {
	@Override
	public void run() {
		List<Method> list = ClassHelper.getAllDeclaredMethods(Student.class);

		list.forEach(i -> {
			println(i.getName());
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAllDeclaredMethodsTest.class);
	}
}