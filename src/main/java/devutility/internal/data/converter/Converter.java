package devutility.internal.data.converter;

/**
 * 
 * Converter interface.
 * 
 * @author: Aldwin Su
 */
public interface Converter<S, T> {
	T convert(S value);
}