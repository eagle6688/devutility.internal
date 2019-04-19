package devutility.internal.test.net.httpsutils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import devutility.internal.net.HttpResponse;
import devutility.internal.net.HttpsUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetByHeaderTest extends BaseTest {
	@Override
	public void run() {
		String url = "";
		Map<String, String> header = new HashMap<>();
		header.put("Authorization", "");

		try {
			HttpResponse httpResponse = HttpsUtils.get(url, header, "SSL", 0);
			println(httpResponse.getResponse());
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetByHeaderTest.class);
	}
}