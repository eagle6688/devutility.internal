package devutility.internal.test.enums;

import java.util.Arrays;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.test.data.constants.Gender;

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

		Arrays.asList(Gender.values()).forEach(i -> {
			println(i.name());
		});

		println(Gender.valueOf("MALE").toString());
		println(Gender.valueOf("asd").toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(EnumTest.class);
	}
}