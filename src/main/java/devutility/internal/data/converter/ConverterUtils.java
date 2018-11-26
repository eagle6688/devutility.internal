package devutility.internal.data.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import devutility.internal.base.SingletonFactory;

public class ConverterUtils {
	/**
	 * Cache key format for converter.
	 */
	private final static String CACHEKEYFORMAT_CONVERTER = "Converter-%s-%s";

	/**
	 * Get cache key Converter
	 * @param sName
	 * @param tName
	 * @return String
	 */
	private static String getCacheKey_Converter(String sName, String tName) {
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
		String key = getCacheKey_Converter(sClazz.getName(), tClazz.getName());
		return SingletonFactory.get(key, Converter.class);
	}

	/**
	 * Register a converter in System.
	 * @param converter: Converter object.
	 * @param sClazz: Class object for source type.
	 * @param tClazz: Class object for target type.
	 */
	public static <S, T> void register(Converter<S, T> converter) {
		Type[] types = converter.getClass().getGenericInterfaces();
		ParameterizedType parameterizedType = (ParameterizedType) types[0];
		Type[] actualTypes = parameterizedType.getActualTypeArguments();

		String key = getCacheKey_Converter(actualTypes[0].getTypeName(), actualTypes[1].getTypeName());
		SingletonFactory.save(key, converter);
	}
}