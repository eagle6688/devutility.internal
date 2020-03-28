package devutility.internal.data.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import devutility.internal.com.SingletonFactory;

/**
 * 
 * ConverterCacheUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-02-17 23:15:22
 */
public class ConverterCacheUtils {
	/**
	 * Cache key format for converter.
	 */
	private final static String CACHEKEYFORMAT_CONVERTER = "Converter-%s-%s";

	/**
	 * Cache key format for method annotated with Convertor.
	 */
	private final static String CACHEKEYFORMAT_CONVERTOR_METHOD = "Convertor-Method-%s-%s";

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
	 * Get cache key for method annotated with Convertor.
	 * @param sName Name of source Class object.
	 * @param tName Name of target Class object.
	 * @return String
	 */
	public static String getCacheKeyForConvertorMethod(String sName, String tName) {
		return String.format(CACHEKEYFORMAT_CONVERTOR_METHOD, sName, tName);
	}

	/**
	 * Register an Converter object in memory.
	 * @param converter Converter object.
	 */
	public static <S, T> void register(Converter<S, T> converter) {
		Type[] types = converter.getClass().getGenericInterfaces();
		ParameterizedType parameterizedType = (ParameterizedType) types[0];
		Type[] actualTypes = parameterizedType.getActualTypeArguments();

		String key = getCacheKeyForConverter(actualTypes[0].getTypeName(), actualTypes[1].getTypeName());
		SingletonFactory.save(key, converter);
	}

	/**
	 * Get Converter object from memory with provided source and target Class objects.
	 * @param sClazz Class object for source type.
	 * @param tClazz Class object for target type.
	 * @return {@code Converter<S,T>}
	 */
	@SuppressWarnings("unchecked")
	public static <S, T> Converter<S, T> getConverterFromCache(Class<S> sClazz, Class<T> tClazz) {
		String key = ConverterCacheUtils.getCacheKeyForConverter(sClazz.getName(), tClazz.getName());
		return SingletonFactory.get(key, Converter.class);
	}
}