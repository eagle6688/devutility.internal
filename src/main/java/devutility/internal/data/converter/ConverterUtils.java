package devutility.internal.data.converter;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import devutility.internal.annotations.Convertor;
import devutility.internal.base.SingletonFactory;

/**
 * 
 * ConverterUtils
 * 
 * @author: Aldwin Su
 */
public class ConverterUtils {
	/**
	 * Cache key format for converter.
	 */
	private final static String CACHEKEYFORMAT_CONVERTER = "Converter-%s-%s";

	/**
	 * Cache key format for converter method.
	 */
	private final static String CACHEKEYFORMAT_CONVERTER_METHOD = "Converter-Method-%s-%s";

	/**
	 * Get cache key for Converter object.
	 * @param sName Name of source Class object.
	 * @param tName Name of target Class object.
	 * @return String
	 */
	public static String getCacheKeyForConverter(String sName, String tName) {
		return String.format(CACHEKEYFORMAT_CONVERTER, sName, tName);
	}

	/**
	 * Get cache key for converter method object.
	 * @param sName Name of source Class object.
	 * @param tName Name of target Class object.
	 * @return String
	 */
	public static String getCacheKeyForConverterMethod(String sName, String tName) {
		return String.format(CACHEKEYFORMAT_CONVERTER_METHOD, sName, tName);
	}

	/**
	 * Find converter by Class object.
	 * @param sClazz: Class object for source type.
	 * @param tClazz: Class object for target type.
	 * @return {@code Converter<S,T>}
	 */
	@SuppressWarnings("unchecked")
	public static <S, T> Converter<S, T> find(Class<S> sClazz, Class<T> tClazz) {
		String key = getCacheKeyForConverter(sClazz.getName(), tClazz.getName());
		return SingletonFactory.get(key, Converter.class);
	}

	/**
	 * Get converter method by provided source Class object and target Class object.
	 * @param sClazz Source Class object.
	 * @param tClazz Target Class object.
	 * @return Method
	 */
	public static <S, T> Method getConverterMethod(Class<S> sClazz, Class<T> tClazz) {
		String key = getCacheKeyForConverterMethod(sClazz.getName(), tClazz.getName());
		Method method = SingletonFactory.get(key, Method.class);

		if (method != null) {
			return method;
		}

		List<Method> methods = new LinkedList<>();
		methods.addAll(Arrays.asList(sClazz.getDeclaredMethods()));
		methods.addAll(Arrays.asList(tClazz.getDeclaredMethods()));

		for (Method convertorMethod : methods) {
			if (convertorMethod.isAnnotationPresent(Convertor.class)) {
				Class<?>[] parameterTypes = convertorMethod.getParameterTypes();
				Class<?> returnType = convertorMethod.getReturnType();

				if (parameterTypes != null && parameterTypes.length == 1 && parameterTypes[0].equals(sClazz) && returnType != null && returnType.equals(tClazz)) {
					method = convertorMethod;
					break;
				}
			}
		}

		if (method != null) {
			SingletonFactory.save(key, method);
		}

		return method;
	}

	/**
	 * Register a converter in System.
	 * @param converter: Converter object.
	 */
	public static <S, T> void register(Converter<S, T> converter) {
		Type[] types = converter.getClass().getGenericInterfaces();
		ParameterizedType parameterizedType = (ParameterizedType) types[0];
		Type[] actualTypes = parameterizedType.getActualTypeArguments();

		String key = getCacheKeyForConverter(actualTypes[0].getTypeName(), actualTypes[1].getTypeName());
		SingletonFactory.save(key, converter);
	}
}