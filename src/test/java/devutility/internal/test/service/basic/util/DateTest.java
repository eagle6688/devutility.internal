package devutility.internal.test.service.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class DateTest extends BaseService {

	@Override
	public void run() {
		Date date = new Date(0);
		println(date.toString());

		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00");
			println(date1.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(DateTest.class);
	}
}