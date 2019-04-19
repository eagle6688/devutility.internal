package devutility.internal.test.text.format.dateformatutils;

import java.text.SimpleDateFormat;
import java.util.Locale;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.internal.text.format.DateFormatUtils;

public class GetSimpleDateFormatTest extends BaseTest {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = DateFormatUtils.getSimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

		if (simpleDateFormat == null) {
			println("Null");
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		println("Get SimpleDateFormat completely!");
	}

	public static void main(String[] args) {
		TestExecutor.concurrentRun(100, GetSimpleDateFormatTest.class, (data) -> {
			System.out.println(data);
		});
	}
}