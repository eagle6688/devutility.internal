package devutility.internal.test.service.data.codec.utf8helper;

import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.UTF8Helper;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EncodeTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!大家好！";

		try {
			byte[] bytes = UTF8Helper.encode(value);
			String originalValue = UTF8Helper.decode(bytes);
			println(originalValue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(EncodeTest.class);
	}
}