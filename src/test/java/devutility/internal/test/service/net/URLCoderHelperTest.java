package devutility.internal.test.service.net;

import devutility.internal.net.URLCoderHelper;
import devutility.internal.test.BaseService;
import devutility.internal.test.ServiceExecutor;

public class URLCoderHelperTest extends BaseService {
	@Override
	public void run() {
		println(URLCoderHelper.encode("asd"));
		println(URLCoderHelper.encode("123"));
		println(URLCoderHelper.encode("你好！"));
	}

	public static void main(String[] args) {
		ServiceExecutor.run(URLCoderHelperTest.class);
	}
}