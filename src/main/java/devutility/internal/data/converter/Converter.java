package devutility.internal.data.converter;

public interface Converter<S, T> {
	T convert(S value);
}