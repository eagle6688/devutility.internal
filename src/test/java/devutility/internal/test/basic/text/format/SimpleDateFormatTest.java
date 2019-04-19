package devutility.internal.test.basic.text.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class SimpleDateFormatTest extends BaseTest {
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
		TestExecutor.run(SimpleDateFormatTest.class);
	}
}