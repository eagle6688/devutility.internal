package devutility.internal.test.service.net.httputils;

import java.io.IOException;

import devutility.internal.net.HttpUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		try {
			println(HttpUtils.get("https://www.baidu.com"));
			println(HttpUtils.getJson("http://10.62.100.222:8086/subscription/orders?rrCustomerNumber=401&page=0&size=20"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}