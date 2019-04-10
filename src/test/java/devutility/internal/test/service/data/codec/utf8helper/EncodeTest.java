package devutility.internal.test.service.data.codec.utf8helper;

import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.Utf8Utils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class EncodeTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!大家好！";

		try {
			byte[] bytes = Utf8Utils.encode(value);
			String originalValue = Utf8Utils.decode(bytes);
			println(originalValue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(EncodeTest.class);
	}
}