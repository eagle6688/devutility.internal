package devutility.internal.test.lang.reflect.methodutils;

import java.lang.reflect.Method;

import devutility.internal.lang.reflect.MethodUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.model.constant.Gender;

public class QuietCallTest extends BaseTest {
	@Override
	public void run() {
		Method[] methods = Gender.class.getDeclaredMethods();
		Method method = MethodUtils.find("parse", methods);

		if (method.getParameterTypes()[0].equals(String.class)) {
			println("Yes");
		} else {
			return;
		}

		Gender gender = MethodUtils.quietCall(method, "2");
		println(gender.name());
	}

	public static void main(String[] args) {
		TestExecutor.run(QuietCallTest.class);
	}
}