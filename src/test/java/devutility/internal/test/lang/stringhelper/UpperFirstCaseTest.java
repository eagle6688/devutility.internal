package devutility.internal.test.lang.stringhelper;

import devutility.internal.lang.StringUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UpperFirstCaseTest extends BaseTest {
	@Override
	public void run() {
		println(StringUtils.upperFirstCase("asd"));
	}

	public static void main(String[] args) {
		TestExecutor.run(UpperFirstCaseTest.class);
	}
}