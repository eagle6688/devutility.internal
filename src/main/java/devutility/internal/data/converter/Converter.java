package devutility.internal.data.converter;

/**
 * 
 * Converter.
 * 
 * @author: Aldwin Su
 * @param {@code <S>} Source type.
 * @param {@code <T>} Target type.
 */
public interface Converter<S, T> {
	T convert(S value);
}