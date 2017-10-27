package devutility.internal.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericTypeHelper {
	// region get list type/class by field

	public static Type getListTypeByField(Field field) {
		ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
		Type[] types = parameterizedType.getActualTypeArguments();

		if (types == null || types.length == 0) {
			return null;
		}

		return types[0];
	}

	public static Class<?> getListClassByField(Field field) throws ClassNotFoundException {
		Type type = getListTypeByField(field);

		if (type == null) {
			return null;
		}

		return Class.forName(type.getTypeName());
	}

	// endregion

	// region get list class

	public static Class<?> getListClass(List<?> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}

		return list.get(0).getClass();
	}

	// endregion
}