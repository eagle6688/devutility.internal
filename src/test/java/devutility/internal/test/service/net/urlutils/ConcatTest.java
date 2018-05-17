package devutility.internal.test.service.net.urlutils;

import devutility.internal.net.UrlUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ConcatTest extends BaseTest {
	@Override
	public void run() {
		println(UrlUtils.concat("http://www.baidu.com", "asd", "qwe.png"));
	}

	public static void main(String[] args) {
		TestExecutor.run(ConcatTest.class);
	}
}