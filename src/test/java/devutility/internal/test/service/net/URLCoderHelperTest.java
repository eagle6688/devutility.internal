package devutility.internal.test.service.net;

import devutility.internal.net.UrlCoderHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class URLCoderHelperTest extends BaseTest {
	@Override
	public void run() {
		println(UrlCoderHelper.encode("asd"));
		println(UrlCoderHelper.encode("123"));
		println(UrlCoderHelper.encode("你好！"));
	}

	public static void main(String[] args) {
		TestExecutor.run(URLCoderHelperTest.class);
	}
}