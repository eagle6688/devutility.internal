package devutility.internal.basic.lang.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetConstructorsTest extends BaseTest {
	@Override
	public void run() {
		testEnum();
	}

	void testEnum() {
		List<Constructor<?>> list = Arrays.asList(Gender.class.getDeclaredConstructors());

		list.forEach(i -> {
			println("name: %s", i.getName());
			println("ParameterCount: %s", String.valueOf(i.getParameterCount()));
			List<Parameter> parameters = Arrays.asList(i.getParameters());

			for (Parameter parameter : parameters) {
				println(parameter.getType().getName());
			}

			List<Class<?>> pTypes = Arrays.asList(i.getParameterTypes());

			pTypes.forEach(j -> {
				println(j.getName());
			});
		});
	}

	public static void main(String[] args) {
		TestExecutor.run(GetConstructorsTest.class);
	}
}