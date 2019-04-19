package devutility.internal.test.data.constants;

import devutility.internal.data.converter.Converter;

public class GenderConverter implements Converter<String, Gender> {
	@Override
	public Gender convert(String value) {
		return Gender.parse(value);
	}
}