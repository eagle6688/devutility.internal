package devutility.internal.test.service.lang.reflect.generictypeutils;

import java.lang.reflect.Type;

import devutility.internal.lang.reflect.GenericTypeUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetGenericClassByTypeTest extends BaseTest {
	@Override
	public void run() {
		new GetGenericClassTest_Inherit();
	}

	public static void main(String[] args) {
		TestExecutor.run(GetGenericClassByTypeTest.class);
	}
}

class GetGenericClassTest_Base<T> {
	public GetGenericClassTest_Base() {
		Type type = this.getClass().getGenericSuperclass();
		Class<?> clazz = null;

		try {
			clazz = GenericTypeUtils.getGenericClass(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (clazz != null) {
			System.out.println(clazz.getName());
		}
	}
}

class GetGenericClassTest_Inherit extends GetGenericClassTest_Base<String> {

}