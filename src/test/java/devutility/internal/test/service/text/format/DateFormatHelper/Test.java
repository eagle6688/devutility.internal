package devutility.internal.test.service.text.format.DateFormatHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.text.format.DateFormatHelper;

public class Test extends BaseService {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(DateFormatHelper.StandardDateTimeFormat);

		try {
			Date date = simpleDateFormat1.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormatHelper.StandardDateFormat);

		try {
			Date date = simpleDateFormat2.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(Test.class);
	}
}