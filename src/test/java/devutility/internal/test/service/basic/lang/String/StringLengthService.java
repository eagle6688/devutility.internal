package devutility.internal.test.service.basic.lang.String;

import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class StringLengthService extends BaseService {
	@Override
	public void run() {
		String str1 = "asd!";
		println("length of string is: %s", str1.length());
		println("length of string bytes is: %d", str1.getBytes().length);

		String str2 = "ÄãºÃ£¡";
		println("length of string is: %s", str2.length());
		println("length of string bytes is: %d", str2.getBytes().length);
	}
	
	public static void main(String[] args) {
		ServiceExecutor.run(StringLengthService.class);
	}
}