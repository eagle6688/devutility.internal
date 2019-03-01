package devutility.internal.test.service.enums;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.models.Gender;

public class EnumTest extends BaseTest {
	@Override
	public void run() {
		println(Gender.MALE.ordinal());
		println(Gender.FEMALE.ordinal());
		println(Gender.UNKNOW.ordinal());

		println(Gender.MALE.getValue());
		println(Gender.FEMALE.getValue());
		println(Gender.UNKNOW.getValue());

		Gender gender = Gender.parse(2);
		println(gender.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(EnumTest.class);
	}
}