package devutility.internal.test.service.util.dateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MinTimeTest extends BaseTest {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date time = simpleDateFormat.parse("0001-01-01 00:00:00");

			/**
			 * -62135798400000
			 */
			System.out.println(time.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(MinTimeTest.class);
	}
}