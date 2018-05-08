package devutility.internal.test.service.net.httpsutils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import devutility.internal.net.HttpsUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(HttpsUtils.get("https://www.baidu.com", "TLS"));

			String jsonData = "{\"name\": \"test\", \"password\": \"098f6bcd4621d373cade4e832627b4f6\"}";
			String result = HttpsUtils.postJson("https://us-zuul-pre.lmp.xpaas.lenovo.com/recurring-revenue/token", jsonData, "TLS");
			println(result);
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}