package devutility.internal.models;

public interface Converter<S, T> {
	T convert(S value);
}