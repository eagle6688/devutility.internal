package devutility.internal.test.service.basic.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class SimpleDateFormatTest extends BaseService {
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//simpleDateFormat.setLenient(true);
		
		try {
			println(simpleDateFormat.parse("2015/6/4 0:00:00").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServiceExecutor.run(SimpleDateFormatTest.class);
	}
}