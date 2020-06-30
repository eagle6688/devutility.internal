package devutility.internal.basic.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import devutility.internal.lang.ClassUtils;
import devutility.internal.model.BaseResponse;
import devutility.internal.model.Member;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.CollectionUtils;

public class ParameterizedTypeTest extends BaseTest {
	@Override
	public void run() {
		List<Method> methods = ClassUtils.getAllDeclaredMethods(this.getClass());
		test(CollectionUtils.find(methods, i -> "firstMethod".equals(i.getName())));
		test(CollectionUtils.find(methods, i -> "secondMethod".equals(i.getName())));
		test(CollectionUtils.find(methods, i -> "thirdMethod".equals(i.getName())));
	}

	void test(Method method) {
		Class<?> returnType = method.getReturnType();
		System.out.println("Class Name: " + returnType.getName());

		Class<?> componentType = returnType.getComponentType();

		if (componentType != null) {
			System.out.println(componentType.getName());
		}

		test_returnType(method.getGenericReturnType());
	}

	void test_returnType(Type returnType) {
		System.out.println("Type Name: " + returnType.getTypeName());

		if (!(returnType instanceof ParameterizedType)) {
			System.out.println("Type " + returnType.getTypeName() + " is not instanceof ParameterizedType");
			System.out.println("");
			return;
		}

		ParameterizedType parameterizedType = (ParameterizedType) returnType;
		Type rawType = parameterizedType.getRawType();

		if (rawType != null) {
			test_type(rawType);
		}

		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

		if (actualTypeArguments != null) {
			System.out.println("Actual type arguments: " + actualTypeArguments.length);
			Type actualType = actualTypeArguments[0];
			test_type(actualType);
		}

		System.out.println("");
	}

	void test_type(Type type) {
		if (type instanceof Class) {
			System.out.println("Type " + type.getTypeName() + " is instance of Class.");
			Class<?> clazz = (Class<?>) type;

			if (clazz.equals(BaseResponse.class)) {
				System.out.println("Type " + type.getTypeName() + " equals BaseResponse class!");
			}
		} else {
			System.out.println("Type " + type.getTypeName() + " is not instance of Class.");
		}
	}

	public BaseResponse<Member> firstMethod() {
		return null;
	}

	public Member secondMethod() {
		return null;
	}

	public List<Member> thirdMethod() {
		return null;
	}

	public static void main(String[] args) {
		TestExecutor.run(ParameterizedTypeTest.class);
	}
}