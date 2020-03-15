package devutility.internal.data.converter.converterutils;

import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.model.constant.Gender;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class StringToTypeTest extends BaseTest {
	@Override
	public void run() {
		Gender gender = ConverterUtils.stringToType("2", Gender.class);

		if (gender == null) {
			println("Convertor method not found!");
		} else {
			println(gender.name());
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(StringToTypeTest.class);
	}
}