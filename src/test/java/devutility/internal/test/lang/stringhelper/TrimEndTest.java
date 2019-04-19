package devutility.internal.test.lang.stringhelper;

import devutility.internal.lang.StringUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TrimEndTest extends BaseTest {
	@Override
	public void run() {
		println(StringUtils.trimEnd("asdqwe", "qwe"));
	}

	public static void main(String[] args) {
		TestExecutor.run(TrimEndTest.class);
	}
}