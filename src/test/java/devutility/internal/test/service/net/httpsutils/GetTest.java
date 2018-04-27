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
			println(HttpsUtils.get("https://gateway-pre.earth-us.xpaas.lenovo.com/subscription/orders?rrCustomerNumber=401&page=0&size=20", "TLS"));
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}