package devutility.internal.test.model.converter;

import devutility.internal.data.converter.Converter;
import devutility.internal.test.model.constant.Gender;

public class GenderConverter implements Converter<String, Gender> {
	@Override
	public Gender convert(String value) {
		return Gender.parse(value);
	}
}