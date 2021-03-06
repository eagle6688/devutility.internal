package devutility.internal.basic.reflect.method;

import java.lang.reflect.Method;

import devutility.internal.annotation.Ignore;
import devutility.internal.model.StudentSearchParam;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IsAnnotationPresentTest extends BaseTest {
	@Override
	public void run() {
		Method[] methods = StudentSearchParam.class.getDeclaredMethods();
		Method target = null;

		for (Method method : methods) {
			if (method.getName().equals("testAnnotatedMethod")) {
				target = method;
				break;
			}
		}

		if (target == null) {
			println("Method not found!");
			return;
		}

		if (target.isAnnotationPresent(Ignore.class)) {
			println("isAnnotationPresent true!");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(IsAnnotationPresentTest.class);
	}
}