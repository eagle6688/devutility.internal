package devutility.internal.test.service.net.httpsutils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import devutility.internal.net.HttpsUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class PostTest extends BaseTest {
	@Override
	public void run() {
		String url = "";
		String data = "";

		try {
			String result = HttpsUtils.postJson(url, data, "TLS").getResponse();
			println(result);
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(PostTest.class);
	}
}