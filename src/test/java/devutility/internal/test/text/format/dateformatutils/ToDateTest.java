package devutility.internal.test.text.format.dateformatutils;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.text.format.DateFormatUtils;

public class ToDateTest extends BaseTest {
	@Override
	public void run() {
		System.out.println(DateFormatUtils.toDate("2017-1-10", DateFormatUtils.STANDARDDATEFORMAT));
		System.out.println(DateFormatUtils.toDate("2017-1-10", DateFormatUtils.STANDARDDATETIMEFORMAT));
	}

	public static void main(String[] args) {
		TestExecutor.run(ToDateTest.class);
	}
}