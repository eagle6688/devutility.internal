package devutility.internal.lang.reflect.methodutils;

import java.lang.reflect.Method;

import devutility.internal.lang.reflect.MethodUtils;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

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