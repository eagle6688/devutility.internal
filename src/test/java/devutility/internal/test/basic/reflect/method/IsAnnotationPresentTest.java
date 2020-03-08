package devutility.internal.test.basic.reflect.method;

import java.lang.reflect.Method;

import devutility.internal.annotation.NeedToken;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.StudentSearchParam;

public class IsAnnotationPresentTest extends BaseTest {
	@Override
	public void run() {
		Method[] methods = StudentSearchParam.class.getDeclaredMethods();
		Method target = null;

		for (Method method : methods) {
			if (method.getName().equals("testNeetToken")) {
				target = method;
				break;
			}
		}

		if (target == null) {
			println("Method not found!");
			return;
		}

		if (target.isAnnotationPresent(NeedToken.class)) {
			println("isAnnotationPresent true!");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(IsAnnotationPresentTest.class);
	}
}