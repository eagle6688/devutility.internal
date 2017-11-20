package devutility.internal.test.service.base.Convertor;

import java.text.SimpleDateFormat;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class DateTest extends BaseService {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");

	@Override
	public void run() {
		println(simpleDateFormat.format("2015/6"));
	}

	public static void main(String[] args) {
		ServiceExecutor.run(DateTest.class);
	}
}