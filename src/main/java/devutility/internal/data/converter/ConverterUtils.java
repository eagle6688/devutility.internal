package devutility.internal.data.converter;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import devutility.internal.annotations.Convertor;
import devutility.internal.base.SingletonFactory;
import devutility.internal.util.CollectionUtils;

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
	 * Get cache key for Converter
	 * @param sName
	 * @param tName
	 * @return String
	 */
	public static String getCacheKeyForConverter(String sName, String tName) {
		return String.format(CACHEKEYFORMAT_CONVERTER, sName, tName);
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

	public static <S, T> Method getConverterMethod(List<Method> methods, Class<S> sClazz, Class<T> tClazz) {
		for (Method method : methods) {
			if (method.isAnnotationPresent(Convertor.class)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				Class<?> returnType = method.getReturnType();

				if (CollectionUtils.exist(Arrays.asList(parameterTypes), i -> sClazz.equals(i.getClass())) && returnType.equals(tClazz)) {
					return method;
				}
			}
		}

		return null;
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