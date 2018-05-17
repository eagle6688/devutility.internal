package devutility.internal.test.service.lang.stringhelper;

import devutility.internal.lang.StringHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UpperFirstCaseTest extends BaseTest {
	@Override
	public void run() {
		println(StringHelper.upperFirstCase("asd"));
	}

	public static void main(String[] args) {
		TestExecutor.run(UpperFirstCaseTest.class);
	}
}