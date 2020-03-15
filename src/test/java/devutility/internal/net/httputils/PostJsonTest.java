package devutility.internal.net.httputils;

import java.io.IOException;

import devutility.internal.net.HttpUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class PostJsonTest extends BaseTest {
	@Override
	public void run() {
		try {
			String result = HttpUtils.postJson("http://localhost:9080/products/search?pageIndex=1&pageSize=10", "{}", 1000 * 30).getResponse();
			println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(PostJsonTest.class);
	}
}