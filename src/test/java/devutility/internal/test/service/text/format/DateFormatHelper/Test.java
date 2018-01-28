package devutility.internal.test.service.text.format.DateFormatHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.text.format.DateFormatHelper;

public class Test extends BaseTest {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(DateFormatHelper.STANDARDATETIMEFORMAT);

		try {
			Date date = simpleDateFormat1.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormatHelper.STANDARDATEFORMAT);

		try {
			Date date = simpleDateFormat2.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(Test.class);
	}
}