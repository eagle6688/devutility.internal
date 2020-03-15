package devutility.internal.net.httputils;

import java.io.IOException;

import devutility.internal.net.HttpUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(HttpUtils.get("https://www.baidu.com").getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}