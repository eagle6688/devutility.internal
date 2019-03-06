package devutility.internal.test.service.base.convertor;

import devutility.internal.base.ConvertorUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Gender;

public class StringToTypeTest extends BaseTest {
	@Override
	public void run() {
		Gender gender = ConvertorUtils.stringToType("2", Gender.class);

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