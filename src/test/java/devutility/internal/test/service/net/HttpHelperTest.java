package devutility.internal.test.service.net;

import devutility.internal.net.HttpHelper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HttpHelperTest extends BaseTest {
	@Override
	public void run() {
		println(HttpHelper.get("http://www.baidu.com"));
		println(HttpHelper.postJson("http://localhost:9080/products/search?pageIndex=1&pageSize=10", "{}", 1000 * 30));
	}

	public static void main(String[] args) {
		TestExecutor.run(HttpHelperTest.class);
	}
}