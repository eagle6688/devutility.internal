package devutility.internal.test.service.data.codec.base64helper;

import devutility.internal.data.codec.Base64Utils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EncodeTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hellp World!Hello World!";
		byte[] bytes = value.getBytes();
		byte[] base64Bytes = Base64Utils.encode(bytes);
		String base64String = new String(base64Bytes);
		println(base64String);
	}

	public static void main(String[] args) {
		TestExecutor.run(EncodeTest.class);
	}
}