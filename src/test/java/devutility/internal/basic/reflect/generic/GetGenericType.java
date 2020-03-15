package devutility.internal.basic.reflect.generic;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetGenericType extends BaseTest {
	static class ParameterizedTypeReference<T> {
		private final Type type;

		public ParameterizedTypeReference() {
			Type superClass = this.getClass().getGenericSuperclass();
			this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
		}

		public Type getType() {
			return type;
		}
	}

	@Override
	public void run() {
		ParameterizedTypeReference<String> reference = new ParameterizedTypeReference<String>() {};
		String typeName = reference.getType().getTypeName();
		println(typeName);
	}

	public static void main(String[] args) {
		TestExecutor.run(GetGenericType.class);
	}
}