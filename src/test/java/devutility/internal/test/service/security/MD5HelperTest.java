package devutility.internal.test.service.security;

import java.io.UnsupportedEncodingException;

import devutility.internal.data.codec.UTF8Utils;
import devutility.internal.data.converter.ConverterUtils;
import devutility.internal.security.MD5Utils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class MD5HelperTest extends BaseTest {
	@Override
	public void run() {
		String value = "Hello World!";
		println(MD5Utils.encipherToBase64(value));
		println(MD5Utils.encipherToHex(value));

		byte[] bytes = null;

		try {
			bytes = UTF8Utils.encode(value);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		byte[] encipheredBytes = MD5Utils.encipher(bytes);
		println(ConverterUtils.bytesToHex(encipheredBytes));
		println(ConverterUtils.bytesToLong(encipheredBytes));
	}

	public static void main(String[] args) {
		TestExecutor.run(MD5HelperTest.class);
	}
}