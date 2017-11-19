package devutility.internal.test.service.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;
import devutility.internal.text.format.DateFormatHelper;

public class SimpleDateFormatTest extends BaseService {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatHelper.StandardDateTimeFormat);
		simpleDateFormat.setLenient(true);
		
		try {
			Date date = simpleDateFormat.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			Date date = DateFormatHelper.StandardDateTime_SimpleDateFormat.parse("2017-1-10");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(SimpleDateFormatTest.class);
	}
}