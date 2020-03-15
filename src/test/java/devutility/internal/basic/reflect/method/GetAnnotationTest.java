package devutility.internal.basic.reflect.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import devutility.internal.annotation.NeedToken;
import devutility.internal.model.StudentSearchParam;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetAnnotationTest extends BaseTest {
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

		Annotation annotation = target.getAnnotation(NeedToken.class);

		if (annotation == null) {
			println("Annotation not found!");
			return;
		}

		println(annotation.annotationType().getName());
	}

	public static void main(String[] args) {
		TestExecutor.run(GetAnnotationTest.class);
	}
}