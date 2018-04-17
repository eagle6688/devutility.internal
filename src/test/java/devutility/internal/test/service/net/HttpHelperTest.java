package devutility.internal.test.service.net;

import java.io.IOException;

import devutility.internal.net.HttpUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class HttpHelperTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(HttpUtils.get("http://www.baidu.com"));
			println(HttpUtils.postJson("http://localhost:9080/products/search?pageIndex=1&pageSize=10", "{}", 1000 * 30));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(HttpHelperTest.class);
	}
}