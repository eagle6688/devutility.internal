package devutility.internal.test.service.lang.stringhelper;

import devutility.internal.lang.StringHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TrimEndTest extends BaseTest {
	@Override
	public void run() {
		println(StringHelper.trimEnd("asdqwe", "qwe"));
	}

	public static void main(String[] args) {
		TestExecutor.run(TrimEndTest.class);
	}
}