package devutility.internal.test.service.net;

import devutility.internal.net.URLCoderHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class URLCoderHelperTest extends BaseTest {
	@Override
	public void run() {
		println(URLCoderHelper.encode("asd"));
		println(URLCoderHelper.encode("123"));
		println(URLCoderHelper.encode("你好！"));
	}

	public static void main(String[] args) {
		TestExecutor.run(URLCoderHelperTest.class);
	}
}