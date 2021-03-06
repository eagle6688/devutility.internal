package devutility.internal.data.codec.base64utils;

import devutility.internal.data.codec.Base64Utils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class DecodeTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hellp World!Hello World!";
		byte[] bytes = value.getBytes();
		byte[] base64Bytes = Base64Utils.encode(bytes);
		byte[] originalBytes = Base64Utils.decode(base64Bytes);
		String originalValue = new String(originalBytes);
		println(originalValue);
	}

	public static void main(String[] args) {
		TestExecutor.run(DecodeTest.class);
	}
}