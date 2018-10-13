package devutility.internal.test.service.enums;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EnumTest extends BaseTest {
	@Override
	public void run() {
		println(MyEnum.ASD.ordinal());
		println(MyEnum.QWE.ordinal());
		println(MyEnum.UNKNOW.ordinal());

		println(MyEnum.ASD.value);
		println(MyEnum.QWE.value);
		println(MyEnum.UNKNOW.value);

		MyEnum myEnum = MyEnum.parse(11);
		println(myEnum.toString());

		myEnum = MyEnum.valueOf("11");
		println(myEnum.toString());
	}

	public static void main(String[] args) {
		TestExecutor.run(EnumTest.class);
	}
}