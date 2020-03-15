package devutility.internal.util.dateutils;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.util.DateUtils;

public class MillisecondsToDaysTest extends BaseTest {
	@Override
	public void run() {
		println(String.valueOf(DateUtils.millisecondsToDays(1)));
		println(String.valueOf(DateUtils.millisecondsToDays(1000 * 60 * 60 * 24)));
		println(String.valueOf(DateUtils.millisecondsToDays(1000 * 60 * 60 * 24 + 1)));
	}

	public static void main(String[] args) {
		TestExecutor.run(MillisecondsToDaysTest.class);
	}
}