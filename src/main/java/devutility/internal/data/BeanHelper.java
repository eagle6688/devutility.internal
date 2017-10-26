package devutility.internal.data;

import java.lang.reflect.Method;

import devutility.internal.lang.StringHelper;

public class BeanHelper {
	// region is setter

	public static boolean isSetter(String methodName, String fieldName) {
		if (StringHelper.isNullOrEmpty(methodName) || StringHelper.isNullOrEmpty(fieldName)) {
			return false;
		}

		return methodName.toLowerCase().equals("set" + fieldName.toLowerCase());
	}

	public static boolean isSetter(Method method, String fieldName) {
		return isSetter(method.getName(), fieldName);
	}

	// endregion

	// region is getter

	public static boolean isGetter(String methodName, String fieldName) {
		if (StringHelper.isNullOrEmpty(methodName) || StringHelper.isNullOrEmpty(fieldName)) {
			return false;
		}

		return methodName.toLowerCase().equals("get" + fieldName.toLowerCase());
	}

	public static boolean isGetter(Method method, String fieldName) {
		return isGetter(method.getName(), fieldName);
	}

	// endregion
}