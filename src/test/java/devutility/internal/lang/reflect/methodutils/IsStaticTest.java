package devutility.internal.lang.reflect.methodutils;

import java.lang.reflect.Method;

import devutility.internal.lang.reflect.MethodUtils;
import devutility.internal.model.StudentSearchParam;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class IsStaticTest extends BaseTest {
	@Override
	public void run() {
		Method[] methods = StudentSearchParam.class.getDeclaredMethods();
		Method method = MethodUtils.find("testNeetToken", methods);

		if (method == null) {
			println("Method not found!");
		} else {
			println(method.getDeclaringClass().getName());
			println(MethodUtils.isStatic(method) ? "Yes" : "No");
		}

		methods = Gender.class.getDeclaredMethods();
		method = MethodUtils.find("parse", methods);

		if (method == null) {
			println("Method not found!");
		} else {
			println(method.getDeclaringClass().getName());
			println(MethodUtils.isStatic(method) ? "Yes" : "No");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(IsStaticTest.class);
	}
}