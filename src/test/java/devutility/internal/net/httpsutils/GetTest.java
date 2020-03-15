package devutility.internal.net.httpsutils;

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
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}