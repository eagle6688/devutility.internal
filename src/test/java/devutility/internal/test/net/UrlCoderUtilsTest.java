package devutility.internal.test.net;

import devutility.internal.net.UrlCoderUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class UrlCoderUtilsTest extends BaseTest {
	@Override
	public void run() {
		println(UrlCoderUtils.encode("asd"));
		println(UrlCoderUtils.encode("123"));
		println(UrlCoderUtils.encode("你好！"));
	}

	public static void main(String[] args) {
		TestExecutor.run(UrlCoderUtilsTest.class);
	}
}